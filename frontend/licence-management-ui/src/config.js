export const protectedRoutes = {
    'companies': '/companies',
    'contracts': '/contracts',
    'addcontract': '/addcontract',
    'editcontracts': '/editcontracts',
    'users': '/users',
    'edituser': '/edituser',
    'adduser': '/adduser',
    'usersbycompany': '/usersbycompany',
    'details': '/details',
    'addcompany': '/addcompany',
    'editCompanies': '/editCompanies'
}


export const routes = {
    ...protectedRoutes,
    'login': '/login',
    'logout': '/logout'
}


export const APP_API_ENDPOINT_URL = process.env.REACT_APP_API_ENDPOINT_URL || 'http://localhost:8080';