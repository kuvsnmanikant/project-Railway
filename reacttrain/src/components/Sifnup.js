import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Modal from 'react-bootstrap/Modal'
import Button from 'react-bootstrap/Button'
import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import './cSs/Signup.css'
import logo0 from './images/formbg.png'
import FormFile from 'react-bootstrap/FormFile'
function Example() {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    axios.defaults.withCredentials= true;

    const [user_id1, setUser_id] = useState("");
    const [password1, setpassword] = useState("");
    const [confirm_password1, setconfirm_password] = useState("");
    const [first_name1, setfirst_name] = useState("");
    const [last_name1, setlast_name] = useState("");
    const [gender1, setgender] = useState("m");
    const [birth_day1, setbirth_day] = useState("");
    const [age1, setage] = useState("");
    const [theme1, settheme] = useState("d");
    const [role1, setrole] = useState("USER");
    const [email1, setemail] = useState("");
    const [aadhar1, setaadhar] = useState("");
    const [mobile1, setmobile] = useState("");
    const [city1, setcity] = useState("");
    const [state1, setstate] = useState("");
    const [pin1, setpin] = useState("");
    const [question1, setquestion] = useState("");
    const [answer1, setanswer] = useState("");
    const [mobil1, setmobil] = useState("");
    const [passerror, setpasserror] = useState("0");
    const [alertss,setalertss]= useState(false)
    // useEffect(() => {
    //     window.addEventListener("beforeunload", alertUser);
    //     // return () => {
    //     //   window.removeEventListener("beforeunload", alertUser);
    //     // };
    //   }, []);
    //   const alertUser = (e) => {
    //     registeration();
    //   };

   

      const registeration =() =>{
          axios.post('http://localhost:3001/user/getuser',{
              user_id:user_id1,
              password:password1,
              first_name:first_name1,
              last_name:last_name1,
              gender:gender1,
              birth_day:birth_day1,
              age:age1,
              theme:theme1,
              role:role1,
              email:email1,
              aadhar:aadhar1,
              mobile:mobile1,
              city:city1,
              state:state1,
              pin:pin1,
              question:question1,
              answer:answer1
             // mobil:mobil1
          }).then((res)=>{
              if(res){
                setalertss(true)
                console.log(res);
              }
              
          })
      }

    const handlesubmit = (e) => {
      
        registeration();
        
        if (validate().length===2) {
             e.preventDefault();
            // setpasserror("password and conform password are not equal")
           
            registeration();

        }
 // e.preventDefault();
    }





    const validate =(a) =>{
        setpasserror("00")
     
        if(first_name1.length<1){
            console.log("1")
            setpasserror("0")
        }
        if(last_name1.length<1){
            setpasserror("0")
            console.log("2")
        }
        if(!user_id1.match(/^[a-zA-Z0-9]{8,15}$/) ){
            setpasserror("0")
            console.log("3")
        }
        if(!aadhar1.match(/^[1-9]{4}-[0-9]{4}-[0-9]{4}$/)){
            setpasserror("0")
            console.log("4")
        }
        if(!password1.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/)){
            setpasserror("0")
            console.log("5")
        }
        if(password1 !== confirm_password1){
            setpasserror("0")
            setmobil("password and conform password are not equal")
            console.log("6")
        }
        if(!email1.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)){
            setpasserror("0")
            console.log("7")
        }
        if(!mobile1.match(/^[1-9]{1,1}[0-9]{9,9}$/)){
            setpasserror("0")
            console.log("8")
        }
        if(age1<18){
            setpasserror("0")
            console.log("9")
        }
        if(city1.length===0){
            setpasserror("0")
            console.log("10")
        }
        if(state1.length===0){
            setpasserror("0")
            console.log("11")
        }
        if(question1.length<2){
            setpasserror("0")
            console.log("12")
        }
        if(answer1.length<1){
            setpasserror("0")
            console.log("13")
        }
        console.log("## "+passerror)

        const aa= passerror
        return aa
    }




const adminornot =() =>{
    if(localStorage.getItem('role')=== "ADMIN"){
        return(
            <div class="form-group">
                                            <select class="form-control" onChange={(e) => setrole(e.target.value)} required>
                                                <option class="hidden" selected disabled>Please select the role</option>
                                                <option value="USER">USER</option>
                                                <option value="ADMIN">ADMIN</option>
                                            </select>
                                        </div>
        )
    }
}



