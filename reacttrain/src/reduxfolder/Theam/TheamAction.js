import {Theam} from './Theamtype';

export const setTheam =(n="false") =>{
    return{
        type: 'Theam',
        payload: n
    }
}