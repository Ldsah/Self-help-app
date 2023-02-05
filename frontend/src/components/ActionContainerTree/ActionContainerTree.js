import React, {useState} from 'react';
import './ActionContainerTree.css';
import ActionContainer from "../ActionContainer/ActionContainer";
import { v4 as uuidv4 } from 'uuid';
import {useSelector} from "react-redux";

export default function ActionContainerTree(props) {

    const [treeElementList, setTreeElementList] = useState([]);
    const currentActionId = useSelector(state => state.currentActionId.value);
    const [shouldRender, setShouldRender] = useState(false);

    const addActionContainer = () => {
        let actionContainer = {
            id: uuidv4(),
            parent:currentActionId,
            executor: "",
            actionList: []
        }
        let tempTreeElementList = treeElementList.slice();
        tempTreeElementList.push(actionContainer);
        setTreeElementList(tempTreeElementList);
    }

    const getSignalFromAction = () => {
        setShouldRender(!shouldRender);
    }


    return (
            <div>
                <div className={'action-constructor-tree'}>
                    {
                        treeElementList.map((treeElement) => {
                            return (
                                <div className={'action-constructor-tree__item'} key={treeElement.id}>
                                    <ActionContainer element={treeElement} signal={getSignalFromAction} />
                                </div>
                            )
                        })
                    }
                </div>
                <button type="submit" className="btn btn-primary" onClick={() => addActionContainer()} id={'bottom-add-action-container'}></button>
            </div>
        )

}