export const protectedRoutes = {
    'companies': '/companies',
    'contracts': '/contracts',
    'users': '/users',
    'edituser': '/edituser'
}


export const routes = {
    ...protectedRoutes,
    'login': '/login',
    'logout': '/logout'
}


export const APP_API_ENDPOINT_URL = process.env.REACT_APP_API_ENDPOINT_URL || 'http://localhost:8080';