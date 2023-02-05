import {configureStore} from '@reduxjs/toolkit';
import globalActionIdReducer from "./reducers/globalActionId";
import currentActionIdReducer from "./reducers/currentActionId";
import userReducer from "./reducers/user";
import isAuthReducer from "./reducers/isAuth";
import stageNumber from "./reducers/stageNumber";

export default  configureStore( {
    reducer: {
        globalActionId: globalActionIdReducer,
        currentActionId: currentActionIdReducer,
        user: userReducer,
        isAuth: isAuthReducer,
        stageNumber: stageNumber
    }
})