import React, {useState} from 'react';
import './LoginForm.css';
import {useDispatch} from "react-redux";
import axios from "axios";
export default function LoginForm() {
    const [userName, setUserName] = useState();
    const [password, setPassword] = useState();

    const dispatch = useDispatch();

    const login = async (userName, password) => {
        const headers = {"Content-Type": "application/json","Accept" : 'application/json'};
        const data = {username: userName, password: password}
        try {

            axios.post("http://localhost:8080/auth/signin", data, {headers: headers})
                .then(response => {
                    //window.console.log(response);
                    localStorage.setItem('token', response.data.token);
                    axios.defaults.headers.common['Authorization'] = "Bearer " + response.data.token;
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