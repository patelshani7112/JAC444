"use strict";
const express = require("express");
var cors = require("cors");
const app = express();

// declare the core
app.use(cors());

app.use(express.json());

app.get("/", (req, res) => {
  res.json({ msg: "API Listening" });
});

app.get("/api/restaurants", (req, res) => {
  res.json({ msg: "All API" });
});

app.post("/api/restaurants", (req, res) => {});

app.get("/api/restaurants/:id", (req, res) => {});

app.put("/api/restaurants/:id", (req, res) => {
  res.json({
    message: `updated item with identifier: ${req.params.id} to ${req.body.firstName} ${req.body.lastName}`,
  });
});

app.delete("/api/restaurants/:id", (req, res) => {
  // MUST return HTTP 204
  res
    .status(200)
    .json({ message: `deleted user with identifier: ${req.params.id}` });

  // In a real app, do not send body data, instead just send...
  //res.status(204).end();
});

app.listen(3000, (err) => {
  if (err) {
    console.log("there was a problem", err);
    return;
  }
  console.log("listening on port 3000");
});
