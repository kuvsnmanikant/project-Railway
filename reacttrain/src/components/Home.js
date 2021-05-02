import React, { useState, useEffect } from 'react'
import Button from 'react-bootstrap/Button'
import {
    BrowserRouter as Router,
    Link
} from "react-router-dom";
import Alert from './Alert';
import axios from 'axios'
import './cSs/Home.css';
import Form from 'react-bootstrap/Form'
axios.defaults.withCredentials = true;

function Home(props) {
    const aaa = {
        backgroundImage: `url( $ { a } )`
    }

    const [stations, setstations] = useState([])
    const [loginstatus, setloginstatus] = useState('')


    useEffect(() => {
        axios.get('http://localhost:3001/user/getuser1').then((res) => {
            console.log(res)
            if (res.data.loggedin) {
                setloginstatus(res.data.user[0].user_id)
            }
        })

        axios.get('http://localhost:8091/search/stations').then((res) => {

            if (res.data != "") { setstations(res.data) }
            else (console.log("bingo"))

        })
        console.log(stations)

        


    }, [])

    const [from, setfrom] = useState("")
    const [to, setto] = useState("")
    const [date, setdate] = useState("")
    const [clas, setclas] = useState("")
    const [general, setgeneral] = useState("")
    const [redirect, setRedirect] = useState(false);


    

    // const handlesubmition = (e) => {
    //     e.preventDefault();
    //     var r = date.split("-");
    //     setdate1(r[2] + "-" + r[1] + "-" + r[0])
    //     let d = { s1: from, s2: to, d: date1, c: clas, g: general }

    //     AxiosService.getSearchTrains(d).then((res) => {
    //         if (res.data !== "") {
    //             setsearchdata(res.data)
    //             dis()

    //         }
    //     })

    //     console.log(searchdata.s);
    // }
    // const dis = () => {
    //     if (searchdata !== "") {

    //         return (
    //             <TrainSearchDetails searchdata={searchdata} />
    //         )
    //     }
    // }

    

    const submithandlerjsj =() =>{   


    if(from !=="" && to !=="" && date !=="" && clas !=="" && general !==""){
        setRedirect(true)
    }else{
        setRedirect(false)
        var a=""
        if(from ===""){a=a+"form, "}
        if(to ===""){a=a+"to, "}
        if(date ===""){a=a+"date, "}
        if(clas ===""){a=a+"class, "}
        if(general ==""){a=a+"general "}
        a=a+"are empty please enter"
        alert(a)

    }
    }

    const buttonsman =() =>{
        if(!redirect){
            return(
                <Button onClick={submithandlerjsj}>check</Button>
            )
        }else{
            return(
                <Link class='text-white'
                            to={{
                                pathname: "/trainsearch",

                                state: {
                                    s1: { from },
                                    s2: { to },
                                    d: { date },
                                    c: { clas },
                                    g: { general }
                                }
                            }}
                        >
                            <Button >Submit</Button></Link>

            )
        }
    }

    return (

        <>
            <Alert />
            <div className="paraimg1">

                <Form className="form-container1">
                    <h1 className="h1tag">Book Ticket</h1>
                    <Form.Row>


                        <select className="form-control1" required onChange={e => setfrom(e.target.value)}>
                            <option class="hidden" selected disabled>Select From</option>
                            {
                                stations.map(
                                    station =>
                                        <option key={station.sn} value={station.sn}>{station.s}</option>
                                )
                            }

                        </select>
                        &emsp;

                        <select className="form-control1" required onChange={e => setto(e.target.value)}>
                            <option class="hidden" selected disabled>Select To</option>
                            {
                                stations.map(
                                    station =>
                                        <option key={station.sn} value={station.sn}>{station.s}</option>
                                )
                            }

                        </select>

                    </Form.Row>
                    <br />
                    <Form.Row>
                        <input type="date" id="birthday" name="birthday" className="form-control1" onChange={e => setdate(e.target.value)} required/>
                        &emsp;
                        <select className="form-control1" required onChange={e => setclas(e.target.value)}>
                            <option class="hidden" selected disabled>Select Class</option>
                            <option value="ac">Ac</option>
                            <option value='sl'>Sl</option>
                        </select>
                    </Form.Row>
                    <br />
                    <Form.Row>
                        <select className="form-control1" required onChange={e => setgeneral(e.target.value)}>
                            <option class="hidden" selected value="general">General</option>
                            <option value="handicaped">Handicaped</option>
                            <option value='sr.citizen'>Sr.citizen</option>
                        </select>&emsp;

                          
                        {buttonsman()}

                           

                    </Form.Row>
                </Form>
                <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

            </div>

        </>
    )
}

export default Home
