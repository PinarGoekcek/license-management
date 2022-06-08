import {Redirect, Route, Switch, useHistory} from 'react-router-dom';
import Header from './components/Header';
import Navbar from './components/Navbar';
import Companies from './components/Companies';
import Contracts from "./components/Contracts";
import Users from "./components/Users";
import Login from './components/Login';


import axios from "axios";
import {routes} from "./config";
import Bottombar from "./components/Bottombar";
import {useState} from "react";

function App() {
    const history = useHistory();
    const [headTitle, setHeadTitle] = useState([]);

    axios.interceptors.response.use(
        (response) => {
            return response;
        },
        (error) => {
            if (error.response?.status === 415) {
                return Promise.reject(error);
            }
            history.push(routes.login);
            return new Promise(() => {
            });
        }
    );
    axios.defaults.withCredentials = true;

    const getHeadTitle = (text) => {
        setHeadTitle(text);
    }

    return (
        <div className='my-container'>
            <Header title={headTitle}/>
            <Navbar/>

            <Switch>
                <Route path={routes.companies} exact component={() => <Companies func={getHeadTitle}/>}/>
                <Route path={routes.contracts} exact component={() => <Contracts func={getHeadTitle}/>}/>
                <Route path={routes.users} exact component={() => <Users func={getHeadTitle}/>}/>
                <Route path={routes.login} exact component={() => <Login func={getHeadTitle}/>}/>

                <Redirect to={routes.companies}/>
            </Switch>
            <Bottombar/>
        </div>

    );
}

export default App;
