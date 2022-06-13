import ButtonTxt from './ButtonTxt';

const Company = ({company}) => {
    const onDelete = () => {
        console.log('delete');
    };
    const onEdit = () => {
        console.log('edit');
    };
    const onUsers = () => {
        console.log('users');
    };
    const onContracts = () => {
        console.log('contracts');
    };

    return (
        <>
            <div className='company border-b-2'>
                <span className='tbl-row tbl-content'>{company.name}</span>
                <span className='tbl-row tbl-content'>{company.department}</span>
                <span className='tbl-row tbl-content'>{company.street}</span>
                <span className='tbl-row tbl-content'>{company.zipCode}</span>
                <span className='tbl-row tbl-content'>{company.city}</span>
                <span className='tbl-row tbl-content'>{company.country}</span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Edit'} onClick={onEdit}/>
        </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Delete'} onClick={onDelete}/>
        </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Contracts'} onClick={onContracts}/>
        </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Users'} onClick={onUsers}/>
        </span>
            </div>
        </>
    );
};

export default Company;
