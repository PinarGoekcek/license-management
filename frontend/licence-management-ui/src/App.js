import {Redirect, Route, Switch, useHistory} from 'react-router-dom';
import Header from './components/Header';
import Navbar from './components/Navbar';
import Companies from './components/Companies';
import AddCompany from './components/AddCompany';
import Contracts from "./components/Contracts";
import AddContract from "./components/AddContract";
import Users from "./components/Users";
import Login from './components/Login';


import axios from "axios";
import {routes} from "./config";
import Bottombar from "./components/Bottombar";
import {useState} from "react";
import EditUser from "./components/EditUser";
import Details from "./components/Details";
import AddUser from "./components/AddUser";
import EditCompanies from "./components/EditCompanies";
import EditContracts from "./components/EditContracts";

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

    const onClickAdd = () => {
        switch (headTitle) {
            case 'Companies':
                history.push(routes.addcompany);
                break;
            case 'Users':
                history.push(routes.adduser);
                break;
            case 'Contracts':
                history.push(routes.addcontract);
                break;
        }
    }

    return (
        <div className='my-container'>
            <Header title={headTitle} onClickAdd={onClickAdd}/>
            <Navbar/>
            <Switch>
                <Route path={routes.companies} exact component={() => <Companies func={getHeadTitle}/>}/>
                <Route path={routes.contracts} exact component={() => <Contracts func={getHeadTitle}/>}/>
                <Route path={routes.users} exact component={() => <Users func={getHeadTitle}/>}/>
                <Route path={routes.login} exact component={() => <Login func={getHeadTitle}/>}/>
                <Route path={routes.edituser} exact component={() => <EditUser func={getHeadTitle}/>}/>
                <Route path={routes.adduser} exact component={() => <AddUser func={getHeadTitle}/>}/>
                <Route path={routes.details} exact component={() => <Details func={getHeadTitle}/>}/>
                <Route path={routes.addcompany} exact component={() => <AddCompany func={getHeadTitle}/>}/>
                <Route path={routes.editCompanies} exact component={() => <EditCompanies func={getHeadTitle}/>}/>
                <Route path={routes.editcontracts} exact component={() => <EditContracts func={getHeadTitle}/>}/>

                <Route path={routes.addcontract} exact component={() => <AddContract func={getHeadTitle}/>}/>

                <Redirect to={routes.companies}/>
            </Switch>
            <Bottombar/>
        </div>

    );
}

export default App;
