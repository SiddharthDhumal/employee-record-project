import axios from 'axios';


const REST_API_BASE_URL = 'http://localhost:8081/api/employees';

export const listofEmployees = async () =>  await axios.get(REST_API_BASE_URL);

export const createEmployee = async (employee) => await axios.post(REST_API_BASE_URL,employee);

export const getEmployee = async (employeeId) => await axios.get(REST_API_BASE_URL + '/' + employeeId);

export const updateEmployee = async (employeeId,employee) => await axios.put(REST_API_BASE_URL + '/' + employeeId,employee);

export const deleteEmployee = async(employeeId) => await axios.delete(REST_API_BASE_URL+ '/' + employeeId);

