const express = require("express");
const cors = require("cors");

const app = express();
app.use(cors());

const data = [
    {
        name: "Rohit",
        email: "mailRohit@gmail.com",
        phone: "1234567890",
    },
    {
        name: "Sachin",
        email: "Sachin@gmail.com",
        phone: "9638527410",
    },
    {
        name: "Dhoni",
        email: "Dhoni@gmail.com",
        phone: "7418529630",
    },
];

app.get("/users", (request, response) => {
    response.json(data);
    console.log(data);
})

app.listen(3000, () => {
    console.log("Listening on port 3000");
})