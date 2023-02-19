import {configureStore} from '@reduxjs/toolkit';
import globalActionIdReducer from "./reducers/globalActionId";
import currentActionIdReducer from "./reducers/currentActionId";
import stageNumber from "./reducers/stageNumber";
import lastActionId from "./reducers/lastActionId";
import manualNumber from "./reducers/manualNumber";
import manual from "./reducers/manual";

export default  configureStore( {
    reducer: {
        globalActionId: globalActionIdReducer,
        currentActionId: currentActionIdReducer,
        stageNumber: stageNumber,
        lastActionId: lastActionId,
        manualNumber: manualNumber,
        manual: manual
    }
})