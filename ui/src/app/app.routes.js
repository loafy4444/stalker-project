export default
  function routes ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/home') //  TODO Change to Global by Default?

    $stateProvider
      .state('home', {
        url: '/home',
        template: '<stalker-app></stalker-app>',
        onEnter: function (appService) {
          console.dir('Valid User: ' + appService.validUser)
          console.dir('Current User: ' + appService.curUser)
        }
      })
  }
