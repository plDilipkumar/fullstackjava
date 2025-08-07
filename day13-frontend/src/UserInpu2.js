// src/UserInput.js
import React, { useState } from 'react';
import { addNumbers } from './AddNumbers'; // Import your add function

function UserInput2() {
  const [name, setName] = useState('');
  const [inputValue, setInputValue] = useState('');
  const [formData, setFormData] = useState({
    num: '',
    num2: ''
  });
  const [actualSum, setActualSum] = useState(null);

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const sum = Number(formData.num) + Number(formData.num2);

  const handleActualAddition = () => {
    const result = addNumbers(Number(formData.num), Number(formData.num2));
    setActualSum(result);
  };

  return (
    <div>
      <h2>User Input Component</h2>
      <p>This component can be used to gather user input.</p>

      {/* First input pair */}
      <input
        type="text"
        value={inputValue}
        placeholder="Enter something..."
        onChange={handleInputChange}
      />
      <br />
      <input
        type="text"
        value={name}
        placeholder="Enter your name"
        onChange={handleNameChange}
      />
      <br />
      <p>You entered: {name} + {inputValue}</p>

      {/* Number inputs for actual addition */}
      <input
        type="text"
        name="num"
        placeholder="Enter first number"
        value={formData.num}
        onChange={handleChange}
      />
      <br />
      <input
        type="text"
        name="num2"
        placeholder="Enter second number"
        value={formData.num2}
        onChange={handleChange}
      />
      <br />
      <p>You entered: {formData.num} and {formData.num2}</p>

      <button onClick={() => alert(`You entered: ${formData.num} + ${formData.num2} = ${sum}`)}>
        Submit (String Addition)
      </button>
      <br />
      <br />

      <button onClick={handleActualAddition}>
        Submit (Actual Addition using addNumbers)
      </button>

      {actualSum !== null && (
        <>
          <br />
          <p>Actual Sum is: {actualSum}</p>
        </>
      )}
    </div>
  );
}

export default UserInput2;
