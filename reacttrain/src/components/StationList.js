import React, { useState, useEffect } from 'react'
import AxiosService from '../securitys/AxiosService'
import { useHistory } from 'react-router-dom';
import { Col, Row, Form } from "react-bootstrap";
import Table from 'react-bootstrap/Table'
import {
    BrowserRouter as Router,
    Switch,
    Route,
    withRouter,
    Link
} from "react-router-dom";
import Button from 'react-bootstrap/Button'

function StationList(props) {
    const history = useHistory()
    const [stations, setstations] = useState("")
    const [trains, setTrains] = useState([])
    const [deleted, setdeleted] = useState(false)

    useEffect(() => {

        AxiosService.getTrainListNumber().then((res) => {

            if (res.data != "") { setTrains(res.data) }
            else { console.log("bingo") }
        })


        AxiosService.getAllStations().then((res) => {
            if (res.data !== null) {
                setstations(res.data)
            }
        })
    }, [])

    console.log(stations)

    const trinname = (i) => {
        var j
        for (j = 0; j < trains.length; j++) {
            if (trains[j].trainno === i) {
                return (
                    <p>{trains[j].trainname}</p>
                )
            }
        }

    }

    const handleaddstation = () => {
        history.push(`/addstation`)
    }

    const deletehandler = (id) => {
        AxiosService.deleteStationDetails(id).then((res) => {
            if (res.data === "success") {
                setdeleted(true)
            }
        })
    }

    const updatehandler = (id) => {
        history.push(`/updatestation/${id}`)
    }

    const alerts = () => {
        if (deleted) {
            return (
                <div class="alert alert-warning" role="alert">
                    Successfully delete
                </div>)
        }
    }

    const tables = () => {
        if (stations !== "") {
            return (

                <div className="paraimg3 text-white">
                    <h2 className='text-center'>Station Table</h2>
                    {alerts()}
                    <div className='text-center'>
                        <button className='btn btn-success' onClick={handleaddstation}>Add Station</button>
                    </div>

                    {
                        stations.map(
                            stationtimetable =>
                                <div key={stationtimetable.station_id}>

                                    <div className="form-container2 rounded border border-primary mb-2">

                                        <Button className="float-right btn btn-danger" onClick={() => deletehandler(stationtimetable.station_id)}>Delete</Button>
                                        <Button className="float-legt" onClick={() => updatehandler(stationtimetable.station_id)}>Update</Button>

                                        <Row><Col /> <Col> {stationtimetable.station_id}</Col><Col>{stationtimetable.station_name}</Col><Col />
                                        </Row>
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


                                        </Table>



                                    </div>
                                </div>

                        )
                    }
                </div>



            )
        }
    }

    return (
        <div>

            {tables()}

        </div>
    )
}

export default withRouter(StationList)
