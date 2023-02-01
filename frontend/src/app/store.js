import {configureStore} from '@reduxjs/toolkit';
import globalActionIdReducer from "./reducers/globalActionId";

export default  configureStore( {
    reducer: {
        globalActionId: globalActionIdReducer
    }
})