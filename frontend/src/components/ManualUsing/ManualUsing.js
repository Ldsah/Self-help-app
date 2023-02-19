import './ManualUsing.css'
import {Link} from "react-router-dom";
import {useSelector} from "react-redux";
import {useEffect, useState} from "react";
import axios from "axios";

function ManualUsing(props) {
    const manualNumber = useSelector(state => state.manualNumber.value);
    const [data, setData] = useState();
    const [currentBlock, setCurrentBlock] = useState();

    useEffect(()=>getManual(renderDialog), []);

    let getManual = (callback) => {
        let auth = "Bearer " + localStorage.getItem("token");
        axios.defaults.headers.common['Authorization'] = auth;
        axios.post("http://localhost:8080/manuals/getManual", {"id": manualNumber.payload + ""})
            .then(response => {
                window.console.log(response);
                setData(response);
                callback.call(null);
            })
            .catch(response => window.console.log(response));
    }

    let findChild = (parentIdVal=null) => {
        let relation = data.data.relation;
        let result = relation.filter(item => item.parentId == parentIdVal).map(item => item.childId);
        return result;
    }

    let findElement = (elementId) => {
        let actions = data.data.actions;
        let result = actions.filter(item => item.stepId = elementId);
        return result[0];
    }

    let renderDialog = (start) => {

    }




    return (
        <div >
5
        </div>
    )
}

export default ManualUsing;