import React, {useState} from 'react';
import './Action.css';
import {useDispatch, useSelector} from "react-redux";
import {set} from "../../app/reducers/currentActionId";

export default function Action(props) {
    const [text, setText] = useState(props.value.text);
    //const [id, setId] = useState(props.value.id);

    const currentActionId = useSelector(state => state.currentActionId.value);
    const dispatch = useDispatch();

    let handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;

        setText(value)

    }

    let setCurrentId = () => {
        dispatch(set(props.value.id));
        let el = document.getElementById(props.value.id);
        el.className = '.parent-action';
        props.signal.call();
        //console.log(props.value.id);

    }



    return (
        <div className={'action'} ><input type="text"  value={text} id={props.value.id} onChange={handleInputChange} onDoubleClick={setCurrentId}/></div>
    )
}