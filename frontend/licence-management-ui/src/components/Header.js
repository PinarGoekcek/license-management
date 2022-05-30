import { FiPlusSquare, FiUser, FiLogOut } from 'react-icons/fi';
import NavButton from './NavButton';

const Header = ({ title, bgClass }) => {
  const iconSize = 30;
  return (
    <header className={bgClass}>
      <h1>{title}</h1>
      <div className='container flex flex-row p-2'>
        <h2>Customers</h2>
        <span className='onHoverChangeCol'>
          <NavButton
            name={'Add'}
            linkTo={''}
            icon={<FiPlusSquare size={iconSize} />}
          />
        </span>
        <input type='text' placeholder='Filter' />
        <span className='onHoverChangeCol'>
          <NavButton
            name={'Profile'}
            linkTo={''}
            icon={<FiUser size={iconSize} />}
          />
        </span>
        <span className='onHoverChangeCol'>
          <NavButton
            name={'Logout'}
            linkTo={''}
            icon={<FiLogOut size={iconSize} />}
          />
        </span>
      </div>
    </header>
  );
};

export default Header;
