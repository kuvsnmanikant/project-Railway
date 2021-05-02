import Button from 'react-bootstrap/Button'
import React, { useState, useEffect } from 'react'
import { Col, Row, Form } from "react-bootstrap";
import AxiosService from '../securitys/AxiosService'
import Table from 'react-bootstrap/Table'
function Status() {
    const [passengerdetails,setpassengerdetails] =useState("")
    const [pnr,setpnr] =useState("")
    const[pnrerror,setpnrerror]= useState("")

    const handlesearch =(e) =>{
        e.preventDefault()
        if(pnr !==""){
            setpnrerror("")
        AxiosService.getPassengerStatus(pnr).then((res)=>{
            if(res !==null){
                setpassengerdetails(res.data);
            }
            console.log(res);
            if(passengerdetails.trani_no ===null){
                alert("you enterd wrong pnr number")
                setpassengerdetails("")
            }
        })
       
    } else{
        setpnrerror("please enter the pnr number")
    }
    }

    const pleaseLogIn = () => {
        if (pnr !=="" && passengerdetails !=="" && passengerdetails.trani_no !==null) {
            return (
                <>
               
                    <div className="form-container2 rounded border border-primary mb-2 ">
                    <Row>
                    <Col>{passengerdetails.trani_no}</Col><Col/><Col>{passengerdetails.train_name}</Col>
                </Row>
                <Row>
                    <Col>{passengerdetails.from}</Col><Col/><Col>{passengerdetails.to}</Col>
                </Row>
                <Row>
                    <Col>{passengerdetails.journey_date}</Col><Col/><Col>{passengerdetails.destination_date}</Col>
                </Row>
                        
                        <Table responsive="sm" className="text-white">
                            <thead>
                                <tr>

                                    <th>Passenger Name</th>
                                    <th>Seat Number</th>
                                    <th>Status</th>
                                
                                </tr>
                            </thead>
                            <tbody>{
                                passengerdetails.pc.map((s, index) => {
                                    return (
                                        <tr key={s.seatno}>
                                            <td>{s.pname}</td>
                                            <td>{s.seatno}</td>
                                            <td>{s.conf}</td>
                                           
                                        </tr>
                                    )
                                }
                                )
                            }
                                {/* <br /><Row>
                                    <Col>
                                        GST:</Col>
                                    <Col> {passengers.gst}<br /></Col>
                                </Row>
                                <Row><Col>
                                    TOTAL AMOUNT:</Col><Col> {passengers.total}</Col>
                                </Row> */}
                            </tbody>
                        </Table>
                        {/* <Button className="float-right" onClick={handlebooking}>BOOK</Button><br/> */}
                    </div>
                    
                </>
            )
        }
       
    }








    return (<>
        <div  className="paraimg3 text-white">
            <h2 className="text-center">Enter PNR Number</h2>
            <div className="form-container2 rounded border border-primary mb-2">            
             {/* <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Enter PNR Number</Form.Label>
                  <Form.Control type="text"  title="pleas enter the PNR number" placeholder="PNR..." value={pnr} onChange={(e)=> setpnr(e.target.value)} />
                  {/* <div style={{fontSize:10,color:"red"}}>{arrival_timeerror}</div> 
                </Form.Group>
                <Button onClick={handlesearch}>Search</Button>
                </Row>
                <Row>
                   
                    
                </Row> */}
                <Form>
                    <Form.Row><Col/>
                        <Col>
                        <Form.Control type="text" title="Please enter PNR number" placeholder="PNR Number" value={pnr} onChange={(e)=> setpnr(e.target.value)} />
                        <div style={{fontSize:13,color:"red"}}>{pnrerror}</div>
                        </Col><Col/>
                    </Form.Row>
                    <br/>
                    <Form.Row><Col/>
                        <Col>&emsp; &emsp;&emsp; &emsp;
                        <Button onClick={handlesearch}>Search</Button>
                        </Col><Col/>
                    </Form.Row>
                </Form>
        </div>
         <br/><br/><br/>{pleaseLogIn()}<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        
        </div>

        </>
    )
}

export default Status
