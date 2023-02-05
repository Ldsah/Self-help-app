import {createSlice} from "@reduxjs/toolkit";

export const userSlice = createSlice({
    name: 'user',
    initialState: {
        value: {}
    },
    reducers: {
        setUser: (state, user) => {
            state.value = user;
        }
    }
});

export const {setUser} = userSlice.actions;

export default userSlice.reducer;