import {FETCH_ITEM} from '../actions/types';

export default (state = [], action) =>{

    switch(action.type){
        case FETCH_ITEM:
        return action.payload;
       
        default:
            return state;
    }

};