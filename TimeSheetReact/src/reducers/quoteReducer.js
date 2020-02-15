
import {FETCH_QUOTE} from '../actions/types';

export default (state = [], action) =>{

    switch(action.type){
        case FETCH_QUOTE:
        return action.payload;
       
        default:
            return state;
    }

};