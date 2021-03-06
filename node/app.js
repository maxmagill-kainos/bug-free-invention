const { response, json } = require('express');
const express = require('express')
const session = require('express-session')
const fetch = require('node-fetch')
const app = express()

//Setup Encrypt/Decrypt
const { encrypt, decrypt } = require('../node/cryptography');

//Setup POST data access
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + '/public'));

//Setup Nunjucks
const nunjucks = require('nunjucks');
nunjucks.configure('viewdir', {
   express: app
});

//Setup Session Variables
app.use(session({
   secret: 'XASDASDA',
   resave: true,
   saveUninitialized: true
}));
var session_variables;

app.set('view engine', 'njk');

app.get('/', function (req, res) {
   session_variables = req.session;
   if (session_variables.employeeID) {
      res.render('index', { employeeID: session_variables.employeeID, isAdmin: session_variables.isAdmin });
   }
   else {
      res.render('login');
   }
})
async function SubmitSpecForJob(jobSpec, jobID) {

   let JSONSubmitObject = {
      jobSpec: jobSpec,
      jobID: jobID,
      UniqueIdentifier: session_variables.uniqueIdentifier,
      employeeID: session_variables.employeeID,
   };
   const PostCallToJava = await fetch("http://localhost:8080/api/jobs/submitJobSpec", { method: 'POST', body: JSON.stringify(JSONSubmitObject), headers: { 'Content-Type': 'application/json' } })
   return PostCallToJava.text()
}
app.get('/index', function (req, res) {
   res.redirect('/')
});

app.get('/JobsTable', async function (req, res) {
   const response = await fetch('http://localhost:8080/api/jobs/jobRoles', { method: 'GET', headers: {} })
   const data = await response.json();
   //console.log(data)
   session_variables.isAdmin = 1;
   res.render('listJobRoles', { jobData: data, isAdmin: 1 });// session_variables.isAdmin});
});

app.put('/updateBand', async function (req, res) {
   var body = req.body;
   if (body.bandName.length > 5 && body.bandLevel != 0 && body.bandTraining.length > 0 &&
      body.bandCompetencies.length > 0 && body.bandResponsibilites.length > 0) {
         const rawResponse = await fetch('http://localhost:8080/bandLevel/updateBand/' + body.bandID, {
         method: 'PUT',
         headers: { 'Content-Type': 'application/json' },
         body: JSON.stringify({
            bandID: body.bandID, bandName: body.bandName.trim(), bandLevel: body.bandLevel.trim(),
            bandTraining: body.bandTraining.trim(), bandCompetencies: body.bandCompetencies.trim(), bandResponsibilites: body.bandResponsibilites.trim()
         })
      })

      console.log(req.body.bandName);
      res.json({ message: "Updated Successfully", successful: true });
   }
   else{
   res.json({ message: "Updated Failed", successful: false });
   }
});

app.get('/bandLevel', async function (req, res) {
   const response = await fetch('http://localhost:8080/bandLevel', { method: 'GET', headers: {} })
   const data = await response.json();
   res.render('bandInfo', { bandData: data, isAdmin: session_variables.isAdmin });
});

app.get('/bands', async function (req, res) {
   const response = await fetch('http://localhost:8080/api/demo/bands', { method: 'GET', headers: {} })
   const data = await response.text();
   res.send('<p>' + data + '</p>')
});
app.get('/JobsSpec', async function (req, res) {
   console.log('http://localhost:8080/api/jobs/jobSpec?JobID=' + req.query.jobClicked);
   const response = await fetch('http://localhost:8080/api/jobs/jobSpec?JobID=' + req.query.jobClicked, { method: 'GET', headers: {} })
   const data = await response.text();
   res.redirect(data);
});

app.post('/updateJobRole', async function (req, res) {
   var body = req.body;
   if (body.jobTitle.length > 5 && body.capabilityName.length != 0 && body.bandLevel > 0 &&
      body.bandName.length > 0 && body.familyName != 'Select Family Name' && body.familyName.length > 0 && body.jobSummary.length > 0) {
      const rawResponse = await fetch('http://localhost:8080/api/jobs/updateJobRole', {
         method: 'POST',
         headers: { 'Content-Type': 'application/json' },
         body: JSON.stringify({
            jobID: body.jobID, jobTitle: body.jobTitle.trim(), capabilityName: body.capabilityName.trim(),
            bandName: body.bandName.trim(), bandLevel: body.bandLevel, familyName: body.familyName.trim()
         })
      })
      SubmitSpecForJob(body.jobSummary, body.jobID);
      res.json({ message: "Updated Successfully", successful: true });

   }
   else {
      res.json({ message: "Update Rejected", successful: false });
   }
});


app.post('/login', async function (req, res) {
   session_variables = req.session;
   const rawResponse = await fetch('http://localhost:8080/api/login/AuthLogin', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ Email: req.body.email, Password: encrypt(req.body.password) })
   })
   const responseData = await rawResponse.json()
   if (responseData.employeeID) {
      session_variables.employeeID = responseData.employeeID;
      session_variables.isAdmin = responseData.isAdmin;
      session_variables.uniqueIdentifier = responseData.uniqueIdentifier;
      res.redirect('index');
   }
   else {
      res.render('login', { error: responseData.response });
   }
});



app.post('/SubmitSpecForJob', async function (req, res) {
   SubmitSpecForJob(req, res);
});


app.get('/logout', function (req, res) {
   req.session.destroy(function (err) {
      if (err) {
         console.log(err);
      } else {
         res.redirect('/');
      }
   });
});

app.listen(6555, function () {
   console.log('Express started')
});
