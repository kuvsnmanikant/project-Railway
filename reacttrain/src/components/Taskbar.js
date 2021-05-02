import React, { useState, useEffect } from 'react'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import Form from 'react-bootstrap/Form'
import FormControl from 'react-bootstrap/FormControl'
import Button from 'react-bootstrap/Button'
import NavDropdown from 'react-bootstrap/NavDropdown'
import BootstrapSwitchButton from 'bootstrap-switch-button-react'
import logo0 from './images/formbg.png'
import logo1 from './images/Picture3.png'
import './cSs/images.css'
import { setTheam } from '../reduxfolder'
import { connect } from 'react-redux';
import { useSelector, useDispatch } from 'react-redux';
import authService from '../securitys/auth.service'
import { useHistory } from 'react-router-dom';

function Taskbar(props) {
   
    
    const [light, setLight] = useState('light')
    const history=useHistory()
    const [showUser, setShowuser]= useState(false);
    const [showAdmin, setShowAdmin]= useState(false);
    const [currentUser, setCurrentUser]= useState(undefined);
    const [admin,setadmin]= useState(false)
    const [prof,setprof]= useState(false)
    useEffect(() => {
        setLight(props.Dark ? "light" : "dark")
        const user= authService.getCurrentUser();
        // if(user){
        //     setCurrentUser(authService.getCurrentUser());
        //     setShowuser(user.role.includes('USER'));
        //     setShowAdmin(user.roles.includes('ADMIN'))
        // }
        if(localStorage.getItem('role') === 'ADMIN'){
            setadmin(true)
          }
          if(localStorage.getItem('role') !== null){
            setprof(true)
          }

    });

  const logOut= ()=>{
      authService.logout();
      history.push(`/home`)
  }

  const log =() =>{
      if(localStorage.getItem('role') !== null){
          return(
            <Nav.Link onClick={logOut}>Log Out</Nav.Link>
          )
      }else {
          return(
            <Nav.Link href="/login">Log In</Nav.Link>
          )
      }
  }

  const adminTaskbar =() =>{
    if(admin){
      return(
        <NavDropdown title="Admin" id="collasible-nav-dropdown">
                           
        <NavDropdown.Item href="/stationlist">Station List</NavDropdown.Item>
            <NavDropdown.Item href="/trainpassengers">Train Passengers</NavDropdown.Item>
            <NavDropdown.Item href="/trainlist/">Train List</NavDropdown.Item>
            <NavDropdown.Divider />
           
        </NavDropdown>
        
      )
    }
  }

const Profile =() =>{
    if(prof){
        return(
<Nav.Link href="/profile">Profile</Nav.Link>
        )
    }

}

    return (
        <><header className='header'>
            <Navbar collapseOnSelect expand="lg" bg={light} variant={light} sticky="top">
                <Navbar.Brand href="/"><img src={props.Dark ? `${logo0}` : `${logo1}`} className="a" title="Home" alt="logo" /></Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link href="/status/">Status</Nav.Link>
                        <Nav.Link href="/search">Time Tables</Nav.Link>
                        {Profile()}
                        {adminTaskbar()}
                        
                    </Nav>
                    <Nav>{log()}
                   
                    
                       
                        <Nav.Link eventKey={2} href="signin">Sign In</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
            </header>

            {/* <Navbar bg="dark" variant="dark" sticky="top">
    <Navbar.Brand href="#home">Navbar</Navbar.Brand>
    <Nav className="mr-auto">
      <Nav.Link href="#home">Home</Nav.Link>
      <Nav.Link href="#features">Features</Nav.Link>
      <Nav.Link href="#pricing">Pricing</Nav.Link>
    </Nav>
    
  </Navbar> */}
  
        </>
    )
}

const mapStateToProps = state => {
    return {
        t: state.theam.t
    }
}

const mapDispatchToProps = dispatch => {
    return {
        setTheam: (Dark) => dispatch(setTheam(Dark))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Taskbar)
