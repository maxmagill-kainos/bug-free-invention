const { response } = require('express');
const express = require('express') 
const app = express() 
 
app.get('/', function (req, res) { 
   res.send('<h1>First message from Express</h1>') 
   console.log('Request processed'); 
}); 

app.get('/job-roles', async(req, res) => {
   res.render('list-job-roles', {jobRoles: await jobData.getJobRoles()});
})
 
app.listen(7999, function() { 
   console.log('Express started') 
});