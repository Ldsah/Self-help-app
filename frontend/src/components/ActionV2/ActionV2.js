import React, {useState} from 'react';
import './ActionV2.css';
import {useDispatch, useSelector} from "react-redux";
import {set} from "../../app/reducers/currentActionId";

export default function ActionV2(props) {
    const [text, setText] = useState(props.value.text);
    const dispatch = useDispatch();
    const currentActionId = useSelector(state => state.currentActionId.value);

    const handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        setText(value);
        props.signalWrite(value, props.value.id);
    }

    const chooseParent = () => {
        //props.adParent(currentActionId?.payload);
        let curAId = {id: props.value.id, stage: props.value.stage}
        props.setParent(curAId);
        dispatch(set(curAId));
        props.signalRender();
    }



    return (
        <div className={'action'} ><input type="text"  value={text} id={props.value.id} onChange={handleInputChange} onDoubleClick={chooseParent}/></div>
    )
}