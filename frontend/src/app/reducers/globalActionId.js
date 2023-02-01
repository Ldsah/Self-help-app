import {createSlice} from "@reduxjs/toolkit";
import updateGlobalActionIdStateByFunc from "../../Utils/updateGlobalActionIdState";

export const globalActionIdSlice = createSlice({
    name: 'globalActionId',
    initialState: {
        value: 'actionId-0'
    },
    reducers: {
        increment: (state) => {
            updateGlobalActionIdStateByFunc(state, numb => numb+1);
        },
        decrement: (state) => {
            updateGlobalActionIdStateByFunc(state, numb => numb-1);
        },
        reset: (state) => {
            state.value = 'actionId-0';
        }
    }
});

export const {increment, decrement, reset} = globalActionIdSlice.actions;

export default globalActionIdSlice.reducer;