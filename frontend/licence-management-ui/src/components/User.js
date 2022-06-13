import ButtonTxt from "./ButtonTxt";

const User = ({user}) => {
    const onClick = () => {
        console.log('click');
    };
    return (
        <>
            <div className='user flex justify-items-start py-2 border-b-2'>
                <span className='tbl-row tbl-content'>{user.company.name}</span>
                <span className='tbl-row tbl-content'>{user.username}</span>
                <span className='tbl-row tbl-content'>{user.firstName}</span>
                <span className='tbl-row tbl-content'>{user.lastName}</span>
                <span className='tbl-row tbl-content'>{user.email}</span>
                <span className='tbl-row tbl-content'>{user.phone}</span>
                <span className='tbl-row tbl-content'>{user.mobile}</span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
                <ButtonTxt name={'Edit'} onClick={onClick}/>
                </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
                <ButtonTxt name={'Delete'} onClick={onClick}/>
                </span>
            </div>
        </>
    );
};

export default User;
