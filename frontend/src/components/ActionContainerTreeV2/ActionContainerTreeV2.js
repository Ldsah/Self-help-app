import React, {useState} from 'react';
import './ActionContainerTreeV2.css';
import ActionContainerV2 from "../ActionContainerV2/ActionContainerV2";
import { v4 as uuidv4 } from 'uuid';
import {useDispatch, useSelector} from "react-redux";
import {incrementStage} from "../../app/reducers/stageNumber";

export default function ActionContainerTreeV2() {

    const [treeElementList, setTreeElementList] = useState([]);
    const [shouldRender, setShouldRender] = useState(false);
    const stageNumber = useSelector(state => state.stageNumber.value);
    const currentActionId = useSelector(state => state.currentActionId.value);
    const dispatch = useDispatch();

    const addActionContainer = () => {
        let actionContainer = {
            id: uuidv4(),
            stage: stageNumber,
            actionList: []
        }
        let tempTreeElementList = treeElementList.slice();
        tempTreeElementList.push(actionContainer);
        setTreeElementList(tempTreeElementList);
        dispatch(incrementStage());
    }

    const notifyActionAdding = (newAction) => {
        let tempTreeElementList = treeElementList.slice();
        tempTreeElementList[newAction.stage].actionList.push(newAction);
        setTreeElementList(tempTreeElementList);
    }

    const notifyActionWriting = (actionText, actionId) => {
        let tempTreeElementList = treeElementList.slice();
        for(let container of tempTreeElementList) {
            for (let action of container.actionList) {
                if (action.id == actionId) {
                    action.text = actionText;
                }
            }
        }
    }

    const getSignalFromAction = () => {
        setShouldRender(!shouldRender);
    }

    //for develop
    const showActions = () => {
        console.log(treeElementList);
        console.log(currentActionId);
        console.log(currentActionId.payload == 'actionId-0');
    }

    return (
        <div>
            <div className={'action-constructor-tree'}>
                {
                    treeElementList.map((treeElement) => {
                        return (
                            <div className={'action-constructor-tree__item'} key={treeElement.id}>
                                <ActionContainerV2 element={treeElement} signalAdd={notifyActionAdding} signalWrite={notifyActionWriting} signalRender={getSignalFromAction}/>
                            </div>
                        )
                    })
                }
            </div>
            <button type="submit" className="btn btn-primary" onClick={() => addActionContainer()} id={'bottom-add-action-container'}>Добавить шаг</button>
            <button type="submit" className="btn btn-primary" onClick={() => showActions()} id={'bottom-add-action-container'}>Показать действия</button>
        </div>
    )

}