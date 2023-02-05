import React, {useState} from 'react';
import './LoginForm.css';
import {useDispatch, useSelector} from "react-redux";
import AuthService from "../../services/AuthService";
import isEmail from "validator/es/lib/isEmail";
import {setIsAuth} from "../../app/reducers/isAuth";
import {setUser} from "../../app/reducers/user";
import axios from "axios";

export default function LoginForm(props) {
    const [userName, setUserName] = useState();
    const [password, setPassword] = useState();

    const user = useSelector(state => state.user.value);
    const isAuth = useSelector(state => state.isAuth.value);
    const dispatch = useDispatch();

    const login = async (userName, password) => {
        const headers = {"Content-Type": "application/json"};
        const data = {username: userName, password: password}
        try {
            /*
            const response = await AuthService.login(userName, password);
            localStorage.setItem('token', response.data.token);
            dispatch(setIsAuth(true));
            dispatch(setUser(response.username));*/
            axios.post("http://localhost:8080/auth/signin", data, {headers: headers})
                .then(response => {
                    window.console.log(response);
                    localStorage.setItem('token', response.data.token);
                    dispatch(setIsAuth(true));
                    dispatch(setUser(response.data.username));
                })
                .catch(response => window.console.log(response));
        } catch (e){
            console.log(e);
        }
    }


    return (
        <div className={'action'} >
            <input
                type="text"
                value={userName}
                onChange={e => setUserName(e.target.value)}
            />
            <input
                type="text"
                value={password}
                onChange={e => setPassword(e.target.value)}
            />
            <button onClick={() => login(userName, password)}>Login</button>
        </div>
    )
}