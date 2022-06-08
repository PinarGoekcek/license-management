import {routes} from "./../config";

const Navbar = () => {
    return (
        <nav className='navbar bg-gray-300'>
            <div className='container'>
                <ul className='nav'>
                    <li>
                        <a href={routes.companies}>Customers</a>
                    </li>
                    <li>
                        <a href={routes.contracts}>Contracts</a>
                    </li>
                    <li>
                        <a href={routes.users}>Users</a>
                    </li>
                </ul>
            </div>
        </nav>
    );
};

export default Navbar;
