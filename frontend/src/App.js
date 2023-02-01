import './App.css';
import Header from "./components/Header/Header";
import Profile from "./components/Profile/Profile";
import Manuals from "./components/Manuals/Manuals";
import {Outlet, Route, Routes} from "react-router-dom";
import IndexPage from "./components/IndexPage/IndexPage";
import ManualConstructor from "./components/ManualConstructor/ManualConstructor";
import ManualConstructorV2 from "./components/ManualConstructorV2/ManualConstructorV2";
import ActionContainer from "./components/ActionContainer/ActionContainer";
import ActionContainerTree from "./components/ActionContainerTree/ActionContainerTree";

function App() {
  return (
    <Routes>
        <Route path={'/'} element={<Layout/>}>
            <Route index element={<IndexPage/>}/>
            <Route path={'profile'} element={<Profile/>}/>
            <Route path={'manuals'} element={<Manuals/>}/>
            <Route path={'manulelem'} element={<ActionContainerTree/>}/>
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
