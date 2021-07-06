const { response } = require('express');
const express = require('express') 
const fetch = require('node-fetch')
const app = express() 




app.get('/', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/demo/hello-world',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
}); 

app.get('/JobsTable', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/jobs/jobRoles',{method:'GET',headers:{}})
   const data = await response.json();
   console.log(response)
   res.send(data);
}); 

app.get('/JobsSpec', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/jobs/jobSpec?JobID='+req.query.jobClicked,{method:'GET',headers:{}})
   const data = await response.text();
   res.redirect(data);
}); 



app.listen(6555, function() { 
   console.log('Express started') 
});

app.get('/fromc', async function (req, res) { 
   console.log('Request processed'); 
   const response = await fetch('http://localhost:8080/api/demo/hello-fromc',{method:'GET',headers:{}})
   const data = await response.text();
   console.log(response)
   res.send('<p>'+data+'</p>');
}); 