const adminor =() =>{
    if(alertss){
        return(
            <div class="alert alert-success" role="alert">
          Successfully created your account
        </div>)
    }
}







    return (
        <>{adminor()}
            <div class="register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        {/* <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/> */}
                        <img src={logo0} alt="" />
                        <h3>Welcome</h3>
                        <p>Thank you for joining our community</p>
                        <a href="login"><input type="submit" value="Login"  /><br /></a>
                    </div>
                    <div class="col-md-9 register-right">
                        <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                            <li class="nav-item">
                                {/* <a class="nav-link"   href="#profile"  >Hirer</a> */}
                                <marquee class="nav-link" behavior="scroll" direction="left">Welcome  to  India's  best  Railway  Reservation  System</marquee>

                            </li>
                        </ul>
                        <form id="forms">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Sign Up</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="First Name *" onChange={(e) => setfirst_name(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Last Name *" onChange={(e) => setlast_name(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="User Id *" pattern="[a-zA-Z0-9]{8,15}" title="dont use special characters and minimum 8 char" onChange={(e) => setUser_id(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="tel" class="form-control" name="Aadhar" pattern="[1-9]{4}-[0-9]{4}-[0-9]{4}" title="1111-2222-3333" placeholder="Aadhar *" onChange={(e) => setaadhar(e.target.value)} required />
                                        </div>

                                        <div class="form-group">
                                            <input type="password"  class="form-control" placeholder="Password *" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" title="password should contain atleast 1 small letter 1 capital letter 1 number and minimum 8 characters" onChange={(e) => setpassword(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" id="confirm_password1" placeholder="Confirm Password *" onChange={(e) => { setconfirm_password(e.target.value) }} required />
                                        </div>
                                        <div class="text-danger">{mobil1}</div>
                                        <div class="form-group">
                                            <div class="maxl" onChange={(e) => setgender(e.target.value)}>
                                                <label class="radio inline">
                                                    <input type="radio" name="gender" value="m" checked required />
                                                    <span> Male </span>
                                                </label>&emsp;
                                                <label class="radio inline">
                                                    <input type="radio" name="gender" value="f" required />
                                                    <span>Female </span>
                                                </label>&emsp;
                                                <label class="radio inline">
                                                    <input type="radio" name="gender" value="o" required />
                                                    <span>Others </span>
                                                </label>
                                            </div>
                                        </div>
                                        {adminornot()}
                                        <div class="form-group">
                                            <input type="email" class="form-control" placeholder="Your Email *" onChange={(e) => setemail(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="tel" pattern="[1-9]{1,1}[0-9]{9,9}" name="txtEmpPhone" title="it should contain exact 10 digits only" class="form-control" placeholder="Your Phone *" onChange={(e) => setmobile(e.target.value)} required />
                                        </div>
                                    </div>
                                    <div class="col-md-6">

                                        <div class="form-group">
                                            <input type="date" name="begin" id="datepicker" placeholder="dd-mm-yyyy" class="form-control" onChange={(e) => setbirth_day(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control" name="Age" min="18" max="99" placeholder="Age *" title="minimum age must be 18" onChange={(e) => setage(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="City *" onChange={(e) => setcity(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="State *" onChange={(e) => setstate(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control" name="pin" pattern="[5]{1}[1-9]{5}" title="please enter valid pincode having exact 6 digits and starts with 5" placeholder="Pin code *" onChange={(e) => setpin(e.target.value)} required />
                                        </div>
                                        <div class="form-group">
                                            <select class="form-control" onChange={(e) => setquestion(e.target.value)} required>
                                                <option class="hidden" selected disabled>Please select your Sequrity Question</option>
                                                <option>What is your Birthdate?</option>
                                                <option>What is Your old Phone Number</option>
                                                <option>What is your Pet Name?</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Enter Your Answer *" onChange={(e) => setanswer(e.target.value)} required />
                                        </div>
                                        <input type="submit" class="btnRegister" value="Register" onClick={handlesubmit} />
                                    </div>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
         
            </div>

        </>
    );
}

export default Example