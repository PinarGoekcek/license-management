const Details = (props) => {
    props.func('Contract details');



    return (
        <>
            <div className="grid grid-cols-2 p-10 m-auto text-enter ">
                <div className="m-3">
            <h3 className="text-center">Start</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/>
                </div>
                <div className="m-3">
            <h3 className="text-center">End</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">Version</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">Responsible</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">IP number</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">Feature A</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
              <div className="m-3">
            <h3 className="text-center">IP number</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">Feature B</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">IP number</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">Feature C</h3>
            <input className="block border m-auto text-sm text-slate-500
    " type='text' placeholder=''/></div>
                <div className="m-3">
            <h3 className="text-center">License key</h3>
            <input className="block border m-auto left-30 w-full text-sm text-slate-500
    " type='text' placeholder=''/></div>
            </div>



            <div className="absolute left-20">
                <button type='button'
                        className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Update key
                </button>

                <button type='button'
                        className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Mail key
                </button>
                </div>
                <div className="absolute right-20">
                <button type='button'
                        className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Save
                </button>

                <button type='button'
                        className="bg-blue-500 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm p-2.5 text-center inline-flex items-center mr-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    Cancel
                </button>
            </div>



        </>
    );
};

export default Details;
