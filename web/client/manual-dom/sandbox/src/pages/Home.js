export class HomePage {
  constructor() {
    this.domHTML = document.createElement("div");
    this.domHTML.setAttribute("class", ".homeMainDiv");
    this.domHTML.textContent = "Home page";

    const link = document.createElement("a");
    link.textContent = "Link to login";
    link.addEventListener("click", () => {
      console.log("clicked");
      window.history.pushState(
        { path: "/login" },
        "/login",
        window.location.origin + "/login"
      );
    });
    this.domHTML.appendChild(link);
  }

  getHTMLNode() {
    return this.domHTML;
  }
}
