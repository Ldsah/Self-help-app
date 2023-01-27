import './Answer.css'
import React from "react";

function Answer() {
    return (
        <div className={'answer'}><input type="text" className="form-control"  value={this.state.answers[this.state.counter]} name={answerName} onChange={this.handleInputChange}/></div>
    )
}

export default Answer;