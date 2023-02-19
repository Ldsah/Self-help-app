import {createSlice} from "@reduxjs/toolkit";

export const currentActionIdSlice = createSlice({
    name: 'currentActionId',
    initialState: {
        value: {id: undefined, stage: undefined}
    },
    reducers: {
        set: (state, obj) => {
            state.value = obj;
        }
    }
});

export const {set} = currentActionIdSlice.actions;

export default currentActionIdSlice.reducer;