import { useState } from 'react';
import Header from './components/Header';
import Navbar from './components/Navbar';
import Companies from './components/Companies';

function App() {
  const [companies, setCompanies] = useState([
    {
      id: 1,
      name: 'Company 1',
      department: 'Sales',
      street: 'Rosegarden 1',
      zip_code: '17235',
      city: 'Flowertown',
      country: 'Fantasialand',
      active: true,
    },
    {
      id: 2,
      name: 'Company 2',
      department: 'HR',
      street: 'Sample Street 1',
      zip_code: 'ZRX651',
      city: 'Mytown',
      country: 'Anotherland',
      active: true,
    },
    {
      id: 3,
      name: 'Company 3',
      department: 'Development',
      street: 'Test Way 99',
      zip_code: '99997',
      city: 'Sampletown',
      country: 'Notrealland',
      active: true,
    },
  ]);
  return (
    <div className='container'>
      <Header title={'Customers'} />
      <Navbar />
      <Companies companies={companies} />
    </div>
  );
}

export default App;
