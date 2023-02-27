import './ManualUsingElement.css'
import Answers from "../Answers/Answers";

function ManualUsingElement(props) {
    return (
        <div>
            <div>props.question</div>
            <Answers answerList={props.answerList}/>
        </div>
    )
}

export default ManualUsingElement;