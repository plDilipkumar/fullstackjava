import React from 'react';
import AddNumbers from './AddNumbers';

function UserInput() {
  const [name, setName] = React.useState('');
  const [inputValue, setInputValue] = React.useState('');

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };
  const [formData, setFormData] = React.useState({
    num: '',
    num2: ''
  });

  const handleChan = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const sum = formData.num + formData.num2;
  const actualSum = Number(name) + Number(inputValue);
  
  return (
    <div>
      <h2>User Input Component</h2>
      <p>This component can be used to gather user input.</p>

      <input
        type="text"
        value={inputValue}
        placeholder="Enter something..."
        onChange={handleInputChange}
      />
      
      <input
        type="text"
        value={name}
        placeholder="Enter your name"
        onChange={handleNameChange}
      />
      <p>You entered: {name}     You entered: {inputValue}</p>
      
         <button onClick={() => alert(`You entered : ${name} + ${inputValue} = ${actualSum}`)}>
        Submit(Actual addition)
       

      </button><br/>
      <input
        type="text"
        name="num2"
        placeholder="Enter something..."
        value={formData.num2}
        onChange={handleChan}
      />
      <p>You entered: {formData.num2}</p>

      <input
        type="text"
        name="num"
        placeholder="Enter your name"
        value={formData.num}
        onChange={handleChan}
      />
      <p>You entered: {formData.num}</p>

      <button onClick={() => alert(`You entered: ${formData.num} + ${formData.num2} = ${sum}`)}>
        Submit
      </button>
      
     
    </div>
  );
}

export default UserInput;
