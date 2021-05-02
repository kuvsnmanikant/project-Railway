const mysql = require('mysql');
const cors =require("cors");
const express = require('express');
const eureka_connect = require('./Eureka_clinte1');
const app= express();
const bcrypt = require('bcrypt');
const saltRounds= 10;
//const bodyparser= require('body-parser');
const cookieparser= require('cookie-parser');
const session= require('express-session');
const jwt = require('jsonwebtoken');

app.use(express.json());
app.use(cors({
    // origin: ["http://localhost:3000","http://localhost:8100"],
    origin: ["*"],
    methods: ["GET", "POST", "DELETE", "PUT"],
    credentials: true
}));

app.use(cookieparser())
//app.use(bodyParser.urlencoded({extended: true}))
app.use(express.urlencoded({extended: true}));
app.use(session({
    key:"user_id",
    secret:"kemisettyumavijaysainagamanikant",
    resave: false,
    saveUninitialized: false,
    cookie:{
        expires:60*60*24,
    },
}))

const db = mysql.createConnection({
  user: "root",
  password: "Mysql1@",
  host: "localhost",
  database: "trainuser",
  connectionLimit:10
});

app.post('/user/getuser',(req, res)=>{
    const user_id = req.body.user_id;
    const password= req.body.password;
    const first_name= req.body.first_name;
    const last_name= req.body.last_name;
    const gender= req.body.gender;
    const birth_day= req.body.birth_day;
    const age= req.body.age;
    const theme= req.body.theme;
    const role = req.body.role;
    const email= req.body.email;
    const aadhar= req.body.aadhar;
    const mobile= req.body.mobile;
    const city=req.body.city;
    const state= req.body.state;
    const pin = req.body.pin;
    const question= req.body.question;
    const answer= req.body.answer;

    bcrypt.hash(password,saltRounds,(err,hash)=>{

        if(err){
            console.log(err)
        }

        db.query("INSERT INTO users(user_id,password,first_name,last_name,gender,birth_day,age,theme,role,email,aadhar,mobile,city,state,pin,question,answer) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
    [user_id,hash,first_name,last_name,gender,birth_day,age,theme,role,email,aadhar,mobile,city,state,pin,question,answer],
    (err,result)=>{
        if(err){
            res.send({
                err:err
            });
        }
        console.log(err);
    })
    })    
});




app.get("/user/getuser1",(req,res)=>{
    if(req.session.user){
        res.send({loggedin:true, user: req.session.user})
    } else {
        res.send({loggedin:false})
    }
})

const verifyjwt =(req,res,next)=>{
     const token= req.headers["x-access-token"]
  //  const token= req.headers["Barer"]
    if(!token){
        res.send("we need token")
    }else {
        jwt.verify(token,"kemisettyumavijaysainagamanikant",(err, decoded)=>{
            if(err){
                res.json({auth: false, message:"authentication faild"})
            }else{
                req.userid= decoded.id
                next()
            }
        })
    }
}

app.get('/authenticate', verifyjwt, (req,res)=>{
    res.send('authenticated man')
})



app.post('/user/getuser1',(req, res)=>{
    const user_id = req.body.user_id;
    const password= req.body.password;

    db.query(`SELECT * FROM users WHERE user_id = ?`,user_id,(err,result,fields)=>{
       if(err){
            res.send({
                err:err
            });
            return console.log(err);
        }
        
            if (result.length>0){

                bcrypt.compare(password,result[0].password,(err,r)=>{
                    if(r){
                        

                        const id= result[0].user_id
                        const token= jwt.sign({id},"kemisettyumavijaysainagamanikant",{
                            expiresIn: '1h',
                            algorithm: 'HS256'
                        })

                        req.session.user= result
                        // console.log(req.session.user)
                        //res.send(result);
                    res.json({auth: true, token: token, result: result})
                    }
                    else{
                        res.send({message:"wrong credentles"})
                    }
                })



                
            }
            else{
                res.send({message:"there is no such user"})
            }
       // return console.log(result);
    })
})

// it  will all users
app.get('/user/getuserall',(req, res)=>{
    db.query(`SELECT * FROM users`,(err,result,fields)=>{
        if(err){
            return console.log(err);
        }
        res.send(result);
        return console.log(result);
    })
})

//it will delete an employee with given id
app.delete('/user/deleteuser/:id',(req, res)=>{
    db.query(`DELETE FROM users WHERE user_id = ?`,[req.params.id],(err,result,fields)=>{
        if(err){
            return console.log(err);
        }
        res.send("deleted");
        return console.log(result);
    })
})

app.listen(3001,()=>{
  console.log("running");
})

eureka_connect.registerWithEureka('user-service', 3001);