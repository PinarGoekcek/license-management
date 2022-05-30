const Company = ({ company }) => {
  return (
    <>
      <div className='company flex flex-row justify-between pr-4 py-2 border-b-2'>
        <span className='tbl-content'>{company.name}</span>
        <span className='tbl-content'>{company.department}</span>
        <span className='tbl-content'>{company.street}</span>
        <span className='tbl-content'>{company.zip_code}</span>
        <span className='tbl-content'>{company.city}</span>
        <span className='tbl-content'>{company.country}</span>
      </div>
    </>
  );
};

export default Company;
