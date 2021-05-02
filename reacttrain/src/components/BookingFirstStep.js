import React, { useState, useEffect } from 'react'
import AxiosService from '../securitys/AxiosService'
import Button from 'react-bootstrap/Button'
import Table from 'react-bootstrap/Table'

import { useHistory } from 'react-router-dom';
// import Form from 'react-bootstrap/Form'
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import Alert from 'react-bootstrap/Alert'
import { Col, Row, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";
import { produce } from 'immer'
function BookingFirstStep(props) {

    const history=useHistory()
    const [food, setfood] = useState("")
    const [coach, setcoach] = useState("")
    //  const [price, data]
    const [passengers, setpassengers] = useState("")
    const sss = props.location.state
    const aa = JSON.parse(sss.searchdata)

    useEffect(() => {
        console.log(aa)
        // AxiosService.getFareDetails(aa.train_type).then((res) => {
        //     if (res.data) {
        //         console.log(res.data)
        //     }
        // })
    }, [])



    // const handlebutton = () => {
    //     // let a=searchdata.s
    //     // let b=a.train_type
    //     let d = {
    //         train_type: "mm",
    //         coach_type: coach,
    //         food_type: food
    //     }
    //     AxiosService.getBookingFirstStep(d).then((res) => {
    //         console.log(res.data)
    //     })
    // }


    const coachtypes = () => {
        if (aa.coach_type === "all") {
            return (

                <div class="form-group">
                    <div class="maxl" onChange={(e) => setcoach(e.target.value)}>
                        <label class="radio inline">
                            <input type="radio" name="gender" value="AC" checked required />
                            <span>Coach type Ac </span>
                        </label>&emsp;
                         <label class="radio inline">
                            <input type="radio" name="gender" value="SL" required />
                            <span>Coach type Sl </span>
                        </label>
                    </div>
                </div>
            )
        }

    }

    const [pd, setpd] = useState([{
        passenger_name: "",
        age: "",
        gender: "m",
        handicap: "g",
        food_type: "n"
    }])


    const handleadd = (i) => {
        if (i < 5) {
            setpd([...pd, {
                passenger_name: "",
                age: "",
                gender: "m",
                handicap: "g",
                food_type: "n"
            }])
        }
    }

    const handlesubtract = (index) => {
        const v = [...pd];
        v.splice(index, 1);
        setpd(v);
    }

    const handlecheck = () => {
        if (localStorage.getItem('man') !== null) {
            const us = JSON.parse(localStorage.getItem('man'))

            let bingo = { sd: aa, booked_by: us.user_id, pd: pd }          
            AxiosService.getFareDetails(bingo).then((res) => {
                if (res.data !== null) {
                    setpassengers(res.data)
                }
                console.log(res.data)
            })
        } else {
            alert("Please Log In")
        }
    }

    const handlebooking = () => {
        const us = JSON.parse(localStorage.getItem('man'))

            let bingo = { sd: aa, booked_by: us.user_id, pd: pd }
console.log(bingo)
         AxiosService.getPNRNumber(bingo).then((res) => {
             if(res.data.includes("PNR")){
              //   alert(res.data)
                var id=res.data
                 history.push(`/ticket/${id}`)
             }
                console.log(res.data)
            })

    }

    const pleaseLogIn = () => {
        if (passengers !== "") {
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
                                passengers.pp.map((p, index) => {
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
                                    <Col> {passengers.gst}<br /></Col>
                                </Row>
                                <Row><Col>
                                    TOTAL AMOUNT:</Col><Col> {passengers.total}</Col>
                                </Row>
                            </tbody>
                        </Table>
                        <Button className="float-right" onClick={handlebooking}>BOOK</Button><br/>
                    </div>
                    
                </>
            )
        }
    }

    return (<>
        <div className="paraimg3 text-white" >
           
            <h2 className="text-center" >Add Passenger's Details</h2>
            {coachtypes()}
            {/* <div className="container rounded-sm border border-dark"> */}
            <div className="form-container2 rounded border border-primary mb-2">
                {
                    pd.map((p, index) => {
                        return (
                            // <div key={index} className="container border border-dark rounded-sm">
                            <div key={index}  >
                                <Form>

                                    <Form.Row>
                                        <Col>
                                            <Form.Group  >
                                                <Form.Label>Name</Form.Label>
                                                <Form.Control type="text" title="enter the passenger name" placeholder="Passenger Name" value={p.passenger_name}
                                                    onChange={
                                                        e => {
                                                            const passenger_name = e.target.value
                                                            setpd(c =>
                                                                produce(c, (v) => {
                                                                    v[index].passenger_name = passenger_name
                                                                })
                                                            )
                                                        }
                                                    } />

                                            </Form.Group>
                                        </Col>
                                        <Col>
                                            <Form.Group controlId="exampleForm.ControlInput1">
                                                <Form.Label>Gender</Form.Label>
                                                <Form.Control as="select" title="select any one" value={p.gender}
                                                    onChange={
                                                        e => {
                                                            const gender = e.target.value
                                                            setpd(c =>
                                                                produce(c, (v) => {
                                                                    v[index].gender = gender
                                                                })
                                                            )
                                                        }
                                                    } >
                                                    <option value="m">Male</option>
                                                    <option value="f">Female</option>
                                                    <option value="o">Others</option>
                                                </Form.Control>
                                                {/* <div style={{fontSize:10,color:"red"}}>{train_dayerror}</div> */}
                                            </Form.Group>
                                        </Col>
                                        {/* </Form.Row>

                                    <Form.Row> */}
                                        <Col>
                                            <Form.Group controlId="exampleForm.ControlInput1">
                                                <Form.Label>General</Form.Label>
                                                <Form.Control as="select" title="select any one" value={p.handicap}
                                                    onChange={
                                                        e => {
                                                            const handicap = e.target.value
                                                            setpd(c =>
                                                                produce(c, (v) => {
                                                                    v[index].handicap = handicap
                                                                })
                                                            )
                                                        }
                                                    } >
                                                    <option value="g">General</option>
                                                    <option value="h">Handicaped</option>
                                                    <option value="s">Sr.citizen</option>
                                                </Form.Control>
                                            </Form.Group>
                                        </Col>
                                        <Col>
                                            <Form.Group controlId="exampleForm.ControlInput1">
                                                <Form.Label>Food Type</Form.Label>
                                                <Form.Control as="select" title="select any one" value={p.food_type}
                                                    onChange={
                                                        e => {
                                                            const food_type = e.target.value
                                                            setpd(c =>
                                                                produce(c, (v) => {
                                                                    v[index].food_type = food_type
                                                                })
                                                            )
                                                        }
                                                    } >
                                                    <option value="n">None</option>
                                                    <option value="nv">Non-Veg</option>
                                                    <option value="veg">Veg</option>
                                                </Form.Control>

                                            </Form.Group>
                                        </Col>
                                        {/* </Form.Row>
                                    <Form.Row> */}
                                        <Col>
                                            <Form.Group controlId="exampleForm.ControlInput1">
                                                <Form.Label>Age</Form.Label>
                                                <Form.Control type="number" title="pleas enter valid age" placeholder="Age" value={p.age}
                                                    onChange={
                                                        e => {
                                                            const age = e.target.value
                                                            setpd(c =>
                                                                produce(c, (v) => {
                                                                    v[index].age = age
                                                                })
                                                            )
                                                        }
                                                    } />

                                            </Form.Group>
                                        </Col>
                                        <Col>
                                            <Button variant="outline-info float-right" onClick={() => handleadd(index)}>+</Button>
                                            <Button variant="outline-info float-right" onClick={() => handlesubtract(index)}>-</Button>
                                        </Col>
                                    </Form.Row>


                                </Form>
                                <br /><hr />
                            </div>
                        )
                    }
                    )
                }
                <Button onClick={handlecheck}>Check Price</Button>
                {/* <Button >
                                    <Link className="text-white"
                                        to={{
                                            pathname: "/bookingmidlestep",
                                            state: {
                                                // searchdata: { s }
                                                searchdata: JSON.stringify({ sd: aa, pd: pd })
                                            }
                                        }}>BOOK</Link>
                                </Button> */}

            </div>
            <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
            {pleaseLogIn()}
            <br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
        </div>
    </>

    )
}

export default BookingFirstStep
