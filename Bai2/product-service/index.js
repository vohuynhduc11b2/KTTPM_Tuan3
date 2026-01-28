const express = require("express");
const app = express();

app.get("/products", (req, res) => {
  res.json({
    service: "PRODUCT SERVICE",
    data: ["Laptop", "Phone", "Tablet"]
  });
});

app.listen(3001, () => {
  console.log("Product service running on port 3001");
});
