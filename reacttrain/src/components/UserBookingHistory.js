import React, { useState, useEffect } from 'react'
import { Col, Row, Form } from "react-bootstrap";
import AxiosService from '../securitys/AxiosService'
import Button from 'react-bootstrap/Button'
import { useHistory } from 'react-router-dom';
function UserBookingHistory() {
    const history=useHistory()
    const [passengers, setpassengers]= useState([])
    const [alertss, setalertss]= useState("false")

    useEffect(() => {
        const us = JSON.parse(localStorage.getItem('man'))
        console.log(us.user_id)
        AxiosService.getUserHistory(us.user_id).then((res)=>{
            if(res.data.length>0){
                setpassengers(res.data)
            }else{
                console.log("no bookings found")
            }
        })

    }, [])

    const canclehandle =(e) =>{
        AxiosService.getCancleTicket(e).then((res)=>{
            if(res !==""){
                console.log(res)
                setalertss(res.data)
            }
        })
    }


    const alerts =() =>{
        if(alertss ==="success"){
        return(
            <div class="alert alert-warning" role="alert">
          Successfully cancled the ticket
        </div>)}
    }


    const printpassengers =() =>{
        if(passengers.length !==0){
            return(
                <div className="paraimg3 text-white">
                    <div className='row'>
                {/* <button className='btn btn-primary' onClick={handleaddstation}>Add Train</button> */}
            </div>
                    <h2 className='text-center'>Booking History</h2>
                    {
                        
                              
                                    // <div className='row'>
                                    //     <table className="table table-striped table-bordered">
                                    //         <thead>
                                    //             <tr>
                                    //                 <th>Passenger Name</th>
                                    //                 <th>Passenger Gender</th>
                                    //                 <th>Passenger Age</th>
                                    //                 <th>Physical Fitnes</th>
                                    //                 <th>PNR</th>
                                    //                 <th>Train Number</th>
                                    //                 <th>Train Name</th>
                                    //                 <th>Journey Date</th>
                                    //                 <th>Journey End Date</th>
                                    //                 <th>Food</th>
                                    //                 <th>From</th>
                                    //                 <th>To</th>
                                    //                 <th>Seat Number</th>
                                    //                 <th>Status</th>
                                    //                 <th>Action</th>
                                    //             </tr>
                                    //         </thead>
                                    //         <tbody>
                                    //             {
                                    //                 passengers.map(
                                    //                     s =>
                                    //                         <tr key={s.id}>
                                    //                             <td>{s.p_name}</td>
                                    //                             <td>{s.p_gender}</td>
                                    //                             <td>{s.p_age}</td>
                                    //                             <td>{s.p_handicap}</td>
                                    //                             <td>{s.pnr_no}</td>
                                    //                             <td>{s.p_trainno}</td>
                                    //                             <td>{s.p_trainname}</td>
                                    //                             <td>{s.j_date}</td>
                                    //                             <td>{s.j_edate}</td>
                                    //                             <td>{s.food}</td>
                                    //                             <td>{s.start}</td>
                                    //                             <td>{s.destination}</td>
                                    //                             <td>{s.seat_no}</td>
                                    //                             <td>{s.r_status}</td>  {/*  doubt */}
                                    //                             <Button onClick={() => canclehandle(s.pnr_no)}>Cancle</Button>
                                    //                         </tr>
                                    //                 )
                                    //             }
                                    //         </tbody>

                                    //     </table>

                                    // </div>

                                    passengers.map(
                                                         s =>
                                                         <div key={s.id} className="form-container2 rounded border border-primary mb-2" >

<Row>
                            <Col>
                            <Row>  <Col>Passenger Name:</Col><Col>{s.p_name}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>   <Col>Passenger Gender:</Col><Col>{s.p_gender}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>  <Col>Passenger Age</Col><Col>{s.p_age}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>    <Col>Physical Fitnes:</Col><Col>{s.p_handicap}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>   <Col>PNR:</Col><Col>{s.pnr_no}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>  <Col>Status:</Col><Col>{s.r_status}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>   <Col>Train Name:</Col><Col>{s.p_trainname}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>    <Col>Train Number:</Col><Col>{s.p_trainno}</Col></Row>
                            </Col>
                        </Row>
                       < Row><Col>
                        <Row>   <Col>Journey Date:</Col><Col>{s.j_date}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>  <Col>Journey End Date:</Col><Col>{s.j_edate}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>   <Col>From:</Col><Col>{s.start}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>    <Col>To:</Col><Col>{s.destination}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>   <Col>Food:</Col><Col>{s.food}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>    <Col>Seat Number:</Col><Col>{s.seat_no}</Col></Row>
                            </Col>
                        </Row>
                        <div className='text-center'>
            <button className='btn btn-danger ' onClick={() => canclehandle(s.pnr_no)}>Cancle</button>
                      </div> 
                        {/* <Button onClick={() => canclehandle(s.pnr_no)}>Cancle</Button> */}
                                                         </div>
                                                                                                     
                                                )
                            
                    }
                </div>

            )
        }else{
            return(
                <h2  className='text-center'>No Result Found...</h2>
            )
        }
    }

    return (
        <div>
            {alerts()}
            {printpassengers()}
        </div>
    )
}

export default UserBookingHistory
