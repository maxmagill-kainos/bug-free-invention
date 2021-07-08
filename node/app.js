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
   if(session_variables.Employee_ID){
      res.render('index', { Employee_ID : session_variables.Employee_ID, is_Admin : session_variables.is_Admin});
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



app.get('/fromc', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/demo/JSONDemo',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
}); 


app.get('/index', function (req, res) { 
   res.redirect('/')
}); 

app.post('/login', async function (req, res) { 
   session_variables = req.session;
   const rawResponse = await fetch('http://localhost:8080/api/login/AuthLogin', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({Email: req.body.email, Password: encrypt(req.body.password)})
  })
  const responseData = await rawResponse.json()

   if(responseData.Employee_ID){
      session_variables.Employee_ID = responseData.Employee_ID;
      session_variables.is_Admin = responseData.is_Admin;
      res.redirect('index');
   }
   else{
      res.render('login', { error : responseData.response});
   }
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