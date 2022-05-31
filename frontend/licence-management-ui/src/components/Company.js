import ButtonTxt from './ButtonTxt';

const Company = ({ company }) => {
  const onClick = () => {
    console.log('click');
  };

  return (
    <>
      <div className='company border-b-2'>
        <span className='tbl-row tbl-content'>{company.name}</span>
        <span className='tbl-row tbl-content'>{company.department}</span>
        <span className='tbl-row tbl-content'>{company.street}</span>
        <span className='tbl-row tbl-content'>{company.zip_code}</span>
        <span className='tbl-row tbl-content'>{company.city}</span>
        <span className='tbl-row tbl-content'>{company.country}</span>
        <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Edit'} onClick={onClick} />
        </span>
        <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Delete'} onClick={onClick} />
        </span>
        <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Contracts'} onClick={onClick} />
        </span>
        <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Users'} onClick={onClick} />
        </span>
      </div>
    </>
  );
};

export default Company;
