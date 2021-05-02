import React, { useState, Fragment } from "react";
import AxiosService from '../securitys/AxiosService'
import Button from 'react-bootstrap/Button'
import { useHistory } from 'react-router-dom';
import { Col, Row, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";
import { produce } from 'immer'
import StationList from "./StationList";

const AddStation = () => {

    const history = useHistory()
    const [station_id, setstation_id] = useState("");
    const [station_name, setstation_name] = useState("");
    const [station_list, setstation_list] = useState([{
        train_id: "",
        train_day: "",
        train_arivel: "",
        train_departure: "",
        train_distance: 0

    }])
    const [val,setval] =useState(false);
    const [val2,setval2] =useState(false);
    const [val3,setval3] =useState(true);

    const handleSubmit = () => {
        if(val && val2 && val3){
        let obj = { id: station_id, station_id: station_id, station_name: station_name, station_list: station_list }
        AxiosService.addNewStation(obj).then((res) => {
            if (res.data === "success") {
                alert("added successfuly")
            }
        })
        console.log(obj)
    }
    }

    const handleadd = () => {
        setstation_list([...station_list, {
            train_id: "",
            train_day: "",
            train_arivel: "",
            train_departure: "",
            train_distance: ""
        }])
    }

    const handlesubtract = (index) => {
        const v = [...station_list];
        v.splice(index, 1);
        setstation_list(v);
    }

    const validates =() =>{
       var a=""
        var r=/^[S]{1}[0-9]{4}$/
        if(station_id !=="" && r.test(station_id)){
            setval(true)
        }else{
            a=a+"station id, "
        }
        var r1=/^[a-zA-Z]$/
        if(station_name !=="" && r1.test(station_name)){
            setval2(true)
        }else{
            a=a+"staion name"
        }
        var i
        var r2=/^[0-9]{6}$/
        var r3=/^ [0-2]{1}[0-3]{1}-[0-5]{1}[0-9]{1}-[0-5]{1}[0-9]{1}$/
        var r4=/^[0-9]{1,}$/
   
        for(i=0;i<station_list.length;i++){
            if(station_list[i].train_id !=="" && station_list[i].train_arivel !=="" && station_list[i].train_departure !=="" && station_list[i].train_distance !==""){
                
                if(r2.test(station_list[i].train_id)){
                    a=a+"Station "+i+"train id, "
                    setval3(false)
                }
                if(station_list[i].length.train_day !==""){
                    a=a+"Station "+i+"train day, "
                    setval3(false)
                }
                if(r3.test(station_list[i].train_arivel)){
                    a=a+"Station "+i+"train arrival, "
                    setval3(false)
                }
                if(r3.test(station_list[i].train_departure)){
                    a=a+"Station "+i+"train departure, "
                    setval3(false)
                }
                if(r4.test(station_list[i].train_distance)){
                    a=a+"Station "+i+"train distance, "
                    setval3(false)
                }
                
            }
        }
        a=a+"are not valid "
    }

    

    return (
        <><div className="paraimg3 text-white"><div >
            <h2 className='text-center'>Form To Add the Station</h2>
            <div className='text-center'>
                <button className='btn btn-success ' onClick={handleSubmit}>Submit</button>
            </div>

            <Row>
                <div className="form-container2 rounded border border-primary mb-2 ">

                    <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Station Number</Form.Label>
                        <Form.Control type="text" placeholder="Station Number" pattern="[S]{1}[0-9]{4}" title="it should contan 5 digits only" value={station_id} onChange={(e) => setstation_id(e.target.value)} />
                      
                    </Form.Group>
                    <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Station Name</Form.Label>
                        <Form.Control type="text" placeholder="Station Name" pattern="[a-zA-Z]{1,}" title="doun't use numbers" value={station_name} onChange={(e) => setstation_name(e.target.value)} />
                      
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
                                            <Button variant="outline-info float-right" onClick={() => handleadd()}>+</Button>
                                            <Button variant="outline-info float-right" onClick={() => handlesubtract(index)}>-</Button>
                                        </Col>
                                    </Form.Row>

                                </Form>

                            </div>
                        )
                    })
                }
            </div>

        </div><br /><br /><br /><br /><br />
        </div>
        </>
    )
}

export default AddStation;