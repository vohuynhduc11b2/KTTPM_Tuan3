const express = require("express");
const axios = require("axios");
const config = require("./config");

const app = express();

app.use(async (req, res) => {
  const path = req.originalUrl;

  // tìm route phù hợp
  for (const route in config.routes) {
    if (path.startsWith(route)) {
      const target = config.routes[route];

      try {
        const response = await axios({
          method: req.method,
          url: target + path,
          data: req.body
        });

        return res.status(response.status).send(response.data);
      } catch (err) {
        return res.status(500).json({ error: "Service error" });
      }
    }
  }

  res.status(404).json({ error: "Route not found" });
});

app.listen(9090, () => {
  console.log("Load balancer running on port 9090");
});
