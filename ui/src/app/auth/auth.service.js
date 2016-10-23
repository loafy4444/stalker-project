var bcrypt = require('bcryptjs')

export default class AuthService {
  /* @ngInject */
  constructor ($http, $state, $log, $mdToast, apiUrl, appService) {
    this.$http = $http
    this.$state = $state
    this.$log = $log
    this.$mdToast = $mdToast
    this.apiUrl = apiUrl
    this.appService = appService
  }

  register (user) {
    this.$log.debug('AuthSrvc Register Function.')
    var hash = bcrypt.hashSync(user.password, 10)

    this.$http
      .post(`${this.apiUrl}/user`,
        {username: user.username, password: hash, email: user.email})

    this.$state.go('login')
  }

  login (user) {
    this.$log.debug('AuthSrvc Login Function.')
    let curPass = user.password
    this.getValidUser(user.username)
      .then(user => {
        console.log(curPass)
        console.log(user.password)

        if (bcrypt.compareSync(curPass, user.password)) {
          this.$log.debug('Password Authenticated.')
          this.appService.validUser = true
          this.appService.curUser = user
          this.showToast('Login Successful.')
          this.$state.go('home') // TODO Change to Personal Messages Page or Profile Page
        } else {
          this.$log.debug('Password Not Authenticated.')
          this.showToast('Password Invalid for Username Provided. Please Try Again.')
        }
      })
  }

  getValidUser (name) {
    this.$log.debug('AuthSrvc Retrieving Customer Info for Validation.')
    return this.$http
      .get(`${this.apiUrl}/user/name`, { params: { name } })
      .then(user => user.data)
      .catch(this.showToast('Username Not Found.  Please Try Again.'))
  }

  showToast (message) {
    this.$mdToast.show(
    this.$mdToast.simple()
      .textContent(message)
      .position('bottom left')
      .hideDelay(3000)
    )
  }
}
