import {createSlice} from "@reduxjs/toolkit";

export const lastActionIdSlice = createSlice({
    name: 'lastActionId',
    initialState: {
        value: {id: undefined, stage: undefined}
    },
    reducers: {
        setLast: (state, obj) => {
            state.value = obj;
        }
    }
});

export const {setLast} = lastActionIdSlice.actions;

export default lastActionIdSlice.reducer;