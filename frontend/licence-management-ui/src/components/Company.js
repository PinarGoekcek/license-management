const Company = ({ company }) => {
  return (
    <div className='company pr-4 py-2 border-b-2'>
      <table>
        <tbody>
          <tr>
            <td>{company.name}</td>
            <td>{company.department}</td>
            <td>{company.street}</td>
            <td>{company.zip_code}</td>
            <td>{company.city}</td>
            <td>{company.country}</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default Company;
