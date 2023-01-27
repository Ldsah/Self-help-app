import './ManualElement.css'
import React from "react";

export default class ManualElement extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            counter: 0,
            question: '',
            answers: []
        };

    }

    handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let number = Number(name.substring(6));
        let firstPart = name.substring(0,6);

        if ('answer' != firstPart) {
            this.setState({
                [name]: value
            });
        }
        else {
            let localAnswers = this.state.answers.slice();
            localAnswers[number] = value;
            this.setState({['answers']: localAnswers});
        }
    }

    renderAnswers = () => {
        let answersRows = [];
        for (let i=0; i<this.state.counter; i++) {
            let answerName = 'answer' + i;
            let prps = this.props;
            let ansText = this.props.element?.answers[i];
            answersRows.push(<div className={'answer'}><input type="text"  value={this.state.answers[i]} name={answerName} onChange={this.handleInputChange}/>{ansText}</div>);
        }
        return answersRows;
    }

    addAnswer = () => {
        this.setState({counter: this.state.counter + 1});
        let localAnswers = this.state.answers.slice();
        localAnswers.push("");
        this.setState({['answers']: localAnswers});
        let st = this.state;
    }

    createElement = () => {
        let resultObj = {
            id: this.props.id,
            question: this.state.question,
            answers: this.state.answers.slice()
        };
        return resultObj;
    }

    render() {
        return (
        <div className={'manual-element'}>
            <div className={'question'}>
                <input type="text" className="question"  value={this.state.question} name={'question'}
                       onChange={this.handleInputChange}/>
            </div>
            <div>
                {this.renderAnswers()}
                <button type="submit" className="btn btn-primary" onClick={this.addAnswer} id={'bottom-1'}>Добавить ответ</button>
            </div>
            <div>
                <button type="submit" className="btn btn-primary" onClick={() => this.props.addEl(this.createElement())} id={'bottom-2'}></button>
            </div>
        </div>
    )}
}

