package com.capgemini.project.microservice_ticket.services;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.project.microservice_ticket.hystrixes.HystrixForPassenger;
import com.capgemini.project.microservice_ticket.hystrixes.HystrixForTrain;
import com.capgemini.project.microservice_ticket.models.ConvertSearchDetails;
import com.capgemini.project.microservice_ticket.models.GettingPassenger;
import com.capgemini.project.microservice_ticket.models.Passenger;
import com.capgemini.project.microservice_ticket.models.PassengerConveter;
import com.capgemini.project.microservice_ticket.models.SearchDetails;
import com.capgemini.project.microservice_ticket.models.Ticket;
import com.capgemini.project.microservice_ticket.models.TrainSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    // it is creating the instance for the HystrixForPassenger
    @Autowired
    private HystrixForPassenger hfp;

     // it is creating the instance for the HystrixForTrain
    @Autowired
    private HystrixForTrain hft;

     // it is creating the instance for the Ticket1Service
    @Autowired
    private Ticket1Service ticket1Service;

    // it will find the available seats from the give data
    public String findAvailableSeats(PassengerConveter pc) {
        int ac = 0, sl = 0;
        for (Passenger p : pc.getP()) {
            boolean isFound = p.getSeat_no().indexOf("A") != -1 ? true : false;
            if (isFound) {
                ac++;
            }
            isFound = p.getSeat_no().indexOf("S") != -1 ? true : false;
            if (isFound) {
                sl++;
            }
        }
        return ac + "-" + sl;
    }

    // it will fetch the data from the trian microservice andcalculate the price and return the data
    public ConvertSearchDetails getTrain(TrainSearch ts) {
        ConvertSearchDetails c = hft.getTrain(ts);
        List<SearchDetails> returnDetails = new ArrayList<>();
        for (SearchDetails sd : c.getS()) {
            String[] ar = sd.getS1().split("-");
            int si = Integer.parseInt(ar[1]);
            ar = sd.getS2().split("-");
            int di = Integer.parseInt(ar[1]);
            GettingPassenger b = new GettingPassenger(sd.getTrain_no(), sd.getTrain_start(), si, di);
            PassengerConveter pc = hfp.hskjjk(b);
            int ac_seat, sl_seat;
            // String seats= findAvailableSeats(pc);
            ar = findAvailableSeats(pc).split("-");
            ac_seat = sd.getAc_seats() - (Integer.parseInt(ar[0]));
            sl_seat = sd.getSl_seats() - Integer.parseInt(ar[1]);
            Ticket ticket = ticket1Service.findByTrainType(sd.getTrain_type());
            double price1 = ticket.getPrice().getAc().getDistance() * sd.getDistance();
            double price2 = ticket.getPrice().getSl().getDistance() * sd.getDistance();

            String price = price1 + "-" + price2;
            returnDetails.add(
                    new SearchDetails(sd.getTrain_no(), sd.getTrain_name(), sd.getTrain_type(), sd.getTrain_start(),
                            sd.getTrain_end(),sd.getCoach_type(), sd.getS1().split("-")[0], sd.getS2().split("-")[0], sd.getS1_name(),
                            sd.getS2_name(), sd.getS1_arival(), sd.getS1_departure(), sd.getS1_date(), sd.getS2_date(),
                            sd.getS2_arival(), sd.getS2_departure(), sl_seat, ac_seat, sd.getDistance(), price));
        }

        // GettingPassenger g = new GettingPassenger("102030", "21-04-2021", 1, 2);
        // PassengerConveter bgin = hfp.hskjjk(g);

        // return bgin;
        ConvertSearchDetails cc= new ConvertSearchDetails(returnDetails);
        return cc;
    }

}