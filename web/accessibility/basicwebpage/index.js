function sleep(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(), ms);
  });
}
async function init() {
  await sleep(3000);
  const img = document.createElement("img");
  img.src = "./smile.png";
  document.body.appendChild(img);
}

init();
