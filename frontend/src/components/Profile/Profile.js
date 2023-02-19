import './Profile.css'
import axios from "axios";
import React from "react";
export default class Profile extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            username: "",
            password: "",
            name: "",
            email: "",
            phone: "",
            gender: "",
            age: "",
            role: ""
        };

    }

    handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }


    register = () => {
        const headers = {"Content-Type": "application/json"};
        const data = {username: this.state.username, password: this.state.password, name: this.state.name,
            email: this.state.email, phone: this.state.phone, gender: this.state.gender, age: this.state.age, role: this.state.role};
        axios.post("http://localhost:8080/auth/signup", data)
            .then(response => window.console.log(response))
            .catch(response => window.console.log(response));
    }

    getProfileData = () => {
        let auth = "Bearer " + localStorage.getItem("token");
        const headers = {"Content-Type": "application/json","Accept" : 'application/json',
            'Authorization' : auth/*, "Access-Control-Allow-Origin": "*"*/};
        axios.get("http://localhost:8080/profile/data", headers)
            .then(response => {window.console.log(response); alert(response)})
            .catch(response => {window.console.log(response); alert(response)});
    }

    render() {
        return (
                <div className="questionnaire">
                    <form className="container border-dark bg-transparent">
                        <div className="mb-3">
                            <label className="form-label">Логин</label>
                            <input type="text" className="form-control"  value={this.state.username} name={'username'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label">Пароль</label>
                            <input type="text" className="form-control"  value={this.state.password} name={'password'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <div className="mb-3">
                            <label  className="form-label">Имя</label>
                            <input type="text" className="form-control"
                                   value={this.state.name} name={'name'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <div className="mb-3">
                            <label  className="form-label">Email</label>
                            <input type="text" className="form-control"  value={this.state.email} name={'email'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <div className="mb-3">
                            <label  className="form-label">Телефон</label>
                            <input type="text" className="form-control"  value={this.state.phone} name={'phone'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label">Пол</label>
                            <input type="text" className="form-control"  value={this.state.gender} name={'gender'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <div className="mb-3">
                            <label  className="form-label">Возраст</label>
                            <input type="text" className="form-control" value={this.state.age} name={'age'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <div className="mb-3">
                            <label className="form-label">Роль</label>
                            <input type="text" className="form-control"
                                   value={this.state.role} name={'role'}
                                   onChange={this.handleInputChange}/>
                        </div>
                        <button type="submit" className="btn btn-primary" onClick={this.register}></button>
                </form>
                    <button type="submit" className="btn btn-primary" onClick={this.getProfileData}> получить данные</button>
        </div>
    )}
}

