const http = require("http");
const PORT = 3000;
const buffer = [];
const server = http.createServer((req, res) => {
  console.log(req.url);
  req.on("data", (d) => {
    buffer.push(d);
  });
  req.on("end", () => {
    console.log("Done processing data");
    const fullData = buffer.join("");
    const stringData = decodeURI(fullData);
    console.log("String data", stringData);
    res.setHeader("Content-type", "text/plain");
    res.writeHead(200);
    res.end(stringData);
  });
});

server.listen(3000, "localhost", () => {
  console.log("Listenining on port 3000");
});
