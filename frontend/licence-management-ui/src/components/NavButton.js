import PropTypes from 'prop-types';

const NavButton = ({ name, linkTo, icon, onClick }) => {
  return <button onClick={onClick}>{icon}</button>;
};

NavButton.propTypes = {
  name: PropTypes.string,
  linkTo: PropTypes.string,
  icon: PropTypes.element,
  onClick: PropTypes.func,
};

export default NavButton;
