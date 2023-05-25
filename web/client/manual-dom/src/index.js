import { createButton } from "./components/button.js";
import { Router } from "./common/Router.js";
import { HomePage } from "./pages/Home.js";
import { LoginPage } from "./pages/Login.js";

class App {
  constructor() {
    this.router = new Router();
    this.router.bindPath("/", new HomePage());
    this.router.bindPath("/login", new LoginPage());
    window.onpopstate = (evt) => {
      const htmlDomNode = this.router
        .getPage(window.location.pathname)
        .getHTMLNode();
      document.body.replaceChild(htmlDomNode, document.body.firstElementChild);
    };
  }

  render(path) {
    const htmlDomNode = this.router
      .getPage(window.location.pathname)
      .getHTMLNode();
    window.history.pushState({ path }, path, window.location.origin + path);
    document.body.replaceChild(htmlDomNode, document.body.firstElementChild);
  }
}

var app = new App();

var pushState = history.pushState;
history.pushState = function () {
  console.log(this);
  pushState.apply(history, arguments);
  const htmlDomNode = app.router
    .getPage(window.location.pathname)
    .getHTMLNode();
  document.body.replaceChild(htmlDomNode, document.body.firstElementChild);
};
app.render("/");
