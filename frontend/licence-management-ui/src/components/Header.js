import { FiPlusSquare, FiUser, FiLogOut } from 'react-icons/fi';
import ButtonIco from './ButtonIco';
import { useHistory } from 'react-router-dom';
import { routes } from '../config';

const Header = ({ title }) => {
  const history = useHistory();

  const iconSize = 30;
  const onClickLogout = () => {
    localStorage.removeItem('user');
    history.push(routes.login);
  };
  const onClick = () => {
    console.log('click');
  };
  return (
    <header className='bg-blue-500'>
      <h1 className='px-2 font-bold text-white mb-4'>License Management</h1>

      <div className='header-container py-2'>
        <div className='group'>
          <span className='hItem hText'>{title}</span>
          <span className='hItem icon onHoverChangeCol'>
            <ButtonIco
              name={'Add'}
              icon={<FiPlusSquare size={iconSize} />}
              onClick={onClick}
            />
          </span>
        </div>

        <div className='clearfix'></div>

        <div className='group'>
          <span className='hItem'>
            <input type='text' placeholder='Filter' />
          </span>
          <span className='hItem icon onHoverChangeCol'>
            <ButtonIco
              name={'Profile'}
              icon={<FiUser size={iconSize} />}
              onClick={onClick}
            />
          </span>
          <span className='hItem icon onHoverChangeCol'>
            <ButtonIco
              name={'Logout'}
              icon={<FiLogOut size={iconSize} />}
              onClick={onClickLogout}
            />
          </span>
        </div>
      </div>
    </header>
  );
};

export default Header;
