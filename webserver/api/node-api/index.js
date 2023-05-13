import * as http from "http";
import * as fs from "fs";
import ServerError from "./errorHandling/error.js";
import { getAllUsers } from "./mock-db/mockDB.js";

const PORT = 3000;
const HOST = "0.0.0.0";
const fsPromise = fs.promises;

const server = http.createServer((req, res) => {
  switch (req.url) {
    case "/index.html":
      fsPromise
        .readFile(process.cwd() + "/pages/index.html")
        .then((htmlFile) => {
          res.setHeader("Content-type", "text/html");
          res.writeHead(200);
          res.end(htmlFile);
        })
        .catch((err) => {
          res.setHeader("Content-type", "application/json");
          res.writeHead(500);
          res.end(JSON.stringify(new ServerError("Error reading file", 500)));
        });
      break;
    case "/users":
      getAllUsers()
        .then((users) => {
          res.setHeader("Content-type", "application/json");
          res.writeHead(200);
          res.end(JSON.stringify({ data: users }));
        })
        .catch((err) => {
          res.setHeader("Content-type", "application/json");
          res.writeHead(500);
          res.end(JSON.stringify(new ServerError("Error reading file", 500)));
        });
      break;
    default:
      const error = {
        err: "Page not found",
      };
      res.setHeader("Content-type", "application/json");
      res.writeHead(404);
      res.end(JSON.stringify(error));
  }
});

server.listen(PORT, HOST, () => {
  console.log(`Listening on ${HOST}:${PORT}`);
});
