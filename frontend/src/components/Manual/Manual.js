import './Manual.css'
import {Link} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {setManualNumber} from "../../app/reducers/manualNumber";

function Manual(props) {
    const dispatch = useDispatch();

    let openForUse = () => {
        dispatch(setManualNumber(props.action.id));
    }

    return (
        <div>
            <div>{props.action.name}</div>
            <Link to={'manualUsing'} className={'header_link'} onClick={openForUse}>Открыть</Link>
        </div>
    )
}

export default Manual;