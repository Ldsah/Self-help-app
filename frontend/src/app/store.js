import {configureStore} from '@reduxjs/toolkit';
import globalActionIdReducer from "./reducers/globalActionId";
import currentActionIdReducer from "./reducers/currentActionId";

export default  configureStore( {
    reducer: {
        globalActionId: globalActionIdReducer,
        currentActionId: currentActionIdReducer
    }
})