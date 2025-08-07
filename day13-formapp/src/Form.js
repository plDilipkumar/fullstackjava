import React, { useState } from "react";

function Form() {
  const [formData, setFormData] = useState({
    name: "",
    inputValue: "",
    num: "",
    num2: ""
  });

  const handleChange = (e) => {
    setFormData({...formData, [e.target.name]: e.target.value});
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const response = await fetch("http://localhost:8080/api/input", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(formData)
    });

    if (response.ok) {
      alert("Data submitted successfully!");
      setFormData({ name: "", inputValue: "", num: "", num2: "" });
    } else {
      alert("Error submitting data");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" value={formData.name} onChange={handleChange} placeholder="Name" /><br />
      <input name="inputValue" value={formData.inputValue} onChange={handleChange} placeholder="Input Value" /><br />
      <input name="num" type="number" value={formData.num} onChange={handleChange} placeholder="Num" /><br />
      <input name="num2" type="number" value={formData.num2} onChange={handleChange} placeholder="Num2" /><br />
      <button type="submit">Submit</button>
    </form>
  );
}

export default Form;
