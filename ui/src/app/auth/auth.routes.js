export default
  function routes ($stateProvider) {
    $stateProvider
    .state('login', {
      url: '/login',
      template: '<auth-login></auth-login>',
      title: 'Login'
    })
    .state('register', {
      url: '/register',
      template: '<auth-register></auth-register>',
      title: 'Register'
    })
  }
