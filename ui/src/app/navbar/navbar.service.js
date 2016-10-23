export default class NavBarService {
  /* @ngInject */
  constructor ($state, appService) {
    this.$state = $state
    this.appService = appService
  }
}
