function AppConfig($routeProvider) {
  $routeProvider
    .when("/home", {
      template: "<home-component></home-component>",
    })
    .when("/data", {
      template: "<userdata-component></userdata-component>",
    })
    .otherwise("/home");
}

angular
  .module("myAngularApp", ["ngRoute", "home.module", "data.module"])
  .config(AppConfig);
