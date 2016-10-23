export default class AppController {
  /* @ngInject */
  constructor ($log, appService) {
    $log.debug('AppCtrl instantiated.')
    this.appService = appService
  }
}
