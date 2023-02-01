import React, {useState} from 'react';
import './Action.css';

export default function Action(props) {
    const [text, setText] = useState(props.value.text);
    //const [id, setId] = useState(props.value.id);

    let handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        //const id = target.id;

        setText(value)

    }


    return (
        <div className={'action'} ><input type="text"  value={text} id={props.value.id} onChange={handleInputChange}/></div>
    )
}