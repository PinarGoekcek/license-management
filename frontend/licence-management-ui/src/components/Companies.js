import axios from "axios";
import Company from './Company';
import {useState, useEffect } from "react";
import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory} from "react-router-dom";

const Companies = () => {
  const history = useHistory();
  const [companies, setCompanies] = useState([]);

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
          setCompanies(response.data);
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
      {companies.map((company) => (
        <Company key={company.id} company={company} />
      ))}
    </>
  );
};

export default Companies;
