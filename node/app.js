const express = require('express')
const session = require('express-session')
const app = express() 

//Setup POST data access
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

//Setup Nunjucks
const nunjucks = require('nunjucks'); 
nunjucks.configure('viewdir', { 
         express: app 
}); 
app.set('view engine', 'njk');

//Setup Session Variables
app.use(session({
   secret:'XASDASDA',
   resave: true,
   saveUninitialized: true
}));
var session_variables;

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

app.get('/index', function (req, res) { 
   res.redirect('/')
}); 

app.post('/login', function (req, res) { 
   session_variables = req.session;
   if(req.body.email == "test" && req.body.password == "password"){
      session_variables.email = req.body.email;
      res.redirect('index')
   }
   else{
      res.render('login', { error : "Incorrect Username or Password"});
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
app.listen(7999, function() { 
   console.log('Express started') 
});