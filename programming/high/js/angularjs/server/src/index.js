const express = require("express");
const db = require("../db/db.js");
const app = express();
const port = 3000;

app.use(express.json());
app.get("/", (req, res) => {
  res.send("Hello World!");
});

app.get("/user", async (req, res) => {
  db.all("select * from user", (err, rows) => {
    if (err) return res.json(err);
    return res.json({ data: rows });
  });
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
