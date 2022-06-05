const Contract = ({ contract }) => {
  return (
    <>
      <div className='contract flex flex-row justify-between pr-4 py-2 border-b-2'>
        <span className='tbl-content'>{contract.id_company}</span>
        <span className='tbl-content'>{contract.date_start}</span>
        <span className='tbl-content'>{contract.date_end}</span>
        <span className='tbl-content'>{contract.version}</span>
        <span className='tbl-content'>{contract.license_key}</span>
        <span className='tbl-content'>Edit</span>
        <span className='tbl-content'>Delete</span>
        <span className='tbl-content'>Details</span>
      </div>
    </>
  );
};

export default Contract;
