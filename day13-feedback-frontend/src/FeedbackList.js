import React, { useEffect, useState } from 'react';
import axios from 'axios';

const FeedbackList = () => {
  const [feedbacks, setFeedbacks] = useState([]);

  const fetchFeedbacks = async () => {
    const res = await axios.get('http://localhost:8000/api/feedback/all');
    setFeedbacks(res.data);
  };

  useEffect(() => {
    fetchFeedbacks();
  }, []);

  const handleDelete = async (id) => {
    await axios.delete(`http://localhost:8000/api/feedback/delete/${id}`);
    fetchFeedbacks(); // Refresh list
  };

  return (
    <div>
      <h2>Feedback List</h2>
      {feedbacks.length === 0 ? (
        <p>No feedback yet.</p>
      ) : (
        <ul>
          {feedbacks.map((fb) => (
            <li key={fb.id}>
              <p><strong>{fb.name}</strong> ({fb.email})</p>
              <p>{fb.comment}</p>
              <button onClick={() => handleDelete(fb.id)}>Delete</button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default FeedbackList;
