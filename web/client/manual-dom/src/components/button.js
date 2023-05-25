export function createButton(btnName, className, onClickEvent) {
  const button = document.createElement("input");
  button.setAttribute("type", "button");
  button.setAttribute("value", btnName);
  button.setAttribute("class", className);
  button.addEventListener("click", onClickEvent);
  return button;
}
