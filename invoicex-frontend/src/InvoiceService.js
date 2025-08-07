import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/invoices';

const createInvoice = (invoiceData) => {
  return axios.post(BASE_URL, invoiceData);
};
const getAllInvoices = () => {
  return axios.get(BASE_URL);
};

const deleteInvoice = (id) => {
  return axios.delete(`${BASE_URL}/${id}`);
};

const invoiceService = {
  createInvoice,
  getAllInvoices,
  deleteInvoice
};


export default invoiceService;
