import React from 'react';
import ManualElement from "../ManualElement/ManualElement";
import './ManualConstructor.css';

export default class ManualConstructor extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            counter: 1,
            manualElementList: []
        };

    }

    componentDidMount() {
        let defaultElement = {
            id: 0,
            question: "",
            answers: []
        }
        this.setState({manualElementList: [defaultElement]});
    }

    addElement = (element) => {
        let tempList = this.state.manualElementList.slice();
        element.id = this.state.counter;
        tempList.push(element);
        this.setState({manualElementList: tempList});
        this.setState({counter: this.state.counter + 1});
    }

    render() {

        return (
            <div className={'manual-element-list'}>
                {
                    this.state.manualElementList.map((manualElement) => {
                        return (
                            <div className={'manual-element-list__item'} key={manualElement.id}>
                                <ManualElement element={manualElement} addEl={this.addElement}/>
                            </div>
                        )
                    })
                }
            </div>
        )
    }
}