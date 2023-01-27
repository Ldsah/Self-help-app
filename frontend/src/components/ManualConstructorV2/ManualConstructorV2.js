import React from 'react';
import './ManualConstructorV2.css';
import ManualElementV2 from "../ManualElementV2/ManualElementV2";

export default class ManualConstructorV2 extends React.Component {
    static defaultProps = {
    }

    constructor(props) {
        super(props);
        this.state = {
            globalId: 'id0',
            manualElementList: []
        }
    }

    getGlobalId = () => {
        let currentId = this.state.globalId;
        let numberPartOfId = Number(this.state.globalId.substring(2));
        this.setState({globalId: "id" + (numberPartOfId + 1)});
        return currentId;
    }

    componentDidMount() {
        let defaultElement = {
            executor: "",
            list: []
        }
        this.setState({manualElementList: [defaultElement]});
    }


    render() {

        return (
            <div className={'manual-element-list'}>
                {
                    this.state.manualElementList.map((manualElement) => {
                        return (
                            <div className={'manual-element-list__item'} key={manualElement.id}>
                                <ManualElementV2 element={manualElement} getGlobalId={this.props.getGlobalId}/>
                            </div>
                        )
                    })
                }
            </div>
        )
    }
}