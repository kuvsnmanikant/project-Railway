import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Modal from 'react-bootstrap/Modal'

import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import './cSs/Signup.css'
import logo0 from './images/formbg.png'
import FormFile from 'react-bootstrap/FormFile'
import { useHistory } from 'react-router-dom';
import AxiosService from '../securitys/AxiosService'
import authService from '../securitys/auth.service'
function Profile() {
    const history=useHistory()
    const [loginstatus, setloginstatus] = useState("")
    const [alertss, setalertss]= useState("")

    useEffect(() => {
        const us = JSON.parse(localStorage.getItem('man'))
        setloginstatus(us)

    }, [])


    
    const handleremove = (e) => {
        e.preventDefault();
       AxiosService.deleteUserAccount(loginstatus.user_id).then((res)=>{
        setalertss("deleted")
        logOut()
       })
    }


    const logOut= ()=>{
        authService.logout();
        history.push(`/home`)
    }

const handleupdate =() =>{
    history.push(`/updateaccount`)
}

const handlehistory =() =>{
    history.push(`/userhistory`)
}

const alerts =() =>{
    if(alertss ==="deleted"){
    return(
        <div class="alert alert-warning" role="alert">
      Successfully delete your account
    </div>)}
}


    const profiles = () => {
        if (loginstatus !== "") {
            return (
                
                <div class="register mani">
                    <div class="row">
                        <div class="col-md-3 register-left">
                            {/* <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/> */}
                            <img src={logo0} alt="" />
                            <h3>Welcome</h3>
                            <p>Thank you for your presence our community</p>
                            <a onClick={logOut}><input type="submit" value="Log Out" /><br /></a>
                        </div>
                        <div class="col-md-9 register-right">
                            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                                <li class="nav-item">
                                    {/* <a class="nav-link"   href="#profile"  >Hirer</a> */}
                                    <marquee class="nav-link" behavior="scroll" direction="left">Welcome  {loginstatus.first_name}  {loginstatus.last_name}</marquee>

                                </li>
                            </ul>
                            <form id="forms">
                                <div className="tab-content" id="myTabContent">
                                    <div className="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <h3 className="register-heading">Profile</h3>
                                        <div className="row register-form">
                                            <div className="col-md-6 border border-dark rounded">
                                                <div class="form-group"><Row>
                                                    <Col>  <label>First Name :</label></Col>
                                                    <Col>{loginstatus.first_name}</Col></Row>
                                                </div>
                                                <div class="form-group">
                                                    <Row>    <Col>   <label>Last Name :</label></Col>
                                                        <Col>{loginstatus.last_name}</Col></Row>
                                                </div>
                                                <div class="form-group">
                                                    <Row>  <Col> <label> User Id :</label>  </Col>
                                                        <Col>{loginstatus.user_id}</Col> </Row> </div>
                                                <div class="form-group">
                                                    <Row>    <Col>  <label>Aadhar Number :</label> </Col>
                                                        <Col>{loginstatus.aadhar}</Col>  </Row>        </div>

                                                <div class="form-group">
                                                    <Row>     <Col>     <label>Role :</label>  </Col>
                                                        <Col>{loginstatus.role}</Col>  </Row>     </div>

                                                <div class="form-group">
                                                    <Row>     <Col>    <label>Gemder :</label></Col>
                                                        <Col>{loginstatus.gender}</Col></Row>
                                                </div>
                                                <div className="form-group">
                                                    <Row>    <Col>      <label>Email :</label>  </Col>
                                                        <Col>{loginstatus.email}</Col>   </Row> </div>

                                            </div>
                                            <div className="col-md-6 border border-dark rounded">

                                                <div class="form-group">
                                                    <Row>   <Col>    <label>Mobile Number :</label> </Col>
                                                        <Col>{loginstatus.mobile}</Col> </Row>    </div>

                                                <div class="form-group">
                                                    <Row> <Col>    <label>BirthDay :</label>     </Col>
                                                        <Col>{loginstatus.birth_day}</Col> </Row> </div>
                                                <div class="form-group">
                                                    <Row> <Col>    <label>Age :</label>      </Col>
                                                        <Col>{loginstatus.age}</Col></Row></div>
                                                <div class="form-group">
                                                    <Row>  <Col>    <label>City :</label>     </Col>
                                                        <Col>{loginstatus.city}</Col></Row>  </div>
                                                <div class="form-group">
                                                    <Row> <Col>  <label>State :</label> </Col>
                                                        <Col>{loginstatus.state}</Col> </Row>  </div>
                                                <div class="form-group">
                                                    <Row>  <Col>   <label>Pin Code :</label> </Col>

                                                        <Col>{loginstatus.pin}</Col> </Row> </div>

                                               
                                            </div>
                                            <Col> <input type="submit" className="btnRegister" value="Remove Account" onClick={handleremove} /></Col>
                                            <Col> <input type="submit" className="btnRegister" value="Update Account" onClick={handleupdate} /></Col>
                                            <Col> <input type="submit" className="btnRegister" value="Booking History" onClick={handlehistory} /></Col>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            )
        }else{
            return(
                <h2  className='text-center'>Plese Log In</h2>
            )
        }
    }






    return (
        <>
        {alerts()}
            {profiles()}
        </>
    )
}

export default Profile
