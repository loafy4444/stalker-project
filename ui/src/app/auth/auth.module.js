import authLogin from './login.component.js'
import authRegister from './register.component.js'
import authService from './auth.service.js'
import routes from './auth.routes.js'

export default
  angular
    .module('stalker.auth', [])
    .component('authLogin', authLogin)
    .component('authRegister', authRegister)
    .service('authService', authService)
    .config(routes)
    .name
