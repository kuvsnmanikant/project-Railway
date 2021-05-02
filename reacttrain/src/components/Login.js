import React, { useState, useEffect } from 'react'
import axios from 'axios'
import Modal from 'react-bootstrap/Modal'
import Button from 'react-bootstrap/Button'
import Form from 'react-bootstrap/Form'
import './cSs/Login.css'
import { useHistory,Link } from 'react-router-dom';
import { Redirect } from 'react-router'
axios.defaults.withCredentials= true;





function Example(props) {
    const [show, setShow] = useState(false);
    const [loginstatus, setloginstatus]= useState('')
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const history=useHistory()

    useEffect(()=>{
        axios.get('http://localhost:3001/user/getuser1').then((res)=>{
            console.log(res)
            if(res.data.loggedin){
            setloginstatus(res.data.user[0].user_id)}
        })
        handleShow()
    },[])

    const [username, setUser_id] = useState("");
    const [password1, setPassword] = useState("");
    const [redirect, setRedirect] = useState(false);
    const [message, setMessage] = useState("");
    const [administration, setadministration]= useState(false)



    const login1 =() =>{
         axios.post("http://localhost:3001/user/getuser1",{
         //   axios.post("http://localhost:8100/user-service/user/getuser1",{
                // headers:{
                //     "Access-Control-Allow-Credentials": true,
                //     "Access-Control-Allow-Origin":'*',
                //     "Access-Control-Allow-Methods": 'POST, GET, OPTIONS, DELETE, PUT',
                //     "Access-Control-Allow-Headers": "append,delete,entries,foreach,get,has,keys,set,values,Authorization"
                // },
            user_id:username,
            password:password1
        }).then((res)=>{
            
            if(!res.data.auth){
                setadministration(false)
            } else {
                console.log(res);
              //  localStorage.setItem("token","Bearer "+res.data.token)
              localStorage.setItem("token",res.data.token)
              localStorage.setItem("role",res.data.result[0].role)
              localStorage.setItem("man",JSON.stringify(res.data.result[0]))
              history.push(`/`)
                setadministration(true)

            }
        })
    }


    const userAuthentication =() =>{
        axios.get("http://localhost:3001/authenticate",{
            headers:{
                "x-access-token":localStorage.getItem("token"),
            },

        }).then((response)=>{
            console.log(response)
        })
    }

//      const hqwe =() =>{
//    //     axios.get("http://localhost:8091/train/alltrains",{
//             axios.get("http://localhost:8100/hello",{
//             headers:{
//                 "x-access-token":localStorage.getItem("token"),
//             },

//         }).then((response)=>{
//             console.log(response)
//         })
//      }


    const handler = (e) =>{
        login1();
        e.preventDefault();
       


    setRedirect(localStorage.getItem('role') !== null);
        
        // console.log(user_id);
        // console.log(password);
    }

    if(redirect){
        return <Redirect to="/features" />
    }

 
    return (
        <>
            <Modal
                show={show}
                onHide={handleClose}
                backdrop="static"
                keyboard={false}
                
                centered
            >
                <Modal.Header closeButton className="aaaa">
                    <Modal.Title>LOG IN {loginstatus}</Modal.Title>
                </Modal.Header>
                <Modal.Body className="aaaa" >
                    <Form className="form-container">
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>User Id</Form.Label>
                            <Form.Control type="text" placeholder="User Id" onChange={(event) => setUser_id(event.target.value)}/>
                            <Form.Text className="text-muted">
                                We'll never share your userid with anyone else.
                                     </Form.Text>
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" onChange={(event) => setPassword(event.target.value)}/>
                        </Form.Group>
                        {/* <Form.Group controlId="formBasicCheckbox">
                                    <Form.Check type="checkbox" label="Check me out" />
                                </Form.Group> */}
                        <Button variant="primary btn-block" type="submit"  onClick={handler}>
                            log in
                                </Button><br/>
                                <Button variant="outline-info">forgot password</Button>
                                <Button variant="outline-info float-right" >sign up</Button>
                               {/* <a href="signin">    */}
                    </Form>


                </Modal.Body>
                {/* <Modal.Footer className="aaaa">
                    <Button variant="secondary" onClick={handleClose}>
                        Close
            </Button>

                </Modal.Footer> */}
            </Modal>

        </>
    );
}

export default Example