const { response } = require('express');
const express = require('express') 
const session = require('express-session')
const fetch = require('node-fetch')
const app = express() 

//Setup Encrypt/Decrypt
const { encrypt, decrypt } = require('../node/cryptography');

//Setup POST data access
app.use(express.json());
app.use(express.urlencoded({ extended: true }));


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
   if(session_variables.email){
      console.log("Email: " + session_variables.email);
      res.render('index', { email : session_variables.email});
   }
   else{
      res.render('login');
   }
})

app.get('/apitest', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/demo/hello-world',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
});
 
app.get('/job-roles', async function(req, res){
   console.log("Request processed");
   const response = await fetch('http://localhost:8080/api/demo/job-roles', {method: 'GET', headers:{}})
   const data = await response.text();
   console.log(response);
   res.send('<p>'+data+'</p>')
});

app.get('/JobsTable', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/jobs/jobRoles',{method:'GET',headers:{}})
   const data = await response.json();
   console.log(data)
   res.render('SpecTable',{data:await data});
}); 

app.get('/JobsSpec', async function (req, res) { 
   console.log('Request processed'); 
   console.log('http://localhost:8080/api/jobs/jobSpec?JobID='+req.query.jobClicked);
   const response = await fetch('http://localhost:8080/api/jobs/jobSpec?JobID='+req.query.jobClicked,{method:'GET',headers:{}})
   const data = await response.text();
   res.redirect(data);
}); 

app.get('/fromc', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/demo/hello-fromc',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
}); 


app.get('/index', function (req, res) { 
   res.redirect('/')
}); 

app.post('/login', function (req, res) { 
   session_variables = req.session;
   if(req.body.email == "test" && encrypt(req.body.password) == encrypt("password")){
      session_variables.email = req.body.email;
      res.redirect('index')
   }
   else{
      res.render('login', { error : "Incorrect Email or Password"});
   }
}); 
app.post('/SubmitSpecForJob',async function(req,res){
   console.log(req.body)
   let JSONSubmitObject ={
      JobSpec : req.body.SpecSummaryInput,
      JobID : parseInt(req.body.JobID)

   }
   console.log(JSON.stringify(JSONSubmitObject));
   const PostCallToJava = await fetch("http://localhost:8080/api/jobs/submitJobSpec",{method:'POST',body:JSON.stringify(JSONSubmitObject),headers:{ 'Content-Type': 'application/json' }})
   console.log(PostCallToJava.json())
})

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
