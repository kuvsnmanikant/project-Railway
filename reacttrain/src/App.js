import logo from './logo.svg';
import React, { useState, useEffect } from 'react'
import './App.css';
import { Provider } from 'react-redux';
import store from './reduxfolder/store';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Bar from './components/Taskbar';
import Home from './components/Home';
import Login from './components/Login';
import Signin from './components/Sifnup';
import TrainList from './components/TrainList';
import ProtectedRoute from './securitys/ProtectedRoute';
import CustomerRout from './securitys/CustomerRout';
import AddTrain from './components/AddTrain';
import AddStation from './components/AddStation';
import Search from './components/Search';
import Status from './components/Status';
import TrainSearchDetails from './components/TrainSearchDetails'
import BookingFirstStep from './components/BookingFirstStep'
import StationList from './components/StationList'
import Profile from './components/Profile'
import UserBookingHistory from './components/UserBookingHistory'
import UpdateStation from './components/UpdateStation'
import UpdateTrain from './components/UpdateTrain'
import TrainPassengers from './components/TrainPassengers'
import Ticket from './components/Ticket'

function App(props) {
  const [Dark, setisDark] = useState();
  const [admin,setadmin]= useState(false)


  
  return (
    <Provider store={store}>

      <Router>
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <Bar Dark={Dark} setisDark={setisDark} /><div>

        <Switch>
          <Route path="/" exact component={Home}>
            {/* <Home Dark={Dark} setisDark={setisDark} /> */}
          </Route>
          <Route path="/home" exact component={Home}></Route>
          {/* <Route path="/features" component={TrainList}> */}
            {/* <TrainList/> */}
          {/* <h1>status</h1> 
          </Route>*/}
          {/* <Route path="/pricing" component={}>
            <h1>contact</h1>
          </Route> */}
         
          <Route path="/search" component={Search}>
            {/* <Tables /> */}
          </Route>
          <Route path="/login" component={Login}>
            {/* <Login /> */}
          </Route>
          <Route path="/signin" component={Signin}>
             {/* <Signin />  */}
          </Route>
          <Route path="/status" component={Status}></Route>

          <Route path="/trainsearch" component={TrainSearchDetails}></Route>
          <Route path="/bookfirststep" component={BookingFirstStep}></Route>
          
          <CustomerRout path="/profile" component={Profile}></CustomerRout>
          <CustomerRout path="/userhistory" component={UserBookingHistory}></CustomerRout>
          <CustomerRout path="/ticket/:id" component={Ticket}></CustomerRout>
        
          <ProtectedRoute path="/trainpassengers" component={TrainPassengers}></ProtectedRoute>
          <ProtectedRoute path="/updatestation/:id" component={UpdateStation}></ProtectedRoute>
          <ProtectedRoute path="/updatetrain" component={UpdateTrain}></ProtectedRoute>
          <ProtectedRoute path="/stationlist" component={StationList}></ProtectedRoute>
          <ProtectedRoute path="/trainlist" component={TrainList}></ProtectedRoute>
          <ProtectedRoute path='/addtrain' component={AddTrain}></ProtectedRoute>
          <ProtectedRoute path='/addstation' component={AddStation}></ProtectedRoute>

        </Switch></div>
    

      </Router>
    </Provider>
  );
}

export default App;

