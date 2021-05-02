import axios from 'axios'
axios.defaults.withCredentials= true;

const TRAIN_SEARCH= 'http://localhost:8091/search/'

const TRAIN_TRAIN= 'http://localhost:8091/train/'

const PASSENGER= 'http://localhost:8092/search/'

const TICKET= "http://localhost:8093/search/"

const BOOKING= "http://localhost:8094/booking/"

const USER= "http://localhost:3001/user/"

class AxiosService {
    
    getAllTrain(){
        return axios.get(TRAIN_TRAIN+"alltrains");
    }

    getAllStations(){
        return axios.get("http://localhost:8091/station/allstations");
    }

    getStaionListNumber(){
        return axios.get(TRAIN_SEARCH+"stations");
    }

    updateStation(d){
        return  axios.put(TRAIN_SEARCH+"updatestation",d);
    }

    getTrainListNumber(){
        return axios.get(TRAIN_SEARCH+"gettrainlist");
    }

    getTrainTimeTable(id){
        return axios.get(TRAIN_SEARCH+"traintimetable/"+id);
    }
    getStationTimeTable(sid){
        return axios.get(TRAIN_SEARCH+"stationtimetable/"+sid);
    }

    addNewStation(st){
        return axios.post(TRAIN_SEARCH+"addstation",st);
    }

    addNewTrain(tr){
        return axios.post(TRAIN_SEARCH+"addtrain",tr);
    }

    getPassengerStatus(pnr){
        return axios.get(PASSENGER+"passengerstatus/"+pnr);
    }

    getSearchTrains(d){
        return axios.post(TICKET+"searchtrains",d);
    }

    getBookingFirstStep(d){
        return axios.post(BOOKING+"firststep",d);
    }

    deleteUserAccount(id){
        return axios.delete(USER+"deleteuser/"+id);
    }

    getUserHistory(id){
        return axios.get(PASSENGER+"passengerbooked_by/"+id);
    }
    
    getCancleTicket(id){
        return axios.get(PASSENGER+"passengercancle/"+id);
    }

    deleteTrainDetails(id){
        return axios.delete(TRAIN_SEARCH+"deletetrain/"+id);
    }

    deleteStationDetails(id){
        return axios.delete(TRAIN_SEARCH+"deletestation/"+id);
    }

    getFareDetails(type){
        return axios.post(BOOKING+"firststeps",type);
    }
    getPNRNumber(o){
        return axios.post(BOOKING+"laststep",o);
    }

    getTrainPassengersDate(t,d){
        return axios.get(PASSENGER+"passengersdatetrain/"+t+"/"+d);
    }

    getPriceFromBooking(d){
        return axios.get(BOOKING+"getpricedatabase/"+d);
    }
  
}

export default new AxiosService();