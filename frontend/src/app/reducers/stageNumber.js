import {createSlice} from "@reduxjs/toolkit";

export const stageNumberSlice = createSlice({
    name: 'stageNumber',
    initialState: {
        value: 0
    },
    reducers: {
        incrementStage: (state) => {
            state.value++;
        },
        decrementStage: (state) => {
            state.value--;
        }
    }
});

export const {incrementStage, decrementStage} = stageNumberSlice.actions;

export default stageNumberSlice.reducer;