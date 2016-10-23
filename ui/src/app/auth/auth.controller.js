export default class AuthController {
  /* @ngInject */
  constructor ($log, appService, authService) {
    this.$log = $log
    this.appService = appService
    this.authService = authService

    this.$log.debug('AuthCtrl Instantiated.')
  }

  login () {
    this.$log.debug('AuthCtrl Login Function.')
    this.authService.login(this.formData)
  }

	register () {
    this.$log.debug('AuthCtrl Register Function.')
    this.authService.register(this.formData)
  }
}
