import { DUMMY_USERS } from "../../mocks/user/user.mock.js";
function UserController() {
  let $ctrl = this;
  $ctrl.users = DUMMY_USERS;
  //this.orderBy = "first_name";
}
angular.module("user.module").component("userComponent", {
  templateUrl: "model/user/user.template.html",
  controller: UserController,
});
