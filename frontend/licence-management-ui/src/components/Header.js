import { FiPlusSquare, FiUser, FiLogOut } from 'react-icons/fi';
import NavButton from './NavButton';

const Header = ({ title, bgClass }) => {
  const iconSize = 30;
  return (
    <header className={bgClass}>
      <h1>{title}</h1>
      <div className='container flex flex-row p-2'>
        <h2>Customers</h2>
        <NavButton
          name={'Add'}
          linkTo={''}
          icon={<FiPlusSquare size={iconSize} />}
        />
        <input type='text' placeholder='Filter' />
        <NavButton
          name={'Profile'}
          linkTo={''}
          icon={<FiUser size={iconSize} />}
        />
        <NavButton
          name={'Logout'}
          linkTo={''}
          icon={<FiLogOut size={iconSize} />}
        />
      </div>
    </header>
  );
};

export default Header;
