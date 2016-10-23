import navbarComponent from './navbar.component.js'
import navbarService from './navbar.service.js'

export default
  angular
    .module('stalker.navbar', [])
    .component('navbar', navbarComponent)
    .service('navbarService', navbarService)
    .name
