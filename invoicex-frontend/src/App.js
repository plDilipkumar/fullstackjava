import React from 'react';
import InvoiceForm from './InvoiceForm';
import InvoiceList from './InvoiceList';
import ClientList from './ClientList';
import AddClient from './AddClient';

function App() {
  return (
    <div className="App">
      <h1>InvoiceX – Smart Invoice Manager</h1>
      <InvoiceForm />
      <hr />
      <InvoiceList />
      <hr />
      <ClientList />
      <hr /><AddClient/>
    </div>
  );
}

export default App;
