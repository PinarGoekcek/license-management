import Company from './Company';

const Companies = ({ companies }) => {
  return (
    <>
      <div className='company flex flex-row justify-between pr-4 py-2 border-b-2'>
        <span className='tbl-head'>Name</span>
        <span className='tbl-head'>Department</span>
        <span className='tbl-head'>Street</span>
        <span className='tbl-head'>ZIP</span>
        <span className='tbl-head'>City</span>
        <span className='tbl-head'>Country</span>
        <span className='clearfix'></span>
      </div>
      {companies.map((company) => (
        <Company key={company.id} company={company} />
      ))}
    </>
  );
};

export default Companies;
