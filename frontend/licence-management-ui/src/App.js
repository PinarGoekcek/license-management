
import {Redirect, Route, Switch, useHistory} from 'react-router-dom';
import Header from './components/Header';
import Navbar from './components/Navbar';
import Companies from './components/Companies';
import Login from './components/Login';

import axios from "axios";
import {routes} from "./config";

function App() {
    const history = useHistory();

    axios.interceptors.response.use((response) => {
        return response;
    }, (error) => {
        if (error.response?.status === 415) {
            return Promise.reject(error);
        }
        history.push(routes.login);
        return new Promise(() => {
        });
    });
    axios.defaults.withCredentials = true;

    return (
        <div className='container'>
            <Header title={'Customers'}/>
            <Navbar/>

            <Switch>
                <Route path={routes.companies} exact component={() => <Companies/>}/>
                <Route path={routes.contracts} exact component={() => <Companies/>}/>
                <Route path={routes.users} exact component={() => <Companies/>}/>
                <Route path={routes.login} exact component={() => <Login/>}/>

                <Redirect to={routes.companies}/>
            </Switch>
        </div>
    );
}

export default App;
