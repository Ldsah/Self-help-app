import './ManualElementV2.css'
import React from "react";

export default class ManualElementV2 extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            executor: "",
            list: []
        }
    }

    createAnswer = () => {
        let localActions = this.state.list.slice();
        localActions.push("");
        this.setState({['list']: localActions});
    }

    handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;

    }

    renderActions = () => {
        let actionsRows = [];
        for (let action of this.state.list) {
            actionsRows.push(<div className={'action'}><input type="text"  value={this.state.action.text} name={action.id} onChange={this.handleInputChange}/>{action.text}</div>);
        }
        return actionsRows;
    }


    render() {
        return (
            <div className={'manual-element'}>
                <div>
                    {this.renderActions()}
                    <button type="submit" className="btn btn-primary" onClick={() => this.createAnswer()} ></button>
                </div>
            </div>
        )}
}