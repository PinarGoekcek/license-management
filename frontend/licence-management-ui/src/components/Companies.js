
const Companies = ({companies}) => {
  return (
      <>
        {companies.map((company) => (
            <h3 key={company.id}>{company.name}</h3>
        ))}
      </>
  )
};

export default Companies;
