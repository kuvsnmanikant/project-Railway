package com.capgemini.project.microservice_booking.services;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import com.capgemini.project.microservice_booking.database.Booking1Database;
import com.capgemini.project.microservice_booking.hystrixs.HystrixAddPassenger;
import com.capgemini.project.microservice_booking.hystrixs.HystrixDeletePassenger;
import com.capgemini.project.microservice_booking.hystrixs.HystrixForPassenger;
import com.capgemini.project.microservice_booking.hystrixs.HystrixForTrain;
import com.capgemini.project.microservice_booking.hystrixs.Ticket1Hystrix;
import com.capgemini.project.microservice_booking.interfaces.Booking1Interface;
import com.capgemini.project.microservice_booking.models.Booking;
import com.capgemini.project.microservice_booking.models.GetPassengerData;
import com.capgemini.project.microservice_booking.models.GetSendPriceDetails;
import com.capgemini.project.microservice_booking.models.GettingPassenger;
import com.capgemini.project.microservice_booking.models.ListOfStationsAndCoaches;
import com.capgemini.project.microservice_booking.models.Passenger;
import com.capgemini.project.microservice_booking.models.PassengerConveter;
import com.capgemini.project.microservice_booking.models.PassengerDetails;
import com.capgemini.project.microservice_booking.models.PassengerPrice;
import com.capgemini.project.microservice_booking.models.ReturnPriceDetails;
import com.capgemini.project.microservice_booking.models.SendPriceDetails;
import com.capgemini.project.microservice_booking.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Booking1Service implements Booking1Interface{
    // creating the instance of the Ticket1Hystrix 
    @Autowired
    private Ticket1Hystrix th;

// creating the instance of the HystrixForPassenger 
    @Autowired
    private HystrixForPassenger hfp;

// creating the instance of the HystrixForTrain 
    @Autowired
    private HystrixForTrain hft;

// creating the instance of the HystrixAddPassenger 
    @Autowired
    private HystrixAddPassenger hap;

// creating the instance of the HystrixDeletePassenger 
    @Autowired
    private HystrixDeletePassenger hdp;

// creating the instance of the Booking1Database 
    @Autowired
    private Booking1Database bdb;

// this method will calculate the frice based on the train type coach type food and noumber of passengers
    public SendPriceDetails sendPriceDetails(GetSendPriceDetails gspd){
        
        Ticket t= th.getTicket(gspd.getTrain_type());
        SendPriceDetails spd= new SendPriceDetails();
        if(gspd.getCoach_type().equalsIgnoreCase("ac")){
            spd.setDistance_price(t.getPrice().getAc().getDistance());
            spd.setInsurance_price(t.getPrice().getAc().getInsurance());
            spd.setGst_percentage(5.0);
            spd.setSr_citizen_percentage(25.0);
            spd.setHadicap_percentage(20.0);
            if(gspd.getFood_type().equalsIgnoreCase("nv")){
                spd.setFood_price(t.getPrice().getAc().getFood().getNv());
            } else {
                spd.setFood_price(t.getPrice().getAc().getFood().getVeg());   
            }
        } else {
            spd.setDistance_price(t.getPrice().getSl().getDistance());
            spd.setInsurance_price(t.getPrice().getSl().getInsurance());
            spd.setGst_percentage(5.0);
            if(gspd.getFood_type().equalsIgnoreCase("nv")){
                spd.setFood_price(t.getPrice().getSl().getFood().getNv());
            } else {
                spd.setFood_price(t.getPrice().getSl().getFood().getVeg());   
            }
        }

return spd;
    }

// this mthod will genertate the PNR number and allocate the seat dinamically and update the passenger data base
    public String getPassengerData(GetPassengerData gpd){
        String retu="-";
        int no_passengers= gpd.getPd().size();
        String s="";
        if(gpd.getSd().getCoach_type().equalsIgnoreCase("ac")){
            if(no_passengers>(gpd.getSd().getAc_seats()+3)){return "required number of seats not available";}
            s= "A";
        }else{
            if(no_passengers>(gpd.getSd().getSl_seats()+3)){return "required number of seats not available";}
            s= "S";
        }

        ListOfStationsAndCoaches lsc= hft.getListOfStationsAndCoaches(gpd.getSd().getTrain_no(), gpd.getSd().getCoach_type());
        
        int si=lsc.getStations().indexOf(gpd.getSd().getS1());
        int di=lsc.getStations().indexOf(gpd.getSd().getS2());
        GettingPassenger gp =new GettingPassenger();
        gp.setTrainno(gpd.getSd().getTrain_no());
        gp.setDate(gpd.getSd().getTrain_start());
        gp.setA(si);
        gp.setB(di);
        PassengerConveter pc = hfp.hskjjk(gp);
       
        String[] seat= new String[no_passengers];

        String b="0";
        int k=0;
      
        int man=no_passengers;
        for(int i=1;i<=lsc.getCoaches().size();i++){
         
            for(int j=1;j<=lsc.getCoaches().get(i-1);j++){
              
                b=s+i;
                b=b+"-"+j;
                for(Passenger p:pc.getP()){
                    
                    boolean isFound = p.getSeat_no().indexOf(b) != -1 ? true : false;
                    if(isFound){
                        b="0";
                        break;
                    }
                }
                if(!b.equals("0")){
                    if(k<man){
                    seat[k]=b; k++;}
                }
              
                if(k>=man){
                   
                    break;
                }
                if(i==lsc.getCoaches().size() && j==lsc.getCoaches().get(i-1)){

                    for (int q=(no_passengers-1);q>k;q--){
                        seat[q]="-";
                    }

                }
            }
            if(k==(no_passengers-1)){
                break;
            }
            
        }

        // generating the PNR number
        String pnr= "PNR"+gpd.getSd().getTrain_no()+(Math.random() * (99999 - 10000 + 1) + 10000);
        pnr=pnr.replace(".", "");
        int m=0;
        for (PassengerDetails ppp:gpd.getPd()){
            Passenger passenger= new Passenger();
            passenger.setId(""+Math.random());
            passenger.setP_name(ppp.getPassenger_name());
            passenger.setP_gender(ppp.getGender());
            passenger.setP_age(ppp.getAge());
            passenger.setP_handicap(ppp.getHandicap());
            passenger.setPnr_no(pnr);
            passenger.setP_trainno(gpd.getSd().getTrain_no());
            passenger.setP_trainname(gpd.getSd().getTrain_name());
            passenger.setJ_edate(gpd.getSd().getS2_date());
            passenger.setJ_date(gpd.getSd().getS1_date());
            passenger.setTs_date(gpd.getSd().getTrain_start());
            passenger.setTe_date(gpd.getSd().getTrain_end());
            passenger.setFood(ppp.getFood_type());
            passenger.setStart(gpd.getSd().getS1_name());
            passenger.setDestination(gpd.getSd().getS2_name());
            passenger.setStart_index(si);
            passenger.setDestination_index(di);
            passenger.setSeat_no(seat[m]);
            passenger.setBooked_by(gpd.getBooked_by());
            if(seat[m].equals("-")){
                passenger.setR_status("waiting list");
            } else{
                passenger.setR_status("comform");   
            }
// updating the passengesr data
            String flag=hap.getAddPassenger(passenger);
            if(!flag.equals("success")){
                String d=hdp.getDeletePassenger(pnr);
                System.out.println(d);
                retu="faild";
            }
            m++;
        }
// updating the price data
        if(retu.equals("faild")){return "faild";}
        else{
            Booking book= new Booking();
            book.setPnr(pnr);
            book.setId(pnr);
            book.setRp(bookingFirstStep(gpd));
            bdb.save(book);
            return pnr;
        }
    }

    // this will return the price data on base of train type, coach type, food type, number passengers  
    public ReturnPriceDetails bookingFirstStep(GetPassengerData gspd){
        double distance=0.0;
        int veg=0;
        int nv=0;
        double amount=0.0;
        Ticket t= th.getTicket(gspd.getSd().getTrain_type());
        if(gspd.getSd().getCoach_type().equalsIgnoreCase("ac")){
            distance=t.getPrice().getAc().getDistance();
            veg=t.getPrice().getAc().getFood().getVeg();
            nv=t.getPrice().getAc().getFood().getNv();
        }else{
            distance=t.getPrice().getSl().getDistance();
            veg=t.getPrice().getSl().getFood().getVeg();
            nv=t.getPrice().getSl().getFood().getNv();
        }
           ReturnPriceDetails rpd= new ReturnPriceDetails();
        List<PassengerPrice> ppp= new ArrayList<>();
        List<PassengerDetails> list = gspd.getPd();
        for(PassengerDetails l:list){
            PassengerPrice pp= new PassengerPrice();
            pp.setName(l.getPassenger_name());
            pp.setPrice(gspd.getSd().getDistance()*distance);
            int a=gspd.getSd().getDistance()/250;
          
            if(a<1){a=1;}
            if(l.getFood_type().equalsIgnoreCase("nv")){
                pp.setFood(a*nv);
            }else if(l.getFood_type().equalsIgnoreCase("veg")){
                pp.setFood(a*veg);
            }else{
                pp.setFood(0.0);
            }
            double aa=0.0;
            if(l.getHandicap().equalsIgnoreCase("h")){
                aa=(gspd.getSd().getDistance()*distance)/5.0;
                pp.setDiscount(aa);
            }else if(l.getHandicap().equalsIgnoreCase("s")){
                aa=(gspd.getSd().getDistance()*distance)/4.0;
                pp.setDiscount(aa);
            }else{
                pp.setDiscount(0.0);
            }
            pp.setAmount((gspd.getSd().getDistance()*distance)-aa);
            amount+=(gspd.getSd().getDistance()*distance)-aa+pp.getFood();
            ppp.add(pp);
        }
        double gst=amount/20;
        amount=amount+gst;
        rpd.setPp(ppp);
        rpd.setGst(""+gst);
        rpd.setTotal(""+amount);
        return rpd;
    }

    public Booking getPriceDetails(String s){
        return bdb.findByPnr(s);
    }
   
}
