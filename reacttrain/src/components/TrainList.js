import React, { useState, useEffect } from 'react'
import AxiosService from '../securitys/AxiosService'
import { useHistory } from 'react-router-dom';
import { Col, Row, Form } from "react-bootstrap";
import Button from 'react-bootstrap/Button'
import Table from 'react-bootstrap/Table'
import { Router, Route, browserHistory } from 'react-router'
function TrainList(props) {

    const history=useHistory()

    const [trains, settrains]= useState([])
    const [stationss, setstationss]= useState([])
    const [addtrain, setaddtrain]= useState("")
    const [deleted,setdeleted]= useState(false)

    useEffect(()=>{
        AxiosService.getAllTrain().then((res)=>{
            settrains(res.data)
        }).catch((error) => {
            console.error(`Error :  ${error} : No Train Available"`);
          })


          AxiosService.getStaionListNumber().then((res)=>{
              setstationss(res.data)
          }).catch((error) => {
            console.error(`Error :  ${error} : No Staions Available"`);
          })
    },[])

    const handler =(h) =>{
        var i
        for(i=0;i<stationss.length;i++){
            if(h==stationss[i].sn){
                return stationss[i].s+" -"
            }
        }
    }

    const handleaddtrain =() =>{
        history.push(`/addtrain`)
    }

    const deletehandler =(id) =>{
        AxiosService.deleteTrainDetails(id).then((res)=>{
            if(res.data==="deleted"){
                setdeleted(true)
            }
        })


    }

  const updatehandler =(id) =>{
    history.push(`/addtrain`)
  }


    const alerts =() =>{
        if(deleted){
        return(
            <div class="alert alert-warning" role="alert">
          Successfully delete 
        </div>)}
    }


    return (<>
        <div  className="paraimg3 text-white">{alerts()}
            <h2 className='text-center'>Train List</h2>
            <div className='text-center'>
            <button className='btn btn-success ' onClick={handleaddtrain}>Add Train</button>
                      </div> 
     
            <div>
                {/* <table className="table table-striped table-bordered"> */}
                {/* <Table responsive="sm" className="text-white">
                    <thead>
                        <tr>
                            <th>Train Number</th>
                            <th>Train Name</th>
                            <th>Train Type</th>
                            <th>Train First Day</th>
                            <th>Start Time</th>
                            <th>Train Last Day</th>
                            <th>Arrivel Time</th>
                            <th>Staions</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                            {
                                trains.map(
                                    train =>
                                    <tr key={train.train_id}>
                                        <td>{train.train_id}</td>
                                        <td>{train.details.train_name}</td>
                                        <td>{train.details.train_type}</td>
                                        <td>{train.train_fistday}</td>
                                        <td>{train.departure_time}</td>
                                        <td>{train.train_lastday}</td>
                                        <td>{train.arrival_time}</td>
                                        {
                                        train.stations.map(
                                            staion =>
                                            <p key={staion}>
                                                {handler(staion)}{staion}
                                               
                                            </p>
                                        )
                                        }
                                        <td><Button oonClick={() =>deletehandler(train.train_id)}>Delete</Button>
                                        <Button oonClick={() =>updatehandler(train.train_id)}>Update</Button>
                                        </td>
                                    </tr> 
                                )
                            }
                        </tbody>
                   
                {/* </table> 


                </Table> */}{
                trains.map(
                    train =>
                    <div key={train.train_id} className="form-container2 rounded border border-primary mb-2" id="example">
                        <Row>
                            <Col>
                            <Row>  <Col>Train Number:</Col><Col>{train.train_id}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>   <Col>Train Name:</Col><Col>{train.details.train_name}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>  <Col>Train Type:</Col><Col>{train.details.train_type}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>    <Col>Coach Type:</Col><Col>{train.details.coach_type}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>   <Col>First Day:</Col><Col>{train.train_fistday}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>  <Col>Last Day:</Col><Col>{train.train_lastday}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <Row>   <Col>Depacture Time:</Col><Col>{train.departure_time}</Col></Row>
                            </Col>|
                            <Col>
                            <Row>    <Col>Arrival Time:</Col><Col>{train.arrival_time}</Col></Row>
                            </Col>
                        </Row>
                        <Row><Col>
                        <select className="form-control1">
                        <option class="hidden" selected disabled>Stations</option>
                        {
                                        train.stations.map(
                                            staion =>
                                            <option key={staion}>{handler(staion)}-{staion}</option>
                                            // <p key={staion}>
                                            //     {handler(staion)}{staion}
                                               
                                            // </p>
                                        )
                                        }
                                         </select></Col>
                                         <Button className="float-right btn btn-danger" onClick={() =>deletehandler(train.train_id)}>Delete</Button>&emsp;
                                        <Button className="float-right" onClick={() =>updatehandler(train.train_id)}>Update</Button>
                                       
                                        </Row>
                    </div>
                )
                }
            </div>
            <br/><br/><br/><br/>
        </div></>
    )
}

export default TrainList
