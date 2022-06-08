const Contract = ({ contract }) => {
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
      </div>
    </>
  );
};

export default Contract;
