const http = require("http");
const DATA = {
  data: "Hello from server",
};
const server = http.createServer((req, res) => {
  switch (req.url) {
    case "/getValue":
      res.setHeader("Content-type", "application/json");
      res.writeHead(200);
      res.end(JSON.stringify(DATA));
      break;
    case "/form":
      const dataChunks = [];
      req
        .on("data", (data) => {
          dataChunks.push(data);
        })
        .on("end", () => {
          console.log("done", dataChunks.length);
          const json = JSON.parse(dataChunks.join(""));
          const length = json["data"].length;
          console.log(`Length = ${length}`);
          res.setHeader("Content-type", "application/json");
          res.writeHead(200);
          res.end(JSON.stringify(json));
        });
      break;
    default:
      res.setHeader("Content-type", "application/json");
      res.writeHead(400);
      res.end(JSON.stringify({ msg: "Bad data!" }));
  }
});

server.listen(3000, "localhost", () => {
  console.log("Listening on localhost:3000");
});
