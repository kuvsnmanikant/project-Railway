import React, { useState, useEffect } from 'react'

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

import Button from 'react-bootstrap/Button'
import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import AxiosService from '../securitys/AxiosService'
function TrainSearchDetails(props) {
    const [traindetails, settraindetails] = new useState([])
    const [searchdata, setsearchdata] = useState("")
    // const [s1,sets1]= new useState([])
    // const {s1}= props.location.state
    // const {s2}= props.location.state
    // const {d}=props.location.state
    // const {c}=props.location.state
    // const {g}=props.location.state

    // console.log(s1.from)
    // console.log(s2.to)
    // console.log(d.date)
    // console.log(c.clas)
    // console.log(g.general)
    // const componen =() =>{
    //     const {s1}= props.location.state
    // const {s2}= props.location.state
    // const {d}=props.location.state
    // const {c}=props.location.state
    // const {g}=props.location.state

    //     var r = d.date.split("-");
    //  var aa=r[2] + "-" + r[1] + "-" + r[0]
    //     let dd = { s1: s1.from, s2: s2.to, d: aa, c: c.clas, g:g.general }
    //     console.log(dd)
    //     AxiosService.getSearchTrains(dd).then((res) => {
    //         setsearchdata(res.data)
    //         if (res.data !== "") {


    //         }
    //     })
    //     // console.log(searchdata)
    //     // console.log(searchdata)

    // }


    useEffect(() => {
        const { s1 } = props.location.state
        const { s2 } = props.location.state
        const { d } = props.location.state
        const { c } = props.location.state
        const { g } = props.location.state

        var r = d.date.split("-");
        var aa = r[2] + "-" + r[1] + "-" + r[0]
        let dd = { s1: s1.from, s2: s2.to, d: aa, c: c.clas, g: g.general }
        console.log(dd)
        AxiosService.getSearchTrains(dd).then((res) => {
            setsearchdata(res.data)
            if (res.data !== "") {


            }
        })
        console.log(searchdata)

    }, [])

    const print = () => {
        if (searchdata !== "") {
            return (
                <tbody>
                    {
                        searchdata.s.map(
                            s =>
                                <tr key={s.train_no}>
                                    <td>{s.train_no}</td>
                                    <td>{s.train_name}</td>
                                    <td>{s.train_type}</td>
                                    <td>{s.train_start}</td>
                                    <td>{s.train_end}</td>
                                    <td>{s.coach_type}</td>
                                    <td>{s.s1_name}</td>
                                    <td>{s.s1_date}</td>
                                    <td>{s.s1_arival}</td>
                                    <td>{s.s1_departure}</td>
                                    <td>{s.s2_name}</td>
                                    <td>{s.s2_date}</td>
                                    <td>{s.s2_arival}</td>
                                    <td>{s.s2_departure}</td>
                                    <td>{s.sl_seats}</td>
                                    <td>{s.ac_seats}</td>
                                    <td>{s.distance}</td>
                                    {pricesplit(s.price)}
                                    <Link
                                        to={{
                                            pathname: "/bookfirststep",
                                            state: {
                                                // searchdata: { s }
                                                searchdata: JSON.stringify(s)
                                            }
                                        }}
                                    >book</Link>

                                </tr>
                        )
                    }
                </tbody>
            )
        } else {
            return (
                <h2>no trains available</h2>
            )
        }
    }



    const printstyle = () => {
        if (searchdata !== "") {
            return (<div >
                {
                    searchdata.s.map(
                        s =>
                            <div key={s.train_no} className="form-container2" >
                                <Row><Col className="float-right text-info font-weight-bold text-uppercase "> &emsp; &emsp; &emsp;&emsp; &emsp; &emsp; &emsp;{s.train_no} - {s.train_name} - {s.train_type} - {s.coach_type}</Col></Row>
                                <br />
                                <Row>
                                    <Col className="text-warning">
                                        From: {s.s1_name}<br />
                               Start Date: {s.s1_date}<br />
                               Arrival time: {s.s1_arival}<br />
                               Depature time: {s.s1_departure}
                                    </Col>
                                    <Col className=" text-info"><br /><hr />&emsp; &emsp; &emsp; &emsp; {s.distance} Km</Col>
                                    <Col className="text-warning" >
                                        To: {s.s2_name}<br />
                                End Date: {s.s2_date}<br />
                                Arrival time: {s.s2_arival}<br />
                                Depature time: {s.s2_departure}
                                    </Col>
                                </Row>
                                <Row ><Col className="text-white" >&emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;
                            Ac Available: {s.ac_seats} &emsp; &emsp; Sl Available: {s.sl_seats}</Col></Row>
                            {pricesplit(s.price)}
                                <Row><Col /><Col>&emsp; &emsp;&emsp; <Button className="btn btn-success">
                                    <Link className="text-white"
                                        to={{
                                            pathname: "/bookfirststep",
                                            state: {
                                                // searchdata: { s }
                                                searchdata: JSON.stringify(s)
                                            }
                                        }}>BOOK</Link>
                                </Button>
                                </Col><Col /></Row>

                            </div>

                    )
                }
            </div>
            )
        }

    }


    const pricesplit = (a) => {
        var b = a.split("-")
        return (<><Row  className="text-white">
            <Col>&emsp; &emsp; &emsp; Ac Price: {b[0]} Rs/-</Col><Col/>
            <Col>Sl Price: {b[1]} Rs/-</Col>
            </Row></>
        )
    }
    //console.log(traindetails)
    return (
        <div className="paraimg3">
            {/* <Button onClick={componen}>search</Button>
            <table className="table table-striped table-bordered dt-responsive nowrap">
                <thead>
                    <tr>

                        <th>Train Number</th>
                        <th>Train Name</th>
                        <th>Train Type</th>
                        <th>Train Starting Date</th>
                        <th>Train Ending Date</th>
                        <th>Coach Typse</th>
                        <th>Station1 Name</th>
                        <th>Station1 date</th>
                        <th>Station1 Arrival Time</th>
                        <th>Station Depature Time</th>
                        <th>Station2 Name</th>
                        <th>Staion2 Date</th>
                        <th>Station2 Arrival Time</th>
                        <th>Station2 Depature Time</th>
                        <th>Sleaper Available Seats</th>
                        <th>Ac Available Seats</th>
                        <th>Distance</th>
                        <th>Ac Price</th>
                        <th>Sl Price</th>


                    </tr>
                </thead>
                {print()}


            </table> */}
            {printstyle()}
          
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>


    )
}

export default TrainSearchDetails
