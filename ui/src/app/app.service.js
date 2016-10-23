export default class AppService {
  /* @ngInject */
  constructor ($http, $state, $log, apiUrl) {
    this.$http = $http
    this.$state = $state
    this.$log = $log
    this.apiUrl = apiUrl

    // this.validUser = false
    // this.curUser = {}

    this.validUser = true
    this.curUser = {
      'id': 1,
      'username': 'test',
      'password': '$2a$10$aMO9nUAdddoyyhIR3Yf5Te.LCP/x.rxktP2OsKC8awgjTrpZlkCYG'
    }
  }

  logout () {
    this.validUser = false
    this.curUser = null
    this.$state.go('global', null, { reload: true })
  }
}
