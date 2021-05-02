import {combineReducers} from 'redux'
import TheamReducer from './Theam/TheamReducer'

const rootReducer = combineReducers({
    theam: TheamReducer
})

export default rootReducer