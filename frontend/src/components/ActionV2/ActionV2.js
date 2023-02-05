import React, {useState} from 'react';
import './ActionV2.css';
import {useDispatch} from "react-redux";
import {set} from "../../app/reducers/currentActionId";

export default function ActionV2(props) {
    const [text, setText] = useState(props.value.text);
    const dispatch = useDispatch();

    const handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        setText(value);
        props.signalWrite(value, props.value.id);
    }

    const chooseParent = () => {
        dispatch(set(props.value.id));
        props.signalRender();
    }



    return (
        <div className={'action'} ><input type="text"  value={text} id={props.value.id} onChange={handleInputChange} onDoubleClick={chooseParent}/></div>
    )
}