
app.get('/JobsTable', async function (req, res) { 
    console.log('Request processed'); 
    const response = await fetch('http://localhost:8080/api/jobs/jobRoles',{method:'GET',headers:{}})
    const data = await response.json();
    console.log(response)
    res.send('<p>'+data+'</p>');
 }); 
 