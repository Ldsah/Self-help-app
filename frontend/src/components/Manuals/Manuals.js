import './Manuals.css'
import axios from "axios";
import React, {useEffect, useState} from "react";
import Manual from "../Manual/Manual";

export default function Manuals() {

    const [manualsList, setManualsList] = useState([]);

    useEffect(()=>getAllManuals(), [])

    let getAllManuals = () => {
        let auth = "Bearer " + localStorage.getItem("token");
        const headers = {"Content-Type": "application/json","Accept" : 'application/json', 'Authorization' : auth};
        axios.get("http://localhost:8080/manuals/all")
            .then(
                response => {
                    window.console.log(response);
                    setManualsList(response.data)
                })
            .catch(
                response => {
                    window.console.log(response);
                });
    }

    return (
        <div>
            {manualsList
                .map(
                    function(action) {
                        return (<div><Manual action={action}/></div>)
                    }
                )
            }
        </div>
    )
}