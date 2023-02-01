import React from 'react';
import './ActionContainerTree.css';
import ActionContainer from "../ActionContainer/ActionContainer";
import { v4 as uuidv4 } from 'uuid';

export default class ActionContainerTree extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            treeElementList: []
        }
    }

    addActionContainer = () => {
        let actionContainer = {
            id: uuidv4(),
            executor: "",
            actionList: []
        }
        let temptreeElementList = this.state.treeElementList.slice();
        temptreeElementList.push(actionContainer);
        this.setState({treeElementList: temptreeElementList});
    }


    render() {

        return (
            <div>
                <div className={'action-constructor-tree'}>
                    {
                        this.state.treeElementList.map((treeElement) => {
                            return (
                                <div className={'action-constructor-tree__item'} key={treeElement.id}>
                                    <ActionContainer element={treeElement}/>
                                </div>
                            )
                        })
                    }
                </div>
                <button type="submit" className="btn btn-primary" onClick={() => this.addActionContainer()} id={'bottom-add-action-container'}></button>
            </div>
        )
    }
}