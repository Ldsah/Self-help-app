import React, {useState} from 'react';
import ActionV2 from "../ActionV2/ActionV2";
import './ActionContainerV2.css';
import {v4 as uuidv4} from "uuid";
import {useDispatch, useSelector} from "react-redux";
import {increment} from "../../app/reducers/globalActionId";

export default function ActionContainerV2(props)  {
    const [actionList, setActionList] = useState(props.element.actionList);
    const currentActionId = useSelector(state => state.currentActionId.value);
    const globalActionId = useSelector(state => state.globalActionId.value);
    const dispatch = useDispatch();


    let addAction = (callback) => {
        let action = {
            id: globalActionId,
            parentAction: currentActionId,
            text: "",
            stage: props.element.stage
        };
        let tempActionList = actionList.slice();
        tempActionList.push(action);
        setActionList(tempActionList);
        dispatch(increment());
        callback(action);
    }

    let al =actionList
        .filter((action) => action.parentAction?.payload == currentActionId?.payload || action.parentAction == undefined /*|| props.element.stage > action.stage*/);

    return (
        <div>
            <div className={'action-container-list'}>
                {
                    actionList
                        .filter((action) => action.parentAction?.payload == currentActionId?.payload || action.parentAction == undefined /*|| props.element.stage > action.stage*/)
                        .map((action) => {
                            return (
                                <div className={'action-container-list__item'} key={action.id}>
                                    <ActionV2 value={action} signalWrite={props.signalWrite} signalRender={props.signalRender}/>
                                </div>
                            )
                        })
                }
            </div>
            <button type="submit" className="btn btn-primary" onClick={() => addAction(props.signalAdd)} id={'bottom-add-action'}>Добавить действие</button>
        </div>
    )
}