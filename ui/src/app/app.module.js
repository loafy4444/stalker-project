import 'bcryptjs'

import '../css/style.css'

import navbar from './navbar/navbar.module.js'
import auth from './auth/auth.module.js'
import banner from './banner/banner.module.js'

import apiUrl from './app.url.js'

import appComponent from './app.component.js'
import appService from './app.service.js'
import routes from './app.routes.js'

export default
  angular
    .module('stalker', ['ngAria',
      'ngAnimate', 'ngMaterial',
      'ngMessages', 'ui.router',
      banner, navbar, auth
    ])
    .constant('apiUrl', apiUrl)
    .component('stalkerApp', appComponent)
    .service('appService', appService)
    .config(routes)
    .name
