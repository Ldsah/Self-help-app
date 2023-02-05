import './App.css';
import Header from "./components/Header/Header";
import Profile from "./components/Profile/Profile";
import Manuals from "./components/Manuals/Manuals";
import {Outlet, Route, Routes} from "react-router-dom";
import IndexPage from "./components/IndexPage/IndexPage";
import ActionContainerTreeV2 from "./components/ActionContainerTreeV2/ActionContainerTreeV2";

function App() {
  return (
    <Routes>
        <Route path={'/'} element={<Layout/>}>
            <Route index element={<IndexPage/>}/>
            <Route path={'profile'} element={<Profile/>}/>
            <Route path={'manuals'} element={<Manuals/>}/>
            <Route path={'manulelem'} element={<ActionContainerTreeV2/>}/>
        </Route>
    </Routes>
  );
}

function Layout() {
    return (
        <div className="App">
            <Header/>
            <main className={'content'}>
                <Outlet/>
            </main>
        </div>
    )
}

export default App;
