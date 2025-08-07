import React, { useState } from 'react';
import axios from 'axios';

const AddClient = () => {
  const [client, setClient] = useState({
    name: '',
    email: '',
    phone: ''
  });

  const handleChange = (e) => {
    setClient({ ...client, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/clients', client);
      alert('Client added successfully!');
      setClient({ name: '', email: '', phone: '' });
    } catch (error) {
      console.error('Error adding client:', error);
    }
  };

  return (
    <div>
      <h2>Add Client</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="name" value={client.name} onChange={handleChange} placeholder="Name" required />
        <input type="email" name="email" value={client.email} onChange={handleChange} placeholder="Email" required />
        <input type="text" name="phone" value={client.phone} onChange={handleChange} placeholder="Phone" required />
        <button type="submit">Add Client</button>
      </form>
    </div>
  );
};

export default AddClient;
