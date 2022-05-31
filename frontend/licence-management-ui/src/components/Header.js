import { FiPlusSquare, FiUser, FiLogOut } from 'react-icons/fi';
import Button from './Button';

const Header = ({ title }) => {
  const iconSize = 30;
  const onClick = () => {
    console.log('click');
  };
  return (
    <header className='bg-blue-500'>
      <h1 className='px-2 font-bold text-white mb-4'>License Management</h1>

      <div className='header-container py-2'>
        <div className='group'>
          <span className='item text'>{title}</span>
          <span className='item icon onHoverChangeCol'>
            <Button
              name={'Add'}
              icon={<FiPlusSquare size={iconSize} />}
              onClick={onClick}
            />
          </span>
        </div>

        <div className='clearfix'></div>

        <div className='group'>
          <span className='item'>
            <input type='text' placeholder='Filter' />
          </span>
          <span className='item icon onHoverChangeCol'>
            <Button
              name={'Profile'}
              icon={<FiUser size={iconSize} />}
              onClick={onClick}
            />
          </span>
          <span className='item icon onHoverChangeCol'>
            <Button
              name={'Logout'}
              icon={<FiLogOut size={iconSize} />}
              onClick={onClick}
            />
          </span>
        </div>
      </div>
    </header>
  );
};

export default Header;
