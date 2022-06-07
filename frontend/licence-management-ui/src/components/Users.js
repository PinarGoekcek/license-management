import axios from "axios";
import User from './User';
import {useState, useEffect } from "react";
import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory} from "react-router-dom";

const Users = () => {
  const history = useHistory();
  const [users, setUsers] = useState([]);

  useEffect(() => {
    let user = JSON.parse(localStorage.getItem("user"))
    if (user === null) {
      history.push(routes.login)
      return
    }
    let  jwt = user.jwt || ""
    axios.get(`${APP_API_ENDPOINT_URL}/companies`, {
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        'Authorization': `Bearer ${jwt}`
      },
    }).then((response) => {
      setUsers(response.data);
    })
  }, []);

  return (
      <>
        <div className='user flex flex-row justify-between pr-4 py-2 border-b-2'>
          <span className='tbl-head'>company_id</span>
          <span className='tbl-head'>Username</span>
          <span className='tbl-head'>Password</span>
          <span className='tbl-head'>Admin</span>
          <span className='tbl-head'>First name</span>
          <span className='tbl-head'>Last name</span>
          <span className='tbl-head'>Email</span>
          <span className='tbl-head'>Phone</span>
          <span className='tbl-head'>Mobile</span>
          <span className='tbl-head'></span>
          <span className='tbl-head'></span>
          <span className='tbl-head'></span>
          <span className='tbl-head'></span>
          <span className='clearfix'></span>
        </div>
        {users.map((user) => (
            <User key={user.id} user={user} />
        ))}
      </>
  );
};

export default Users;