const Company = ({company}) => {
  return <div className='company flex flex-row pr-4 py-2 border-b-2'>
    <table>
      <tbody>
      <tr>
        <th>{company.name}</th>
        <th>{company.department}</th>
        <th>{company.street}</th>
        <th>{company.zip_code}</th>
        <th>{company.city}</th>
        <th>{company.country}</th>
      </tr>
      </tbody>
    </table>

  </div>;
};

export default Company;
