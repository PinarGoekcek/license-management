import { FiPlusSquare, FiUser, FiLogOut } from 'react-icons/fi';
import Button from './Button';

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
          <Button
            name={'Add'}
            linkTo={''}
            icon={<FiPlusSquare size={iconSize} />}
            onClick={onClick}
          />
        </span>
        <input type='text' placeholder='Filter' />
        <span className='onHoverChangeCol'>
          <Button
            name={'Profile'}
            linkTo={''}
            icon={<FiUser size={iconSize} />}
            onClick={onClick}
          />
        </span>
        <span className='onHoverChangeCol'>
          <Button
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
