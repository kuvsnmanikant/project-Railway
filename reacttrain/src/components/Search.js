
import React, { useState,  useEffect } from "react";
import AxiosService from '../securitys/AxiosService'
import Button from 'react-bootstrap/Button'
import { Col, Row, Form } from "react-bootstrap";
import { useHistory } from 'react-router-dom';
import Card from 'react-bootstrap/Card'
import Table from 'react-bootstrap/Table'

function Search(props) {

    const[stations, setstations]=useState([])
    const[trains,setTrains]= useState([])
    const [stato, setstato] = useState("");
    const [train, settrain] =useState("");
    const [stationtimetable, setstationtimetable] =useState("")
    const [traintimetable, settraintimetable] =useState("")

    useEffect(()=>{


        // axios.get('http://localhost:3001/user/getuser1').then((res)=>{
        //     console.log(res)
        //     if(res.data.loggedin){
        //     setloginstatus(res.data.user[0].user_id)}
        // })
        AxiosService.getTrainListNumber().then((res)=>{

            if(res.data!=""){setTrains(res.data)}
        else{console.log("bingo")}
        })
        console.log(trains)

        AxiosService.getStaionListNumber().then((res)=>{

        if(res.data!=""){setstations(res.data)}
        else{console.log("bingo")}
         //   console.log(res)
         
        })
        console.log(stations)
    
    },[])

    const stationhandler =(e) =>{
        e.preventDefault();
        AxiosService.getStationTimeTable(stato).then((res)=>{
            if(res.data !==null){
                setstationtimetable(res.data)
                settrain("")
            }else {
                console.log("not found")
            }
            // console.log(res.data)
        })
       console.log(stationtimetable)

    }
    const trainhandler =(e) =>{
        e.preventDefault();
        AxiosService.getTrainTimeTable(train).then((res)=>{
            if(res.data !==null){
                settraintimetable(res.data)
                setstato("")
            }else {
                console.log("not found")
            }
            // console.log(res.data)
        })
        console.log(traintimetable)
    }

    const traintimetables =() =>{
        if(train !=="" && traintimetable!== ""){
            return(
                <div>
                    <h2 className='text-center'>Train Time Table</h2><br/>
                <Row>   <Col> {traintimetable.train_no}</Col><Col>{traintimetable.train_name}</Col><Col>{traintimetable.train_type}</Col>
                </Row>
                    <div className='row'>
                {/* <table className="table table-striped table-bordered"> */}
                <Table responsive="sm" className="text-white">
                    <thead>
                        <tr>
                            <th>Station Name</th>
                            <th>Station Number</th>
                            <th>Train Day</th>
                            <th>Train Arrival Time</th>
                            <th>Train Depature Time</th>
     
                        </tr>
                        </thead>
                        <tbody>
                            {
                                traintimetable.staiontrain.map(
                                    train =>
                                    <tr key={train.station_id}>
                                        <td>{train.station_name}</td>
                                        <td>{train.station_id}</td>
                                        <td>{train.station_train_day}</td>
                                        <td>{train.station_train_arrival}</td>
                                        <td>{train.station_train_depat}</td>
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

    
    const trinname =(i) =>{
        var j
        for(j=0;j<trains.length;j++){
            if(trains[j].trainno === i){
                return(
                    <p>{trains[j].trainname}</p>
                )
            }
        }

    }
    const setationtimetables =() =>{
        if(stato !=="" && stationtimetable!==""){
            return(
                <div>
                    <h2 className='text-center'>Station Time Table</h2>
                 <Row> <Col> {stationtimetable.station_id}</Col><Col/><Col/><Col/><Col/><Col>{stationtimetable.station_name}</Col>
                 </Row> 
                    <div className='row'>
                {/* <table className="table table-striped table-bordered"> */}
                <Table responsive="sm" className="text-white">
                    <thead>
                        <tr>
                            <th>Train Number</th>
                            <th>Train Name</th>
                            <th>Train Day</th>
                            <th>Train Arrival Time</th>
                            <th>Train Depature Time</th>
     
                        </tr>
                        </thead>
                        <tbody>
                            {
                                stationtimetable.station_list.map(
                                    s =>
                                    <tr key={s.train_id}>
                                        <td>{s.train_id}</td>
                                        <td>{trinname(s.train_id)}</td>
                                        <td>{s.train_day}</td>
                                        <td>{s.train_arivel}</td>
                                        <td>{s.train_departure}</td>
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

<div className="paraimg3 text-white">
<div className="form-container2 rounded border border-primary mb-2">
<Form.Row> 
             
                        {/* <input className="form-control1" type="text" placeholder="From *" onChange={e=>setfrom(e.target.value)}/> */}

                    <select className="form-control1" required onChange={e=>setstato(e.target.value)}>
                      <option class="hidden" selected disabled>Select station</option>
                      {
                           stations.map(
                            statio => 
                            <option key={statio.sn} value={statio.sn}>{statio.s}</option>
                        )
                      }
                             
                        </select>
                        &emsp;

                        <select className="form-control1" required onChange={e=>settrain(e.target.value)}>
                      <option class="hidden" selected disabled>Select Train</option>
                      {
                          trains.map(
                              tra => 
                              <option key={tra.trainno} value={tra.trainno}>{tra.trainname} - {tra.trainno}</option>
                          )
                      }
                           
                        </select>
                 
                    </Form.Row>

                    <Form.Row><Col>
                    <Button onClick={stationhandler}>search station</Button>  </Col><Col>
                    <Button onClick={trainhandler}>search train </Button></Col>

                 
                     

                    </Form.Row><br/>
                    <Form.Row>

            
                        {traintimetables()}
                     {setationtimetables()}

   
                    </Form.Row>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>
            
        </>
    )
}

export default Search

