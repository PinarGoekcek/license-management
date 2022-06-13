import ButtonTxt from "./ButtonTxt";
import {routes} from "../config";
import {useHistory} from "react-router-dom";

const Contract = ({contract}) => {
    const history = useHistory();

    const onEdit = () => {
        console.log('edit');
    };
    const onDelete = () => {
        console.log('delete');
    };
    const onDetails = () => {
        history.push(routes.details);
    };
    return (
        <>
            <div className='contract flex justify-items-start py-2 border-b-2'>
                <span className='tbl-row tbl-content'>{contract.company.name}</span>
                <span className='tbl-row tbl-content'>{contract.dateStart.toString().substring(0, 10)}</span>
                <span className='tbl-row tbl-content'>{contract.dateStop.toString().substring(0, 10)}</span>
                <span className='tbl-row tbl-content'>{contract.version}</span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
        <ButtonTxt name={'Edit'} onClick={onEdit}/>
        </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Delete'} onClick={onDelete}/>
        </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Details'} onClick={onDetails}/>
        </span>
            </div>
        </>
    );
};

export default Contract;
