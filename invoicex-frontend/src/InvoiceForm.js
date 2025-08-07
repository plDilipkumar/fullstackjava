import React, { useState, useEffect } from 'react';
import invoiceService from './InvoiceService';
import clientService from './ClientService';

const InvoiceForm = () => {
  const [formData, setFormData] = useState({
    invoiceNumber: '',
    issueDate: '',
    dueDate: '',
    amount: '',
    status: 'PENDING',
    clientId: ''
  });

  const [clients, setClients] = useState([]);
  const [message, setMessage] = useState('');

  useEffect(() => {
    clientService.getAllClients()
      .then((res) => setClients(res.data))
      .catch((err) => console.error('Error fetching clients', err));
  }, []);

  const handleChange = (e) => {
    setFormData({...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await invoiceService.createInvoice(formData);
      setMessage('Invoice created successfully!');
      setFormData({
        invoiceNumber: '',
        issueDate: '',
        dueDate: '',
        amount: '',
        status: 'PENDING',
        clientId: ''
      });
    } catch (error) {
      setMessage('Error creating invoice');
      console.error(error);
    }
  };

  return (
    <div>
      <h2>Create Invoice</h2>
      {message && <p>{message}</p>}
      <form onSubmit={handleSubmit}>
        <input type="text" name="invoiceNumber" placeholder="Invoice Number" value={formData.invoiceNumber} onChange={handleChange} required />
        <input type="date" name="issueDate" value={formData.issueDate} onChange={handleChange} required />
        <input type="date" name="dueDate" value={formData.dueDate} onChange={handleChange} required />
        <input type="number" name="amount" placeholder="Amount" value={formData.amount} onChange={handleChange} required />
        
        <select name="status" value={formData.status} onChange={handleChange}>
          <option value="PENDING">PENDING</option>
          <option value="PAID">PAID</option>
          <option value="CANCELLED">CANCELLED</option>
        </select>

        <select name="clientId" value={formData.clientId} onChange={handleChange} required>
          <option value="">Select Client</option>
          {clients.map((client) => (
            <option key={client.id} value={client.id}>
              {client.name} ({client.email})
            </option>
          ))}
        </select>

        <button type="submit">Create Invoice</button>
      </form>
    </div>
  );
};

export default InvoiceForm;
