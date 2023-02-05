import {createSlice} from "@reduxjs/toolkit";

export const isAuthSlice = createSlice({
    name: 'user',
    initialState: {
        value: false
    },
    reducers: {
        setIsAuth: (state, isAuth) => {
            state.value = isAuth;
        }
    }
});

export const {setIsAuth} = isAuthSlice.actions;

export default isAuthSlice.reducer;