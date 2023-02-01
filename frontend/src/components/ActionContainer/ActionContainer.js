import React, {useState} from 'react';
import Action from "../Action/Action";
import './ActionContainer.css';
import globalActionId, {increment} from "../../app/reducers/globalActionId";
import {useDispatch, useSelector} from "react-redux";

export default function ActionContainer()  {
    const [executor, setExecutor] = useState("");
    const [actionList, setActionList] = useState([]);


    const globalActionId = useSelector(state => state.globalActionId.value);
    const dispatch = useDispatch();

    let addAction = () => {
        let id = globalActionId;
        let action = {
            id: id,
            text: ""
        };
        let tempActionList = actionList.slice();
        tempActionList.push(action);
        setActionList(tempActionList);
        dispatch(increment());
    }


    return (
            <div>
                <div className={'action-container-list'}>
                    {
                        actionList.map((action) => {
                            return (
                                <div className={'action-container-list__item'} key={action.id}>
                                    <Action value={action} />
                                </div>
                            )
                        })
                    }
                </div>
                <button type="submit" className="btn btn-primary" onClick={() => addAction()} id={'bottom-add-action'}></button>
            </div>
    )
}