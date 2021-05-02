import React, { useState, useEffect } from 'react'
import AxiosService from '../securitys/AxiosService'
import Button from 'react-bootstrap/Button'
import { useHistory, useParams } from 'react-router-dom';
// import Form from 'react-bootstrap/Form'
import Alert from 'react-bootstrap/Alert'
import { Col, Row, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";
import { produce } from 'immer';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

const UpdateStation = (props) => {

    const history = useHistory()
    let aa=useParams()
    const [station_id, setstation_id] = useState("");
    const [station_name, setstation_name] = useState("");
    const [station,setstaion]= useState("");

    const [station_list, setstation_list] = useState([{
        train_id: "",
        train_day: "",
        train_arivel: "",
        train_departure: "",
        train_distance:0

    }])

    useEffect(() => {
        //setstaion(props.match.params.id)
        console.log(aa.id)
        AxiosService.getStationTimeTable(aa.id).then((res)=>{
            setstation_id(res.data.station_id)
            setstation_name(res.data.station_name)
            setstation_list(res.data.station_list)
            console.log(res)
    
        })
    }, [])


const handleSubmit =() =>{

   

let obj= {id:station_id,station_id:station_id,station_name:station_name,station_list:station_list}
AxiosService.updateStation(obj).then((res)=>{
    if(res.data ==="success"){
        alert("added successfuly")
    }
})
console.log(obj)
}

    const handleadd =() =>{
        setstation_list([...station_list,{
            train_id: "",
            train_day: "",
            train_arivel: "",
            train_departure: "",
            train_distance:0
    
        }])
    }

    const handlesubtract =(index) =>{
        const v=[...station_list];
        v.splice(index,1);
        setstation_list(v);
    }

    return (
        <>
            {/* <h2 className='text-center'>Form To Add the Train</h2>
            {/* <Button onClick={cancle}>cancle</Button>{succe()} 
            <Button onClick={handleSubmit}>update</Button>
            <div className="container">

                <div className="container rounded-sm border border-dark">

                    <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Station Number</Form.Label>
                        <Form.Control type="text" placeholder="Station Number" pattern="[S]{1}[0-9]{4}" title="it should contan 5 digits only" value={station_id} onChange={(e) => setstation_id(e.target.value)} />
                        {/* <div style={{ fontSize: 10, color: "red" }}>{train_iderror}</div> 
                    </Form.Group>
                    <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Station Name</Form.Label>
                        <Form.Control type="text" placeholder="Train Name" pattern="[a-zA-Z]{1,}" title="doun't use numbers" value={station_name} onChange={(e) => setstation_name(e.target.value)} />
                        {/* <div style={{ fontSize: 10, color: "red" }}>{train_nameerror}</div> 
                    </Form.Group></div>

                <div className="container rounded-sm border border-dark">
                    {
                        station_list.map((p, index) => {
                            return (
                                <div key={index} className="container border border-dark rounded-sm">
                                    <Form>
                                   
                                        <Form.Row>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Train NO</Form.Label>
                                                    <Form.Control type="text" pattern="[0-9]{6}" title="it should conatains exact 6 digits" placeholder="Station NO" value={p.train_id}
                                                        onChange={
                                                            e => {
                                                                const train_id = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_id = train_id
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Train Day</Form.Label>
                                                    <Form.Control as="select" title="select any one" value={p.train_day}
                                                        onChange={
                                                            e => {
                                                                const train_day = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_day = train_day
                                                                    })
                                                                )
                                                            }
                                                        } >
                                                        <option>sunday</option>
                                                        <option>monday</option>
                                                        <option>tuesday</option>
                                                        <option>wednesday</option>
                                                        <option>thursday</option>
                                                        <option>friday</option>
                                                        <option>saturday</option>
                                                    </Form.Control>
                                                    {/* <div style={{fontSize:10,color:"red"}}>{train_dayerror}</div> 
                                                </Form.Group>
                                            </Col>
                                        </Form.Row>
                                        
                                        <Form.Row>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Arrival Time</Form.Label>
                                                    <Form.Control type="text" pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter valid time" placeholder="Arrival time" value={p.train_arivel}
                                                        onChange={
                                                            e => {
                                                                const train_arivel = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_arivel = train_arivel
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Depature Time</Form.Label>
                                                    <Form.Control type="text" pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter valid time" placeholder="Depature time" value={p.train_departure}
                                                        onChange={
                                                            e => {
                                                                const train_departure = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_departure = train_departure
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                        </Form.Row>
                                        <Form.Row>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Distance from the stating point of the train</Form.Label>
                                                    <Form.Control type="number" pattern="[0-9]{1,}" title="pleas enter valid distance" placeholder="Distance" value={p.train_arivel}
                                                        onChange={
                                                            e => {
                                                                const train_distance = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_distance = train_distance
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                            <Col>
                                            <Button variant="outline-info float-right" onClick={()=>handleadd()}>+</Button>
                                            <Button variant="outline-info float-right" onClick={()=>handlesubtract(index)}>-</Button>
                                            </Col>
                                            </Form.Row>
          
                                    </Form>
                                   
                                </div>
                            )
                        })
                    }
                </div>
            </div> */}

<div className="paraimg3 text-white"><div >
            <h2 className='text-center'>Form To Add the Station</h2>
            {/* <Button onClick={cancle}>cancle</Button>{succe()} */}
            <div className='text-center'>
            <button className='btn btn-success ' onClick={handleSubmit}>Submit</button>
                      </div>
            {/* <Button onClick={handleSubmit}>Add</Button> */}
         
<Row>
                <div className="form-container2 rounded border border-primary mb-2 ">

                    <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Station Number</Form.Label>
                        <Form.Control type="text" placeholder="Station Number" pattern="[S]{1}[0-9]{4}" title="it should contan 5 digits only" value={station_id} onChange={(e) => setstation_id(e.target.value)} />
                        {/* <div style={{ fontSize: 10, color: "red" }}>{train_iderror}</div> */}
                    </Form.Group>
                    <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Station Name</Form.Label>
                        <Form.Control type="text" placeholder="Station Name" pattern="[a-zA-Z]{1,}" title="doun't use numbers" value={station_name} onChange={(e) => setstation_name(e.target.value)} />
                        {/* <div style={{ fontSize: 10, color: "red" }}>{train_nameerror}</div> */}
                    </Form.Group></div>
                    </Row>
                <div className="form-container2 rounded border border-primary mb-2">
                    {
                        station_list.map((p, index) => {
                            return (
                                <div key={index} className="container border border-dark rounded-sm">
                                    <Form>
                                   
                                        <Form.Row>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Train NO</Form.Label>
                                                    <Form.Control type="text" pattern="[0-9]{6}" title="it should conatains exact 6 digits" placeholder="Train NO" value={p.train_id}
                                                        onChange={
                                                            e => {
                                                                const train_id = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_id = train_id
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Train Day</Form.Label>
                                                    <Form.Control as="select" title="select any one" value={p.train_day}
                                                        onChange={
                                                            e => {
                                                                const train_day = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_day = train_day
                                                                    })
                                                                )
                                                            }
                                                        } >
                                                        <option>sunday</option>
                                                        <option>monday</option>
                                                        <option>tuesday</option>
                                                        <option>wednesday</option>
                                                        <option>thursday</option>
                                                        <option>friday</option>
                                                        <option>saturday</option>
                                                    </Form.Control>
                                                    {/* <div style={{fontSize:10,color:"red"}}>{train_dayerror}</div> */}
                                                </Form.Group>
                                            </Col>
                                        {/* </Form.Row>
                                        
                                        <Form.Row> */}
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Arrival Time</Form.Label>
                                                    <Form.Control type="text" pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter valid time" placeholder="Arrival time" value={p.train_arivel}
                                                        onChange={
                                                            e => {
                                                                const train_arivel = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_arivel = train_arivel
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Depature Time</Form.Label>
                                                    <Form.Control type="text" pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter valid time" placeholder="Depature time" value={p.train_departure}
                                                        onChange={
                                                            e => {
                                                                const train_departure = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_departure = train_departure
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                        {/* </Form.Row>
                                        <Form.Row> */}
                                            <Col>
                                                <Form.Group controlId="exampleForm.ControlInput1">
                                                    <Form.Label>Distance </Form.Label>
                                                    <Form.Control type="number" pattern="[0-9]{1,}" title="pleas enter Distance from the stating point of the train" placeholder="Distance" value={p.train_arivel}
                                                        onChange={
                                                            e => {
                                                                const train_distance = e.target.value
                                                                setstation_list(c =>
                                                                    produce(c, (v) => {
                                                                        v[index].train_distance = train_distance
                                                                    })
                                                                )
                                                            }
                                                        } />

                                                </Form.Group>
                                            </Col>
                                            <Col>
                                            <Button variant="outline-info float-right" onClick={()=>handleadd()}>+</Button>
                                            <Button variant="outline-info float-right" onClick={()=>handlesubtract(index)}>-</Button>
                                            </Col>
                                            </Form.Row>
          
                                    </Form>
                                   
                                </div>
                            )
                        })
                    }
                </div>
           
            </div><br/><br/><br/><br/><br/>
            </div>
        </>
    )
}

export default UpdateStation;
