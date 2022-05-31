import axios from "axios";
import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory} from "react-router-dom";

const Login = () => {

    const history = useHistory();

    const onClick = () => {

        const json = JSON.stringify({
            username: 'admin',
            password: 'admin'
        });
        axios.post(`${APP_API_ENDPOINT_URL}/login`, json, {
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
      <h1>Login</h1>
      <input type='text' placeholder='User' />
      <input type='text' placeholder='Password' />
      <button type='button' onClick={onClick}>Login</button>
    </div>
  );
};

export default Login;
