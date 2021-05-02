package com.capgemini.project.microservice_booking.interfaces;

import com.capgemini.project.microservice_booking.models.SendPriceDetails;
import com.capgemini.project.microservice_booking.models.GetSendPriceDetails;
// this method is implemented by the Booking1service
public interface Booking1Interface{
    public SendPriceDetails sendPriceDetails(GetSendPriceDetails gspd);
}