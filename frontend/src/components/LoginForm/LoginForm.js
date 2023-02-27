import React, {useState} from 'react';
import './LoginForm.css';
import {useDispatch} from "react-redux";
import axios from "axios";
import {Link} from "react-router-dom";
export default function LoginForm() {
    const [userName, setUserName] = useState();
    const [password, setPassword] = useState();

    const dispatch = useDispatch();

    const login = (scope, userName, password) => {
        scope.preventDefault();
        const data = {username: userName, password: password}
        try {
            axios.post("http://localhost:8080/auth/signin", data)
                .then(response => {
                    localStorage.setItem('token', response.data.token);
                    axios.defaults.headers.common['Authorization'] = "Bearer " + response.data.token;
                })
                .catch(response => window.console.log(response));
        } catch (e){
            console.log(e);
        }
    }


    return (
        /*<div className={'action'} >
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
        </div>*/
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3">
                    <div className="card my-5">

                        <form className="card-body cardbody-color p-lg-5">

                            <div className="text-center">
                                <img src="symbol.jpg"
                                     width="300px" alt="" />
                            </div>

                            <div className="mb-3">
                                <input type="text" className="form-control" id="Username" aria-describedby="emailHelp"
                                       placeholder="Логин" value={userName} onChange={e => setUserName(e.target.value)}/>
                            </div>
                            <div className="mb-3">
                                <input type="password" className="form-control" id="password" placeholder="Пароль" value={password}
                                       onChange={e => setPassword(e.target.value)} />
                            </div>
                            <div className="text-center">
                                <button className="btn btn-color px-5 mb-5 w-100" onClick={(scope) => login(scope, userName, password)}>Войти</button>
                            </div>
                            <div id="emailHelp" className="form-text text-center mb-5 text-dark">
                                <Link to={'profile'} className={'header_link'}>Зарегистрироваться</Link>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}