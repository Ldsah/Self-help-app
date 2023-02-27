import './ManualUsing.css'
import {useSelector} from "react-redux";
import {useEffect, useState} from "react";
import axios from "axios";
import ManualUsingElement from "../ManualUsingElement/ManualUsingElement";

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

    let findChildren = (parentIdVal=null) => {
        let relation = data.payload.data.relation.slice();
        let result = relation.filter(item => item.parentId == parentIdVal).map(item => item.childId);
        return result;
    }

    let findElement = (elementId) => {
        let actions = data.payload.data.actions.slice();
        let result = actions.filter(item => item.stepId = elementId);
        return result[0];
    }

    let renderDialog = (start) => {

    }

    let setElement = (value) => {
        setCurrentBlock(value);
    }

    return (
        <div><ManualUsingElement func={setElement} />
        </div>
    )
}

export default ManualUsing;