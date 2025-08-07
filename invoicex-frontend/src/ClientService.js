import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/clients';

const createClient = (clientData) => {
  return axios.post(BASE_URL, clientData);
};
const getAllClients = () => {
  return axios.get(BASE_URL);
};

const clientService = { createClient, getAllClients };

export default clientService;

