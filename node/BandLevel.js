const { response } = require('express');
const express = require('express')
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


app.get('/', async function (req, res) {
   console.log('Request processed');
   const response = await fetch('http://localhost:8080/bandLevel',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
});

app.get('/getByID/{bandID}', async function (req, res) {
   console.log('Request processed');
   const response = await fetch('http://localhost:8080/bandLevel/getByID/{bandID}',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
});

app.get('/getByName/{bandName}', async function (req, res) {
   console.log('Request processed');
   const response = await fetch('http://localhost:8080/bandLevel/getByName/{bandName}',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
});
module.export = app
