import express from 'express';
import { env } from 'process';
var mysql = require('mysql');

const app = express();
const port = 3000;

app.get('/', (req, res) => {
  console.log('Request received' + new Date());
  const podName = env.HOSTNAME || 'unknown';
  res.send('Hello, World! ' + podName);
});

app.get('/health', (req, res) => {
  res.send('Server is up and running!');
});

app.get('/msgs', (req, res) => {
  var connection = mysql.createConnection({
    host: env.DB_HOST,
    user: 'app',
    password: 'app',
    database: 'app'
  });

  connection.connect((err: any) => {
    if (err) {
      console.error('Error connecting to database');
      res.status(500).send('Internal Server Error QQ');
      return;
    }

    connection.query('SELECT message from messages', (err: any, rows: any, fields: any) => {
      res.send(rows);
    });

    connection.end();
  });
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});