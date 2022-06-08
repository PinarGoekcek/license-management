import axios from "axios";
import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory} from "react-router-dom";
import {useState} from "react";

const Login = () => {
    const history = useHistory();
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const userInput = (e) => {
        setUsername(e.target.value);
    }

    const pwInput = (e) => {
        setPassword(e.target.value);
    }

    const btnLogin = () => {

        const credentials = JSON.stringify({
            username: username,
            password: password
        });

        axios.post(`${APP_API_ENDPOINT_URL}/login`, credentials, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((response) => {
            if (response.status === 200) {
                localStorage.setItem("user", JSON.stringify(response.data))
                history.push(routes.companies)
            }
        });
    }


    return (
        <div>
            <h1 className="bg-slate-700 h-14 flex flex-col">Login</h1>
            <input className="h-14 flex flex-col" type='text' placeholder='User' value={username} onChange={userInput}/>
            <input className="h-14" type='text' placeholder='Password' value={password} onChange={pwInput}/>
            <button type='button' onClick={btnLogin}>Login</button>
        </div>
    );
};

export default Login;
