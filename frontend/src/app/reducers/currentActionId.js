import {createSlice} from "@reduxjs/toolkit";

export const currentActionIdSlice = createSlice({
    name: 'currentActionId',
    initialState: {
        value: undefined
    },
    reducers: {
        set: (state, id) => {
            state.value = id;
        }
    }
});

export const {set} = currentActionIdSlice.actions;

export default currentActionIdSlice.reducer;