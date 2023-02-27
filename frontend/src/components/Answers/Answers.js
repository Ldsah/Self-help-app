import Answer from "../Answer/Answer";

export default function Answers(props) {

    return (
        <div>
            {
                props.answerList.map(answer => <Answer text={answer.text}/>)
            }
        </div>
    );
}