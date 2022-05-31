const Navbar = () => {
  return (
    <nav className='navbar bg-gray-300'>
      <div className='container'>
        <ul className='nav'>
          <li>
            <a href='#'>Customers</a>
          </li>
          <li>
            <a href='#'>Contracts</a>
          </li>
          <li>
            <a href='#'>Users</a>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;