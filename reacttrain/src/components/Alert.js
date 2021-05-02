import React, { useState, useEffect } from 'react'
import Modal from 'react-bootstrap/Modal'
import Button from 'react-bootstrap/Button'

function Example() {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  useEffect(() => {
    // Your code here
    handleShow()
  }, []);
  return (
    <>


      <Modal
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
      >
        <Modal.Header closeButton>
          <Modal.Title>suggestions</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p style={{ fontSize: "20", fontWeight: "bold" }}>COVID 19 Alert:</p>

          <ul>
            <li>Information on Covid 19 Vaccination Programme</li>
            <li>Covid-19 Guidelines For Kumbh Mela 2021 at Haridwar.</li>
            <li>All passengers are hereby informed that downloading of Aarogya Setu App on their mobile phone, that they are carrying along, is advisable.</li>
            <li>All Passenger to kindly note that on arrival at their destination, the traveling passengers will have to adhere to such health protocols as are prescribed by the destination State/UT. Click Here to see state wise advisory on Arrival(As available). For other states, State Govt websites may be visited to ascertain the same.</li>

          </ul>


        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
            </Button>

        </Modal.Footer>
      </Modal>
    </>
  );
}

export default Example