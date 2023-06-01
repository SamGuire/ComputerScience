angular.module("home.module", []).component("homeComponent", {
  controller: [
    "$scope",
    "$q",
    function HomeController($scope, $q) {
      $scope.clickedMe = function () {
        $q(function () {
          return new Promise((resolve, reject) => {
            setTimeout(() => {
              console.log("TIMEOUT DONE");
              resolve();
            }, 3000);
          });
        });
      };
    },
  ],
  templateUrl: "pages/home/home.template.html",
});
