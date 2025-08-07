import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ClientList = () => {
  const [clients, setClients] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/clients")
      .then(res => setClients(res.data))
      .catch(err => console.error("Failed to fetch clients:", err));
  }, []);

  return (
    <div>
      <h2>Client List</h2>
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {clients.map(c => (
            <tr key={c.id}>
              <td>{c.name}</td>
              <td>{c.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ClientList;
