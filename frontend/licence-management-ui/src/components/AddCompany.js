import ButtonTxt from "./ButtonTxt";
import {routes} from "../config";
import {useHistory} from "react-router-dom";

const AddCompany = (props) => {
    props.func('Add Company');
    props.showAdd(false);

    const history = useHistory();


    const onSave = () => {
        console.log('save');
    }

    const onCancel = () => {
        history.push(routes.companies)
    }

    return (
        <>
            <div className="grid grid-cols-2 p-10 m-auto text-enter ">
                <div className="m-3">
                    <h3 className="text-center">Name</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/>
                </div>
                <div className="m-3">
                    <h3 className="text-center">department</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">street</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">zip_code</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">City</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
                    <h3 className="text-center">Country</h3>
                    <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
            </div>

            <div className="absolute right-20">
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

export default AddCompany;