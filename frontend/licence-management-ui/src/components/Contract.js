import ButtonTxt from "./ButtonTxt";

const Contract = ({contract}) => {
  const onClick = () => {
    console.log('click');
  };
  return (
    <>
      <div className='contract flex flex-row justify-between pr-4 py-2 border-b-2'>
        <span className='tbl-content'>{contract.company}</span>
        <span className='tbl-content'>{contract.dateStart}</span>
        <span className='tbl-content'>{contract.dateStop}</span>
        <span className='tbl-content'>{contract.version}</span>
        <span className='tbl-content'>Edit</span>
        <span className='tbl-content'>Delete</span>
        <span className='tbl-content'>Details</span>
        <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
        <ButtonTxt name={'Edit'} onClick={onClick}/>
        </span>
        <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Delete'} onClick={onClick}/>
        </span>
        <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Details'} onClick={onClick}/>
        </span>
      </div>
    </>
  );
};

export default Contract;
