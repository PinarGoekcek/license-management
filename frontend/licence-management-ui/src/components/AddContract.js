import axios from "axios";
import {useState, useEffect} from 'react';
import {APP_API_ENDPOINT_URL, routes} from "../config";
import {useHistory} from "react-router-dom";

const AddContract = (props) => {
    props.func('Add Contract');

    const history = useHistory();

    const handleError = () => {
        console.log("something went wrong");
    }

    const [dateStart, setDateStart] = useState('');
    const [dateStop, setDateStop] = useState('');
    const [version, setVersion] = useState('');
    const [licenseKey, setLicenseKey] = useState('');
    const [responsible, setResponsible] = useState(0);

    const [listIndex, setListIndex] = useState(0);
    const [companies, setCompanies] = useState([]);

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

    const onSave = () => {
        let user = JSON.parse(localStorage.getItem('user'));
        if (user === null) {
            history.push(routes.login);
            return;
        }
        let jwt = user.jwt || '';

        console.log(listIndex);
        console.log(companies[listIndex]);

        const newcontract = {
            id: null,
            dateStart: dateStart,
            dateStop: dateStop,
            version: version,
            licenseKey: licenseKey,
            company: companies[listIndex]
        };

        console.log(newcontract);

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
                    <h3 className="text-center">Date Start</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' onChange={e => setDateStart(e.target.value)}/>
                </div>
                <div className="m-3">
                    <h3 className="text-center">Date End</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' onChange={e => setDateStop(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Version</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder='' onChange={e => setVersion(e.target.value)}/></div>
                <div className="m-3">
                    <h3 className="text-center">Company</h3>
                    <select onChange={e => setListIndex(e.target.value)}>
                        {companies.map((companyitem, i) => <option
                            value={i} key={companyitem.id}>{companyitem.name}</option>)}
                    </select>
                </div>
                <div className="m-3">
                    <h3 className="text-center">IP number 1</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature A</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 2</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature B</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">IP number 3</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">Feature C</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">License key</h3>
                    <input className="block border m-auto left-30 w-full text-sm text-slate-500
    " type='text' placeholder='' onChange={e => setLicenseKey(e.target.value)}/></div>
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