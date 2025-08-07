import React, { useState } from 'react';
import axios from 'axios';

const FeedbackForm = () => {
  const [feedback, setFeedback] = useState({
    name: '',
    email: '',
    comment: ''
  });

  const handleChange = (e) => {
    setFeedback({ ...feedback, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8000/api/feedback/save', feedback);
      alert('Feedback submitted successfully!');
      setFeedback({ name: '', email: '', comment: '' });
    } catch (error) {
      console.error('Error submitting feedback:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Submit Feedback</h2>
      <input type="text" name="name" value={feedback.name} onChange={handleChange} placeholder="Name" required />
      <input type="email" name="email" value={feedback.email} onChange={handleChange} placeholder="Email" required />
      <textarea name="comment" value={feedback.comment} onChange={handleChange} placeholder="Your Feedback" required />
      <button type="submit">Submit</button>
    </form>
  );
};

export default FeedbackForm;
