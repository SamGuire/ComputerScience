export class Router {
  constructor() {
    this.routerMap = new Map();
  }
  bindPath(url, DOMPageNode) {
    this.routerMap.set(url, DOMPageNode);
  }
  getPage(url) {
    if (this.routerMap.has(url)) {
      return this.routerMap.get(url);
    } else {
      return "<h1>404</h1>";
    }
  }
}
