import React, { useState, Fragment } from "react";
import AxiosService from '../securitys/AxiosService'
import Button from 'react-bootstrap/Button'
import { useHistory } from 'react-router-dom';
// import Form from 'react-bootstrap/Form'
import Alert from 'react-bootstrap/Alert'
import { Col, Row, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";
import { produce } from 'immer'


const AddTrain = () => {

  const history=useHistory()
  const [train_id, settrain_id]= useState('')
  const [train_fistday, settrain_fistday]= useState('')
  const [train_lastday, settrain_lastday ]= useState('')
  const [arrival_time, setarrival_time]= useState('')
  const [departure_time, setdeparture_time]= useState('')
  const [train_name, settrain_name]= useState('')
  const [train_type, settrain_type1]= useState('')
  const[coach_type, setcoach_type]= useState('')
  const [coach1, setcoachac1] = useState('')
  const [coach2, setcoachac2] = useState('')


  

  // const [update, setupdate] = useState(
  //   {
  //     trains: {
  //       id: '',
  //       train_id: '',
  //       train_fistday: '',
  //       train_lastday: '',
  //       arrival_time: '',
  //       departure_time: '',
  //       stations: [],
  //       details: {
  //         train_name: '',
  //         train_type: '',
  //         coach_type: '',
  //         distance: [],
  //         seat: {
  //           ac: {
  //             coach: []
  //           },
  //           sl: {
  //             coach: []
  //           }
  //         }
  //       }
  //     }, addstation: [{
  //       station_id: '',
  //       train_day: '',
  //       train_arrival: '',
  //       train_depat: '',
       
  //     }]
  //   }
  // );

  // const [train, settrain] = useState({
  //   id: '',
  //   train_id: '',
  //   train_fistday: '',
  //   train_lastday: '',
  //   arrival_time: '',
  //   departure_time: '',
  //   stations: [],

  //     train_name: '',
  //     train_type: '',
  //     coach_type: '',
  //     distance: [],
  // });

  var pop = 0

  const [addstation, setaddstation] = useState([{
    station_id: '',
    train_day: '',
    train_arrival: '',
    train_depat: '',
    distance: 0

  }])


  let result="danger"
  let msg= "faild to"
  let fl= false
  
  const submithandle =(e) =>{
    e.preventDefault()
    var d=[]
    var s=[]
    var i=0
    for(i;i<addstation.length;i++){
      d[i]= parseInt(addstation[i].distance);
      s[i]= addstation[i].station_id;
    }
    let c1=coach1.split("-").map(x=>+x)
    let c2=coach2.split("-").map(x=>+x)
    let tr={train:{
      id:train_id,
      train_id: train_id,
      train_fistday: train_fistday,
      train_lastday: train_lastday,
      arrival_time: arrival_time,
      departure_time: departure_time,
      stations: s,
      details: {
        train_name: train_name,
        train_type: train_type,
        coach_type: coach_type,
        distance: d,
        seat: {
          ac: {
            coach: c1
          },
          sl: {
            coach: c2
          }
        }
      }
    }, addstation:addstation
  }
  const isvalid= validate()
  console.log(JSON.stringify(tr));
  if(isvalid){
   

    AxiosService.addNewTrain(tr).then((res)=>{
     
      if(res.data ==="success"){
        console.log(res)
        initialstate();
        result= 'success'
        msg= "successfuly"
      }
      fl=true;
     
    })
   

  }
  
   
  }
  const succe =() =>{
    if(fl){
    return(
      <Alert variant={result}>
      This is {msg} alert
      </Alert>)}
  }
  const cancle =() =>{
    history.push(`/trainlist`)
  }

  // error validation

  
   const[ station_iderror, setstation_iderror]= useState('')
   const[ train_dayerror, settrain_dayerror]= useState('')
   const[ train_arrivalerror, settrain_arrivalerror]= useState('')
   const[ train_depaterror, settrain_depaterror]= useState('')
   const[ distanceerror, setdistanceerror]= useState('')
  const [train_iderror, settrain_iderror]= useState('')
  const [train_fistdayerror, settrain_fistdayerror]= useState('')
  const [train_lastdayerror, settrain_lastdayerror ]= useState('')
  const [arrival_timeerror, setarrival_timeerror]= useState('')
  const [departure_timeerror, setdeparture_timeerror]= useState('')
  const [train_nameerror, settrain_nameerror]= useState('')
  const [train_typeerror, settrain_type1error]= useState('')
  const [coach_typeerror, setcoach_typeerror]= useState('')
  const [coach1error, setcoachac1error] = useState('')
  const [coach2error, setcoachac2error] = useState('')
  
  const validate =() =>{

    let empty="it should not be empty";
    let flag=true;
    if(train_id.length!==6){
      settrain_iderror(empty)
      flag=false;
    }else{
      settrain_iderror("")
    }
    if(train_fistday.length===0){
      settrain_fistdayerror(empty)
      flag=false;
    }else{
      settrain_fistdayerror("")
    }
    if(train_lastday.length===0){
      settrain_lastdayerror(empty)
      flag=false;
    }else{
      settrain_lastdayerror("")
    }
    if(arrival_time.length===0){
      setarrival_timeerror(empty);
      flag=false;
    }else{
      setarrival_timeerror("");
    }
    if(departure_time.length===0){
      setdeparture_timeerror(empty);
      flag=false;
    }else{
      setdeparture_timeerror("");
    }
    if(train_name.length===0){
      settrain_nameerror(empty);
      flag=false;
    }else{
      settrain_nameerror("");
    }
    if(train_type.length===0){
      settrain_type1error(empty);
      flag=false;
    }else{
      settrain_type1error("");
    }
    if(coach_type.length===0){
      setcoach_typeerror(empty);
      flag=false;
    }else{
      setcoach_typeerror("");
    }
    if(coach1.length<1){
      setcoachac1error(empty);
      flag=false;
    }else{
      setcoachac1error(""); 
    }
    if(coach2.length<1){
      setcoachac2error(empty);
      flag=false;
    }else{
      setcoachac2error(""); 
    }
    var i
for(i=0;i<addstation;i++){

    if(addstation[i].station_id){
      setstation_iderror(empty);
      flag=false;
    }else{
      setstation_iderror(""); 
    }
    if(addstation[i].train_day){
      settrain_dayerror(empty);
      flag=false;
    }else{
      settrain_dayerror("");
    }
    let a=addstation[i].train_arrival
    if(a.length ===0){
      settrain_arrivalerror(empty);
      flag=false;
    }else{
      settrain_arrivalerror("");
    }
    if(addstation[i].train_depat){
      settrain_depaterror(empty);
      flag=false;
    }else{
      settrain_depaterror("");
    }
    if(addstation[i].distance){
      setdistanceerror(empty);
      flag=false;
    }else{
      setdistanceerror("");
    }
  }


    return flag;
  }

  const initialstate =() =>{
    settrain_iderror("");
    settrain_fistdayerror("");
    settrain_lastdayerror("");
    setarrival_timeerror("");
    setdeparture_timeerror("");
    settrain_nameerror("");
    settrain_type1error("");
    setcoachac1error("");
    setcoachac2error("");
    setcoach_typeerror("");
   setaddstation([{
    station_id: '',
    train_day: '',
    train_arrival: '',
    train_depat: '',
    distance: 0

  }])
  }


  return (
    <><div className="paraimg3 text-white">
      
      <h2 className='text-center'>Form To Add the Train</h2>
      {succe()}
      <div className="form-container2 rounded border border-primary mb-2">
      <Button className="btn btn-success" onClick={submithandle}>submit</Button>
                  
                  <Button className="btn btn-danger float-right" onClick={cancle}>cancle</Button>
       
            {/* <div className="container rounded-sm border border-dark"> */}
              <Form>
              <Row>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Train Number</Form.Label>
                  <Form.Control type="text" placeholder="Train Number" pattern="[1-9]{1}[0-9]{5}" title="it should contan 6 digits only" value={train_id} onChange={(e)=> settrain_id(e.target.value)} />
                  <div style={{fontSize:10,color:"red"}}>{train_iderror}</div>
                </Form.Group>
                </Col>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Train Name</Form.Label>
                  <Form.Control type="text" placeholder="Train Name" pattern="[a-zA-Z]{1,}" title="doun't use numbers" value={train_name} onChange={(e)=> settrain_name(e.target.value)} />
                  <div style={{fontSize:10,color:"red"}}>{train_nameerror}</div>
                </Form.Group>
                </Col>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1" >
                  <Form.Label>Train Type</Form.Label>
                  <Form.Control as="select" title="select any one" value={train_type} onChange={(e)=> settrain_type1(e.target.value)} >
                  <option>Superfast</option>
                    <option>Express</option>
                    <option>Special</option>
                  </Form.Control>
                  <div style={{fontSize:10,color:"red"}}>{train_typeerror}</div>
                </Form.Group>
                </Col>
                </Row>
                <Row>
                  <Col>

                <Form.Group controlId="exampleForm.ControlSelect1">
                  <Form.Label>Coach Type</Form.Label>
                  <Form.Control as="select" title="select any one" value={coach_type} onChange={(e)=> setcoach_type(e.target.value)}>
                    <option>All</option>
                    <option>Ac</option>
                    <option>Sl</option>
                  </Form.Control>
                  <div style={{fontSize:10,color:"red"}}>{coach_typeerror}</div>
                </Form.Group>
                </Col>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>First Day</Form.Label>
                  <Form.Control as="select" title="select any one" value={train_fistday} onChange={(e)=> settrain_fistday(e.target.value)} >
                  <option>sunday</option>
                    <option>monday</option>
                    <option>tuesday</option>
                    <option>wednesday</option>
                    <option>thursday</option>
                    <option>friday</option>
                    <option>saturday</option>
                  </Form.Control>
                  <div style={{fontSize:10,color:"red"}}>{train_fistdayerror}</div>
                </Form.Group>
                </Col>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Last Day</Form.Label>
                  <Form.Control as="select" title="select any one" value={train_lastday} onChange={(e)=> settrain_lastday(e.target.value)} >
                  <option>sunday</option>
                    <option>monday</option>
                    <option>tuesday</option>
                    <option>wednesday</option>
                    <option>thursday</option>
                    <option>friday</option>
                    <option>saturday</option>
                  </Form.Control>
                  <div style={{fontSize:10,color:"red"}}>{train_lastdayerror}</div>
                </Form.Group>
                </Col>
                </Row>
                <Row>
                  <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Arrival Time</Form.Label>
                  <Form.Control type="text" pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter the correct pattern" placeholder="00-00-00" value={arrival_time} onChange={(e)=> setarrival_time(e.target.value)} />
                  <div style={{fontSize:10,color:"red"}}>{arrival_timeerror}</div>
                </Form.Group>
                </Col>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Departure Time</Form.Label>
                  <Form.Control type="text" pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter the correct pattern" placeholder="00-00-00" value={departure_time} onChange={(e)=> setdeparture_time(e.target.value)} />
                  <div style={{fontSize:10,color:"red"}}>{departure_timeerror}</div>
                </Form.Group>
                </Col>
                </Row>
                <Row>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Enter Ac coach seat numbers</Form.Label>
                  <Form.Control type="text" placeholder="0-0-0-0" value={coach1} onChange={(e)=> setcoachac1(e.target.value)} />
                  <div style={{fontSize:10,color:"red"}}>{coach1error}</div>
                </Form.Group>
                </Col>
                <Col>
                <Form.Group controlId="exampleForm.ControlInput1">
                  <Form.Label>Enter Sl coach seat numbers</Form.Label>
                  <Form.Control type="text" placeholder="0-0-0-0" value={coach2} onChange={(e)=> setcoachac2(e.target.value)} />
                  <div style={{fontSize:10,color:"red"}}>{coach2error}</div>
                </Form.Group>
                </Col>
                </Row>
              </Form>
{/* </div> */}

{/*               
          <div class="form-group col-md-5"> */}

            <div className="container">
              

              {/* <Button variant="primary btn-block" type="submit" onClick={() => {
                setaddstation(c => [...c, {
                   id:pop,
                  station_id: '',
                  train_day: '',
                  train_arrival: '',
                  train_depat: '',
                  distance: 0
                }])
              }} >add stations</Button> */}

              {addstation.map((p, index) => {
                pop++
                return (
                  //  <div key={p.station_id} className="container border border-dark rounded-sm">

                    <div key={p.id} className="container border border-dark rounded-sm"> <Form>
                    <Form.Row><Col>
                      <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Stantion NO</Form.Label>
                        <Form.Control type="text" pattern="[S]{1}[0-9]{4}" title="it should start with 'S' and another 4 char are numbers" placeholder="Station NO" value={p.station_id}
                          onChange={
                            e => {
                              const station_id = e.target.value
                              setaddstation(c =>
                                produce(c, (v) => {
                                  v[index].station_id = station_id
                                })
                              )
                            }
                          } />
                          <div style={{fontSize:10,color:"red"}}>{station_iderror}</div>
                      </Form.Group></Col>
                      <Col>
                        <Form.Group controlId="exampleForm.ControlInput1">
                          <Form.Label>Train Day</Form.Label>
                          <Form.Control as="select" title="select any one" value={p.train_day}
                            onChange={
                              e => {
                                const train_day = e.target.value
                                setaddstation(c =>
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
                            <div style={{fontSize:10,color:"red"}}>{train_dayerror}</div>
                        </Form.Group></Col>
                        {/* </Form.Row>
                      <Form.Row>*/}<Col> 
                        <Form.Group controlId="exampleForm.ControlInput1">
                          <Form.Label>Train Arrival</Form.Label>
                          <Form.Control pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter the correct pattern" type="text" placeholder="00-00-00" value={p.train_arrival}
                            onChange={
                              e => {
                                const train_arrival = e.target.value
                                setaddstation(c =>
                                  produce(c, (v) => {
                                    v[index].train_arrival = train_arrival
                                  })
                                )
                              }
                            } />
                            <div style={{fontSize:10,color:"red"}}>{train_arrivalerror}</div>
                        </Form.Group></Col>
                        <Col>
                          <Form.Group controlId="exampleForm.ControlInput1">
                            <Form.Label>Train Depature</Form.Label>
                            <Form.Control pattern="[0-9]{2}-[0-9]{2}-[0-9]{2}" title="pleas enter the correct pattern" type="text" placeholder="00-00-00" value={p.train_depat}
                              onChange={
                                e => {
                                  const train_depat = e.target.value
                                  setaddstation(c =>
                                    produce(c, (v) => {
                                      v[index].train_depat = train_depat
                                    })
                                  )
                                }
                              } />
                              <div style={{fontSize:10,color:"red"}}>{train_depaterror}</div>
                          </Form.Group></Col>
                      </Form.Row>
                      <Form.Row> <Col>
                      <Form.Group controlId="exampleForm.ControlInput1">
                        <Form.Label>Distance</Form.Label>
                        <Form.Control type="number" placeholder="00" value={p.distance}
                          onChange={
                            e => {
                              const distance = e.target.value
                              setaddstation(c =>
                                produce(c, (v) => {
                                  v[index].distance = distance
                                })
                              )
                            }
                          } />
                          <div style={{fontSize:10,color:"red"}}>{distanceerror}</div>
                      </Form.Group></Col>
                      <Col><br/>
                      <Button variant="outline-info float-right" onClick={()=>{
                        setaddstation(c=>c.filter(x=> x.id !==p.id))
                      }}>X</Button>
                      </Col>
                      </Form.Row>
                </Form>
                  </div>
                )
              })}
              <Button variant="primary btn-block" type="submit" onClick={() => {
                setaddstation(c => [...c, {
                   id:pop,
                  station_id: '',
                  train_day: '',
                  train_arrival: '',
                  train_depat: '',
                  distance: 0
                }])
              }} >add stations</Button>

                  </div> </div>
                 
          </div>
{/* 
        </div> */}
       {/* </div> */}<br/>
    </>
  )
}

export default AddTrain;