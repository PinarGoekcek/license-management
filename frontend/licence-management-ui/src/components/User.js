const User = ({user}) => {
    return (
        <>
            <div className='user flex flex-row justify-between pr-4 py-2 border-b-2'>
                <span className='tbl-content'>{user.company}</span>
                <span className='tbl-content'>{user.username}</span>
                <span className='tbl-content'>{user.firstName}</span>
                <span className='tbl-content'>{user.lastName}</span>
                <span className='tbl-content'>{user.email}</span>
                <span className='tbl-content'>{user.phone}</span>
                <span className='tbl-content'>{user.mobile}</span>
                <span className='tbl-content'>Edit</span>
                <span className='tbl-content'>Delete</span>
            </div>
        </>
    );
};

export default User;
