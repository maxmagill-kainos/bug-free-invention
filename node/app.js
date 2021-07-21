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
   secret:'XASDASDA',
   resave: true,
   saveUninitialized: true
}));
var session_variables;

app.set('view engine', 'njk');

app.get('/', function(req, res){
   session_variables = req.session;
   if(session_variables.employeeID){
      res.render('index', { employeeID : session_variables.employeeID, isAdmin : session_variables.isAdmin});
   }
   else{
      res.render('login');
   }
})

app.get('/index', function (req, res) { 
   res.redirect('/')
}); 

app.get('/JobsTable', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/jobs/jobRoles',{method:'GET',headers:{}})
   const data = await response.json();
   console.log(data)
   session_variables.isAdmin =1;
   res.render('listJobRoles', {jobData: data , isAdmin:1});// session_variables.isAdmin});
});


app.get('/bands', async function(req, res){
   console.log("Request processed");
   const response = await fetch('http://localhost:8080/api/demo/bands', {method: 'GET', headers:{}})
   const data = await response.text();
   console.log(response);
   res.send('<p>'+data+'</p>')
   });
app.get('/JobsSpec', async function (req, res) { 
   console.log('Request processed'); 
   console.log('http://localhost:8080/api/jobs/jobSpec?JobID='+req.query.jobClicked);
   const response = await fetch('http://localhost:8080/api/jobs/jobSpec?JobID='+req.query.jobClicked,{method:'GET',headers:{}})
   const data = await response.text();
   res.redirect(data);
}); 

app.post('/updateJobRole', async function (req, res) { 
   var body = req.body;
   if(body.jobTitle.length > 5 && body.capabilityName.length != 0 && body.bandLevel > 0 &&
       body.bandName.length > 0 && body.familyName != 'Select Family Name' && body.familyName.length > 0){
   const rawResponse = await fetch('http://localhost:8080/api/jobs/updateJobRole', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({jobID: body.jobID, jobTitle: body.jobTitle.trim(), capabilityName: body.capabilityName.trim(),
                          bandName: body.bandName.trim(), bandLevel: body.bandLevel, familyName: body.familyName.trim()})
  })
  res.json({message : "Updated Successfully", successful : true});
}
else{
   res.json({message : "Update Rejected", successful : false});
}
}); 


app.post('/login', async function (req, res) { 
   session_variables = req.session;
   const rawResponse = await fetch('http://localhost:8080/api/login/AuthLogin', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({Email: req.body.email, Password: encrypt(req.body.password)})
  })
  const responseData = await rawResponse.json()

   if(responseData.employeeID){
      session_variables.employeeID = responseData.employeeID;
      session_variables.isAdmin = responseData.isAdmin;
      res.redirect('index');
   }
   else{
      res.render('login', { error : responseData.response});
   }
}); 

async function SubmitSpecForJob(req,res){
   console.log(req.body)
   let JSONSubmitObject ={
      JobSpec : req.body.SpecSummaryInput,
      JobID : parseInt(req.body.JobID),
      UniqueIdentifier: session_variables.UniqueIdentifier,
      employeeID:session_variables.employeeID,
   };
   console.log(JSON.stringify(JSONSubmitObject));
   const PostCallToJava = await fetch("http://localhost:8080/api/jobs/submitJobSpec",{method:'POST',body:JSON.stringify(JSONSubmitObject),headers:{ 'Content-Type': 'application/json' }})
   console.log(PostCallToJava.json())
}

app.post('/SubmitSpecForJob',async function(req,res){
   SubmitSpecForJob(req,res);
});


app.get('/logout', function(req, res){
   req.session.destroy(function(err) {
      if(err) {
        console.log(err);
      } else {
        res.redirect('/');
      }
    });
});

app.listen(6555, function() { 
   console.log('Express started') 
});
