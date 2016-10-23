export default class NavBarController {
  /* @ngInject */
  constructor ($log, $state, appService, navbarService) {
    this.$log = $log
    this.$state = $state

    this.appService = appService
    this.navbarService = navbarService

    this.$log.debug('NavbarCtrl instantiated.')
  }
}
