import ButtonTxt from "./ButtonTxt";
import {routes} from "../config";
import {useHistory} from "react-router-dom";

const User = ({user}) => {

    const history = useHistory();

    const onClick = () => {
        console.log('click');
    };
    const onEdit = () => {
        history.push(routes.edituser);
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
                <ButtonTxt name={'Edit'} onClick={onEdit}/>
                </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
                <ButtonTxt name={'Delete'} onClick={onClick}/>
                </span>
            </div>
        </>
    );
};

export default User;
