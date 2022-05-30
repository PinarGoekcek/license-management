import { FiPlusSquare, FiUser, FiLogOut } from 'react-icons/fi';
import NavButton from './NavButton';

const Header = ({ title, bgClass }) => {
  const iconSize = 30;
  const onClick = () => {
    console.log('click');
  };
  return (
    <header className={bgClass}>
      <h1>License Management</h1>
      <div className='container flex flex-row p-2'>
        <h2>{title}</h2>
        <span className='onHoverChangeCol'>
          <NavButton
            name={'Add'}
            linkTo={''}
            icon={<FiPlusSquare size={iconSize} />}
            onClick={onClick}
          />
        </span>
        <input type='text' placeholder='Filter' />
        <span className='onHoverChangeCol'>
          <NavButton
            name={'Profile'}
            linkTo={''}
            icon={<FiUser size={iconSize} />}
            onClick={onClick}
          />
        </span>
        <span className='onHoverChangeCol'>
          <NavButton
            name={'Logout'}
            linkTo={''}
            icon={<FiLogOut size={iconSize} />}
            onClick={onClick}
          />
        </span>
      </div>
    </header>
  );
};

export default Header;
