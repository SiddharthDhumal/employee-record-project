import React, { useEffect, useState } from 'react';
import { deleteEmployee, listofEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListofEmployeeComponent = () => {

  const [employees, setEmployees] = useState([]);

  const navigator = useNavigate();

  useEffect(() => {
    getAllEmployees();
  }, []);


  function getAllEmployees(){
    listofEmployees().then((response) => {
      setEmployees(response.data);
    }).catch((error) => {
      console.error(error);
    })
  }

  const addNewEmployee = async () => {
    navigator('/add-employee');
  }

  const updateEmployee = async (empId) => {
    navigator(`/edit-employee/${empId}`);
  }


  const removeEmployee = async (empId) => {

    deleteEmployee(empId).then((response) => {
     getAllEmployees();
    }).catch((error) => { console.error(error) });
  }

  return (
    <div className="container">
      <h2 className='text-center'>List of Employees</h2>
      <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
      <table className='table table-striped table-borderd'>
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Id</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {
            employees.map((employee) => (

              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>
                  <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button>
                  <button style={{marginLeft:'10px'}} className='btn btn-danger' onClick={() => removeEmployee(employee.id)}>Delete</button>
                </td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  )
}

export default ListofEmployeeComponent