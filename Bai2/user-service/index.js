const express = require("express");
const app = express();

app.get("/users", (req, res) => {
  res.json({
    service: "USER SERVICE",
    data: ["Alice", "Bob", "Charlie"]
  });
});

app.listen(3002, () => {
  console.log("User service running on port 3002");
});
