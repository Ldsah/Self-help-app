import React, {useState} from 'react';
import Action from "../Action/Action";
import './ActionContainer.css';
import {increment} from "../../app/reducers/globalActionId";
import {useDispatch, useSelector} from "react-redux";

export default function ActionContainer(props)  {
    const [executor, setExecutor] = useState("");
    const [actionList, setActionList] = useState([]);
    const [parent, setParent] = useState("");


    const globalActionId = useSelector(state => state.globalActionId.value);
    const dispatch = useDispatch();
    const currentActionId = useSelector(state => state.currentActionId.value);

    let addAction = () => {
        let action = {
            id: globalActionId,
            text: "",
            parent: props.parent
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
                        actionList
                            .filter((action) => action.parent == currentActionId || action.parent == undefined
                        )
                            .map((action) => {
                            return (
                                <div className={'action-container-list__item'} key={action.id}>
                                    <Action value={action} signal={props.signal}/>
                                </div>
                            )
                        })
                    }
                </div>
                <button type="submit" className="btn btn-primary" onClick={() => addAction()} id={'bottom-add-action'}></button>
            </div>
    )
}