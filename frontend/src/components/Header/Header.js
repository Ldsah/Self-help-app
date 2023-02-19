import './Header.css'
import {Link} from "react-router-dom";


function Header() {
    return (
        <header className={'header'}>
            <h1 className={'header_title'}>Самопомощь</h1>
            <div>
                <Link to={'profile'} className={'header_link'}>Профиль</Link>
                <Link to={'manuals'} className={'header_link'}>Методички</Link>
                <Link to={'manulelem'} className={'header_link'}>Конструктор</Link>
                <Link to={'login'} className={'header_link'}>Логин</Link>
            </div>
        </header>
    )
}

export default Header;