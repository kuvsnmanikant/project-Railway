
import { useHistory, useParams } from 'react-router-dom';
import React, { useState, useEffect } from 'react'
import AxiosService from '../securitys/AxiosService'
import { Col, Row, Form } from "react-bootstrap";
import Table from 'react-bootstrap/Table'
import logo0 from './images/formbg.png'
function Ticket() {

    let aa=useParams()
    const [passengerdetails,setpassengerdetails] =useState("")
    const [passengers,setprice]= useState("")

    useEffect(() => {
        //setstaion(props.match.params.id)
        console.log(aa.id)
        AxiosService.getPassengerStatus(aa.id).then((res)=>{
            if(res !==null){
                setpassengerdetails(res.data);
            }
            console.log(res);
            if(passengerdetails.trani_no ===null){
                alert("you enterd wrong pnr number")
                setpassengerdetails("")
            }
        }
        )
        console.log(passengerdetails)

        AxiosService.getPriceFromBooking(aa.id).then((res)=>{
            if(res !==null){
                setprice(res.data);
            }
        })
        
    }, [])

    const printtable =() =>{
        if((passengerdetails.trani_no !==null) && (passengerdetails !=="")){
            return(
                <div className="form-container2 rounded border border-primary mb-2 text-white">
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
                            
                        </tbody>
                    </Table>
                 
                </div>

            )
        }
    }

    const pricetable =() =>{
        if (passengers !== "" &&passengers.pp !==null) {
            console.log(passengers)
            return (
                <>

                    <div className="form-container2 rounded border border-primary mb-2 ">
                        <h2 className="text-center">Price Table</h2>
                        <Table responsive="sm" className="text-white">
                            <thead>
                                <tr>

                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Food</th>
                                    <th>discount</th>
                                    <th>Amount</th>
                                </tr>
                            </thead>
                            <tbody>{
                                passengers.rp.pp.map((p, index) => {
                                    return (
                                        <tr key={index}>
                                            <td>{p.name}</td>
                                            <td>{p.price}</td>
                                            <td>{p.food}</td>
                                            <td>{p.discount}</td>
                                            <td>{p.amount}</td>
                                        </tr>
                                    )
                                }
                                )
                            }
                                <br /><Row>
                                    <Col>
                                        GST:</Col>
                                    <Col> {passengers.rp.gst}<br /></Col>
                                </Row>
                                <Row><Col>
                                    TOTAL AMOUNT:</Col><Col> {passengers.rp.total}</Col>
                                </Row>
                            </tbody>
                        </Table>
                    </div>
                    
                </>
            )
        }

    }



    return (
        <div className="text-center">
            <img src={logo0} height="200" width="200" title="Home" alt="logo" />
                       {printtable()}
                       {pricetable()}
        </div>
    )
}

export default Ticket
