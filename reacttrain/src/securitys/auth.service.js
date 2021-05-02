import axios from "axios";

const API_URL= "http://localhost:8100/";

class AuthService{
    // login(username, password){
    //     return axios.prototype(API_URL+"authenticate",{
    //         username,
    //         password
    //     }).then(response =>{
    //         if(response.data.accessToken){
    //             localStorage.setItem("user", JSON.stringify(response.data))
    //         }
    //         return response.data;
    //     });
    // }
    logout(){
        localStorage.removeItem("role");
        localStorage.removeItem("token");
        localStorage.removeItem("man")
    }
    // register(username,password){
    //     return axios.post(API_URL+"signup",{
    //         username,
    //         password
    //     });
    // }

    getCurrentUser(){
        return JSON.parse(localStorage.getItem("user"));
    }

   
}
export default new AuthService();