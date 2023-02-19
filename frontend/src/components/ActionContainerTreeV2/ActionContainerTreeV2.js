import React, {useState} from 'react';
import './ActionContainerTreeV2.css';
import ActionContainerV2 from "../ActionContainerV2/ActionContainerV2";
import { v4 as uuidv4 } from 'uuid';
import {useDispatch, useSelector} from "react-redux";
import {incrementStage} from "../../app/reducers/stageNumber";
import axios from "axios";

export default function ActionContainerTreeV2() {

    const [treeElementList, setTreeElementList] = useState([]);
    const [shouldRender, setShouldRender] = useState(false);
    const stageNumber = useSelector(state => state.stageNumber.value);
    const currentActionId = useSelector(state => state.currentActionId.value);
    const dispatch = useDispatch();


    const setParent = () => {
        let tempTreeElementList = treeElementList.slice();
        let index = tempTreeElementList.length-1;
        let action = currentActionId?.payload;
        if (action?.stage < index)
        if (index >= 0) {
            tempTreeElementList[action?.stage + 1].parent = action;
        }
        setTreeElementList(tempTreeElementList);
    }

    const addActionContainer = () => {
        let actionContainer = {
            id: uuidv4(),
            stage: stageNumber,
            parent: {id: undefined, stage: undefined},
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
    }

    const saveManual = () => {
        let manual = "testManual";
        let description = "testDescription";
        let actions = [];
        let relation = [];
        for (let container of treeElementList) {
            for(let action of container.actionList) {
                let stepId = Number(action.id.substring(9));
                let childId = stepId;
                let step = action.text;
                let actionExecutor = action.stage % 2 == 0 ? "HELPER_BOT" : "CLIENT";
                let parentId = Number(action.parentAction?.id.substring(9));
                actions.push({stepId: stepId, step: step, actionExecutor});
                relation.push({childId: childId, parentId: parentId});
            }
        }
        let data = {manual, description, actions, relation};
        console.log(data);
        let auth = "Bearer " + localStorage.getItem("token");
        axios.defaults.headers.common['Authorization'] = auth;
        axios.post("http://localhost:8080/createManual/saveManual", data)
            .then(response => window.console.log(response))
            .catch(response => window.console.log(response));
    }

    return (
        <div>
            <div className={'action-constructor-tree'}>
                {
                    treeElementList.map((treeElement) => {
                        return (
                            <div className={'action-constructor-tree__item'} key={treeElement.id}>
                                <ActionContainerV2 element={treeElement} signalAdd={notifyActionAdding} signalWrite={notifyActionWriting} signalRender={getSignalFromAction} setParent={setParent}/>
                            </div>
                        )
                    })
                }
            </div>
            <button type="submit" className="btn btn-primary" onClick={() => addActionContainer()} id={'bottom-add-action-container'}>Добавить шаг</button>
            <button type="submit" className="btn btn-primary" onClick={() => showActions()} id={'bottom-add-action-container'}>Показать действия</button>
            <button type="submit" className="btn btn-primary" onClick={() => saveManual()} id={'bottom-add-action-container'}>Сохранить</button>
        </div>
    )

}