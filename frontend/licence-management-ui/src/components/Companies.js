import Company from "./Company";

const Companies = ({companies}) => {
  return (
      <>
          <table>
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
      </>
  )
};

export default Companies;
