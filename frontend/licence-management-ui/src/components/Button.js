import PropTypes from 'prop-types';

const Button = ({ name, linkTo, icon, onClick }) => {
  return <button onClick={onClick}>{icon}</button>;
};

Button.propTypes = {
  name: PropTypes.string,
  linkTo: PropTypes.string,
  icon: PropTypes.element,
  onClick: PropTypes.func,
};

export default Button;
