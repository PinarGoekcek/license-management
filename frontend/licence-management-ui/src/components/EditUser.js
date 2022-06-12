
const EditUser = ({}) => {




    return (
        <>
            <div className="m-8">
                <h3 className="">Company</h3>
                <input className="block border text-sm text-slate-500
    " type='text' placeholder=''/>
            </div>

            <div className="grid grid-cols-2 p-10">

                <div className="m-8">
                    <h3 className="">First Name</h3>
            <input className="block border text-sm text-slate-500
    " type='text' placeholder=''/>
                </div>

                <div className="m-8">
                    <h3 className="">Last Name</h3>
            <input className="block border text-sm text-slate-500
    " type='text' placeholder=''/>
                </div>

                <div className="m-8">
                    <h3 className="">Email</h3>
            <input className="block border text-sm text-slate-500
    " type='text' placeholder=''/>
                </div>

                <div className="m-8">
                    <h3 className="">Phone</h3>
                    <input className="block border text-sm text-slate-500
    " type='text' placeholder=''/>
                </div>


<div>
    <h3 className="mt-6">Is Administrator</h3>
                <input type="checkbox" className="default:ring-2"/>
                </div>

                <div className="m-8">
                    <h3 className="">Mobile</h3>
                    <input className="block border text-sm text-slate-500
    " type='text' placeholder=''/>
                </div>
            </div>

            <div className="absolute right-0">
            <button type='button'  className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
    Save
            </button>

            <button type='button'  className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
              Cancel
            </button></div>



        </>
    );
};

export default EditUser;