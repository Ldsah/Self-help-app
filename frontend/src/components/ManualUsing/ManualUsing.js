import './ManualUsing.css'
import {Link} from "react-router-dom";
import {useSelector} from "react-redux";
import {useEffect, useState} from "react";
import axios from "axios";

function ManualUsing(props) {
    const manualNumber = useSelector(state => state.manualNumber.value);
    const [data, setData] = useState();

    //useEffect(()=>getManual());

    let getManual = () => {
        let auth = "Bearer " + localStorage.getItem("token");
        axios.defaults.headers.common['Authorization'] = auth;
        axios.post("http://localhost:8080/manuals/getManual", {"id": manualNumber.payload + ""})
            .then(response => {
                window.console.log(response);
                setData(response);
            })
            .catch(response => window.console.log(response));
    }

    return (
        <div onClick={getManual}>
            jkllkj
        </div>
    )
}

export default ManualUsing;