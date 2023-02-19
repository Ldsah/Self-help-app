import {createSlice} from "@reduxjs/toolkit";

export const manualNumberSlice = createSlice({
    name: 'manualNumber',
    initialState: {
        value: 0
    },
    reducers: {
        setManualNumber: (state, val) => {
            state.value = val;
        }
    }
});

export const {setManualNumber} = manualNumberSlice.actions;

export default manualNumberSlice.reducer;