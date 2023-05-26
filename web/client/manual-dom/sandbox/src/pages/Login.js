export class LoginPage {
  constructor() {
    this.domHTML = document.createElement("div");
    this.domHTML.setAttribute("class", ".homeMainDiv");
    this.domHTML.textContent = "Login page";
  }

  getHTMLNode() {
    return this.domHTML;
  }
}
