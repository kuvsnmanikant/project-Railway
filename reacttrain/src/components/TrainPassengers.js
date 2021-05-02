import React, { useState, useEffect } from "react";
import AxiosService from '../securitys/AxiosService'
import Button from 'react-bootstrap/Button'
import { Col, Row, Form } from "react-bootstrap";
import { useHistory } from 'react-router-dom';
import Table from 'react-bootstrap/Table'
function TrainPassengers() {

    const [trains, setTrains] = useState([])
    const [train, settrain] =useState("")
    const [date, setdate] = useState("")
    const [passengers,setpassengers]= useState("")

    useEffect(() => {

        AxiosService.getTrainListNumber().then((res) => {
            if (res.data != "") { setTrains(res.data) }
            else { console.log("bingo") }
        })
        console.log(trains)

    }, [])

    const trainhandler =() =>{
        var r = date.split("-");
        setdate(r[2] + "-" + r[1] + "-" + r[0])
        AxiosService.getTrainPassengersDate(train,date).then((res)=>{
           
            
            if(res.data.length !==0){
                console.log(res)
                setpassengers(res.data)
            }else{
                console.log("data not found")
            }
        })
    }

    const canclehandle =(e) =>{
        AxiosService.getCancleTicket(e).then((res)=>{
            if(res !==""){
                console.log(res)
               
            }
        })
    }


    const traintimetables =() =>{
        if(passengers !==""){
            return (
                <div>
                <h2 className='text-center'>Passengers Table</h2>
                <div className='row'>
            {/* <table className="table table-striped table-bordered"> */}
            <Table responsive="sm" className="text-white">
                <thead>
                    <tr>
                        <th>Passenger Name</th>
                        <th>PNR Number</th>
                        <th>Gender</th>
                        <th>Seat Number</th>
                        <th>Action</th>
                        <th>Status</th>
 
                    </tr>
                    </thead>
                    <tbody>
                        {
                            passengers.map((train,index)=>
                                 
                                <tr key={index}>
                                    <td>{train.p_name}</td>
                                    <td>{train.pnr_no}</td>
                                    <td>{train.p_gender}</td>
                                    <td>{train.seat_no}</td>
                                    <td>{train.r_status}</td>
                                    
                                    <Button className="btn btn-danger" onClick={() => canclehandle(train.pnr_no)}>Cancle</Button>
                                    </tr> 
                            )
                        }
                    </tbody>
               
            {/* </table> */}
            </Table>

        </div>
            </div>

            )
        }
    }

    return (
        <>
            {/* <div className="container"> */}
            <div className="paraimg3 text-white">
<div className="form-container2 rounded border border-primary mb-2">
                <Form.Row>
                        <select className="form-control1" required onChange={e => settrain(e.target.value)}>
                        <option class="hidden" selected disabled>Select Train</option>
                        {
                            trains.map(
                                tra =>
                                    <option key={tra.trainno} value={tra.trainno}>{tra.trainname} - {tra.trainno}</option>
                            )
                        }

                    </select>&emsp;
                  
                    <input type="date" id="traindate" className="form-control1" onChange={e => setdate(e.target.value)} />
              

                </Form.Row>

                <Form.Row>
                    <Button onClick={trainhandler}>search station</Button>

                </Form.Row>
                <Form.Row>


                    {traintimetables()}
                    

                </Form.Row>
            </div>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>

        </>
    )
}

export default TrainPassengers
