import {createSlice} from "@reduxjs/toolkit";

export const manualSlice = createSlice({
    name: 'manual',
    initialState: {
        value: 0
    },
    reducers: {
        setManual: (state, val) => {
            state.value = val;
        }
    }
});

export const {setManual} = manualSlice.actions;

export default manualSlice.reducer;