import axios from "axios";
import {useState, useEffect, useRef} from 'react';
import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory} from "react-router-dom";

const AddContract = (props) => {
    props.func('Add Contract');
    props.showAdd(false);

    const history = useHistory();
    const companySelector = useRef();

    const handleError = () => {
        console.log("something went wrong");
    }

    const [dateStart, setDateStart] = useState('');
    const [dateStop, setDateStop] = useState('');
    const [version, setVersion] = useState('');
    const [licenseKey, setLicenseKey] = useState('');
    const [ip1, setIp1] = useState('');
    const [ip2, setIp2] = useState('');
    const [ip3, setIp3] = useState('');
    const [feature1, setFeature1] = useState('');
    const [feature2, setFeature2] = useState('');
    const [feature3, setFeature3] = useState('');

    const [companies, setCompanies] = useState([]);
    const [companyID, setCompanyID] = useState(null);
    const [company, setCompany] = useState([]);

    const [users, setUsers] = useState([]);

    const [user1, setUser1] = useState([]);
    const [userId1, setUserId1] = useState(null);
    const [user2, setUser2] = useState([]);
    const [userId2, setUserId2] = useState(null);

    useEffect(() => {
        let user = JSON.parse(localStorage.getItem('user'));
        if (user === null) {
            history.push(routes.login);
            return;
        }
        let jwt = user.jwt || '';
        axios.get(`${APP_API_ENDPOINT_URL}/companies`, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json',
                Authorization: `Bearer ${jwt}`,
            },
        })
            .then((response) => {
                setCompanies(response.data);
            });
    }, []);

    useEffect(() => {
        if (companyID !== null) {
            console.log(companyID);
            let user = JSON.parse(localStorage.getItem('user'));
            if (user === null) {
                history.push(routes.login);
                return;
            }
            let jwt = user.jwt || '';
            axios.get(`${APP_API_ENDPOINT_URL}/companies/${companyID}/users`, {
                headers: {
                    'Content-Type': 'application/json',
                    Accept: 'application/json',
                    Authorization: `Bearer ${jwt}`,
                },
            })
                .then((response) => {
                    setUsers(response.data);
                });
        }
    }, [companyID]);

    useEffect(() => {
        console.log(users)
    }, [users]);

    useEffect(() => {
        if (userId1 !== null) {
            let actualuser = JSON.parse(localStorage.getItem('user'));
            if (actualuser === null) {
                history.push(routes.login);
                return;
            }
            let jwt = actualuser.jwt || '';
            axios.get(`${APP_API_ENDPOINT_URL}/users/${userId1}`, {
                headers: {
                    'Content-Type': 'application/json',
                    Accept: 'application/json',
                    Authorization: `Bearer ${jwt}`,
                },
            })
                .then((response) => {
                    setUser1(response.data);
                })
            console.log(user1)
        }
    }, [userId1]);

    useEffect(() => {
        if (userId2 !== null) {
            let actualuser = JSON.parse(localStorage.getItem('user'));
            if (actualuser === null) {
                history.push(routes.login);
                return;
            }
            let jwt = actualuser.jwt || '';
            axios.get(`${APP_API_ENDPOINT_URL}/users/${userId2}`, {
                headers: {
                    'Content-Type': 'application/json',
                    Accept: 'application/json',
                    Authorization: `Bearer ${jwt}`,
                },
            })
                .then((response) => {
                    setUser2(response.data);
                })
            console.log(user2)
        }
    }, [userId2]);


    const onSave = () => {
        let user = JSON.parse(localStorage.getItem('user'));
        if (user === null) {
            history.push(routes.login);
            return;
        }
        let jwt = user.jwt || '';

        const newcontract = {
            id: null,
            dateStart: dateStart,
            dateStop: dateStop,
            version: version,
            licenseKey: licenseKey,
            company: companies[companyID],
            ip1: ip1,
            ip2: ip2,
            ip3: ip3,
            feature1: feature1,
            feature2: feature2,
            feature3: feature3
        };

        // console.log(newcontract);

        axios.post(`${APP_API_ENDPOINT_URL}/contracts`, newcontract, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json',
                Authorization: `Bearer ${jwt}`,
            }
        }).then((response) => {
            if (response.status === 200) {
                history.push(routes.contracts)
            } else handleError();

        });

    }

    const onCancel = () => {
        history.push(routes.contracts)
    }

    return (
        <>
            <div className="grid grid-cols-2 p-10 m-auto text-enter ">
                <div className="m-3">
                    <h3 className="text-center">Company</h3>
                    <select onChange={e => setCompanyID(e.target.value)}>
                        {companies.map((item, i) => <option
                            value={item.id} key={item.id}>{item.name}</option>)}
                    </select>
                </div>

                <div className="m-3">
                    <h3 className="text-center">Responsible person 1</h3>
                    <select onChange={e => setUserId1(e.target.value)}>
                        {users.length && users.map((p1item, i) => <option
                            value={p1item.id} key={p1item.id}>{p1item.username}</option>)}
                    </select>
                </div>
                <div className="m-3">
                    <h3 className="text-center">Responsible person 2</h3>
                    <select onChange={e => setUserId2(e.target.value)}>
                        {users.length && users.map((p2item, i) => <option
                            value={p2item.id} key={p2item.id}>{p2item.username}</option>)}
                    </select>
                </div>

                <div className="m-3">
                    <h3 className="text-center">Date Start</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={dateStart} onChange={e => setDateStart(e.target.value)}/>
                </div>
                <div className="m-3">
                    <h3 className="text-center">Date End</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={dateStop} onChange={e => setDateStop(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Version</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={version} onChange={e => setVersion(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 1</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={ip1} onChange={e => setIp1(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature A</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={feature1} onChange={e => setFeature1(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 2</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={ip2} onChange={e => setIp2(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature B</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={feature2} onChange={e => setFeature2(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 3</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={ip3} onChange={e => setIp3(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature C</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' value={feature3} onChange={e => setFeature3(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">License key</h3>
                    <input className="block border m-auto left-30 w-full text-sm text-slate-500
    " type='text' placeholder='' value={licenseKey} onChange={e => setLicenseKey(e.target.value)}/></div>
            </div>

            <div className="absolute right-0">
                <button type='button'
                        className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                        onClick={onSave}>
                    Save
                </button>

                <button type='button'
                        className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                        onClick={onCancel}>
                    Cancel
                </button>
            </div>
        </>
    );
};

export default AddContract;