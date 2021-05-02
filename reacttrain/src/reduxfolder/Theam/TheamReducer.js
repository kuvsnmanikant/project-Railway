import {Theam} from './Theamtype';

const initialState ={
    t:false
}

const TheamReducer =(state= initialState, action) =>{
    
    switch(action.type){
        
        case Theam:
            return{
                ...state,
                t:action.payload
            }
        default: return state    
    }
}

export default TheamReducer