import axios from "axios";
import Contract from './Contract';
import {useState, useEffect } from "react";
import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory} from "react-router-dom";

const Contracts = () => {
  const history = useHistory();
  const [contracts, setContracts] = useState([]);

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
      setContracts(response.data);
    })
  }, []);

  return (
      <>
        <div className='company flex flex-row justify-between pr-4 py-2 border-b-2'>
          <span className='tbl-head'>Name</span>
          <span className='tbl-head'>Department</span>
          <span className='tbl-head'>Street</span>
          <span className='tbl-head'>ZIP</span>
          <span className='tbl-head'>City</span>
          <span className='tbl-head'>Country</span>
          <span className='tbl-head'></span>
          <span className='tbl-head'></span>
          <span className='tbl-head'></span>
          <span className='tbl-head'></span>
          <span className='clearfix'></span>
        </div>
        {contracts.map((contract) => (
            <Contract key={contract.id} company={contract} />
        ))}
      </>
  );
};

export default Contracts;
