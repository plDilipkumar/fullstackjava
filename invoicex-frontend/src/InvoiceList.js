import React, { useEffect, useState } from 'react';
import invoiceService from './InvoiceService';

const InvoiceList = () => {
  const [invoices, setInvoices] = useState([]);

  const fetchInvoices = () => {
    invoiceService.getAllInvoices()
      .then(res => setInvoices(res.data))
      .catch(err => console.error('Failed to fetch invoices:', err));
  };

  useEffect(() => {
    fetchInvoices();
  }, []);

  const handleDelete = (id) => {
    invoiceService.deleteInvoice(id)
      .then(() => fetchInvoices())
      .catch(err => console.error("Delete failed:", err));
  };

  return (
    <div>
      <h2>All Invoices</h2>
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Invoice #</th>
            <th>Issue Date</th>
            <th>Due Date</th>
            <th>Amount</th>
            <th>Status</th>
            <th>Client</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {invoices.map((inv) => (
            <tr key={inv.id}>
              <td>{inv.invoiceNumber}</td>
              <td>{inv.issueDate}</td>
              <td>{inv.dueDate}</td>
              <td>{inv.amount}</td>
              <td>{inv.status}</td>
              <td>{inv.clientName} ({inv.clientEmail})</td>
              <td>
                <button onClick={() => handleDelete(inv.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default InvoiceList;
