import Company from './Company';

const Companies = ({ companies }) => {
  return (
    <div className='company pr-4 py-2 '>
      <table className='table-fixed'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Department</th>
            <th>Street</th>
            <th>ZIP</th>
            <th>City</th>
            <th>Country</th>
          </tr>
        </thead>
      </table>
      {companies.map((company) => (
        <Company key={company.id} company={company} />
      ))}
    </div>
  );
};

export default Companies;
