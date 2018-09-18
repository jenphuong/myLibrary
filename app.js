const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => res.send('Welcome to the book library!'))

app.listen(port, () => console.log(`Instance started on port ${port}!`))
