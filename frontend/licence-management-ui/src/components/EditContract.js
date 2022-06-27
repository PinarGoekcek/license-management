import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory, useParams} from "react-router-dom";
import ButtonTxt from "./ButtonTxt";
import {useState} from "react";
import axios from "axios";
import {useEffect} from "react";

const EditContract = (props) => {
    props.func('Edit Contracts');
    props.showAdd(false);

    const {id} = useParams();
    const history = useHistory();

    const [dateStart, setDateStart] = useState(new Date());
    const [dateStop, setDateStop] = useState(new Date());
    const [version, setVersion] = useState('');
    const [licenseKey, setLicenseKey] = useState('');
    const [ip1, setIp1] = useState('');
    const [ip2, setIp2] = useState('');
    const [ip3, setIp3] = useState('');
    const [feature1, setFeature1] = useState();
    const [feature2, setFeature2] = useState();
    const [feature3, setFeature3] = useState();

    const [companyListIndex, setCompanyListIndex] = useState(-1);
    const [companies] = useState([]);

    const [users, setUsers] = useState([]);
    const [userListIndex1, setUserListIndex1] = useState(-1);
    const [userListIndex2, setUserListIndex2] = useState(-1);

    useEffect(() => {
        let actualuser = JSON.parse(localStorage.getItem('user'));
        if (actualuser === null) {
            history.push(routes.login);
            return;
        }
        let jwt = actualuser.jwt || '';
        axios.get(`${APP_API_ENDPOINT_URL}/contracts`, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json',
                Authorization: `Bearer ${jwt}`,
            },
        })
            .then((response) => {
                setUsers(response.data);
            });
        axios.get(`${APP_API_ENDPOINT_URL}/contracts/${id}`, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json',
                Authorization: `Bearer ${jwt}`,
            },
        })
            .then((response) => {
                setUsers(response.data);
            });
    }, []);


    const onSave = () => {
        let user = JSON.parse(localStorage.getItem('user'));
        if (user === null) {
            history.push(routes.login);
            return;
        }
        let jwt = user.jwt || '';

        const updatedContract = {
            id: null,
            dateStart: dateStart,
            dateStop: dateStop,
            version: version,
            licenseKey: licenseKey,
            company: companies[companyListIndex],
            ipaddress1: ip1,
            ipaddress2: ip2,
            ipaddress3: ip3,
            feature1: Number(feature1),
            feature2: Number(feature2),
            feature3: Number(feature3),
            user1: users[userListIndex1],
            user2: users[userListIndex2]
        };
        if (userListIndex1 < 0) {
            updatedContract.user1 = null;
        }

        if (userListIndex2 < 0) {
            updatedContract.user2 = null;
        }

        axios.put(`${APP_API_ENDPOINT_URL}/companies/${companies[companyListIndex].id}`, updatedContract, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json',
                Authorization: `Bearer ${jwt}`,
            },
        })
            .then((response) => {
                if (response.status === 200) {
                    history.push(routes.contracts);}
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
                    <select onChange={e => setCompanyListIndex(e.target.value)}>
                        <option value={null}></option>
                        {companies && companies.map((item, i) => <option
                            value={i} key={item.id}>{item.name}</option>)}
                    </select>
                </div>

                <div className="m-3">
                    <h3 className="text-center">Responsible person 1</h3>
                    <select onChange={e => setUserListIndex1(e.target.value)}>
                        <option value={null}></option>
                        {users && users.length && users.map((p1item, i) => <option
                            value={i} key={p1item.id}>{p1item.username}</option>)}
                    </select>
                </div>
                <div className="m-3">
                    <h3 className="text-center">Responsible person 2</h3>
                    <select onChange={e => setUserListIndex2(e.target.value)}>
                        <option value={null}></option>
                        {users && users.length && users.map((p2item, i) => <option
                            value={i} key={p2item.id}>{p2item.username}</option>)}
                    </select>
                </div>

                <div className="m-3">
                    <h3 className="text-center">Date Start</h3>
                    <input className="block border m-auto text-sm text-slate-500"
                           type='date' value={dateStart.toISOString().split('T')[0]}
                           onChange={e => setDateStart(new Date(e.target.value))}/>
                </div>
                <div className="m-3">
                    <h3 className="text-center">Date End</h3>
                    <input className="block border m-auto text-sm text-slate-500"
                           type='date' value={dateStop.toISOString().split('T')[0]}
                           onChange={e => setDateStop(new Date(e.target.value))}/></div>
                <div className="m-3">
                    <h3 className="text-center">Version</h3>
                    <input className="block border m-auto text-sm text-slate-500"
                           type='text' placeholder='' value={version} onChange={e => setVersion(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 1</h3>
                    <input className="block border m-auto text-sm text-slate-500" type='text' placeholder='' value={ip1}
                           onChange={e => setIp1(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature A</h3>
                    <input className="block border m-auto text-sm text-slate-500" type='text' placeholder=''
                           value={feature1} onChange={e => setFeature1(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 2</h3>
                    <input className="block border m-auto text-sm text-slate-500" type='text' placeholder='' value={ip2}
                           onChange={e => setIp2(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature B</h3>
                    <input className="block border m-auto text-sm text-slate-500" type='text' placeholder=''
                           value={feature2} onChange={e => setFeature2(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 3</h3>
                    <input className="block border m-auto text-sm text-slate-500" type='text' placeholder='' value={ip3}
                           onChange={e => setIp3(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature C</h3>
                    <input className="block border m-auto text-sm text-slate-500" type='text' placeholder=''
                           value={feature3} onChange={e => setFeature3(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">License key</h3>
                    <input className="block border m-auto left-30 w-full text-sm text-slate-500" type='text'
                           placeholder='' value={licenseKey} onChange={e => setLicenseKey(e.target.value)}/></div>
            </div>


            <div className="absolute right-0">
               <span
                   className='bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800'>
                <ButtonTxt name={'save'} onClick={onSave}/>
                           </span>

                <span
                    className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                <ButtonTxt name={'Cancel'} onClick={onCancel}/>
                    </span>

            </div>


        </>
    );
};

export default EditContract;