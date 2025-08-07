import React from 'react';
function AddNumbers(props) {
  const sum = Number(props.a) + Number(props.b);
  return (
    <div>
      <h2>The sum of {props.a} and {props.b} is {sum}</h2>
    </div>
  );
}
export default AddNumbers;
// src/AddNumbers.js
export function addNumbers(a, b) {
  return a + b;
}
