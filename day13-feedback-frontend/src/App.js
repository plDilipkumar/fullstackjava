
import './App.css';
import FeedbackForm from './FeedbackForm';
import FeedbackList from './FeedbackList';
function App() {
  return (
    <div>
      <h1>Feedback collector</h1>
      <FeedbackForm/>
      <hr/>
      <FeedbackList/>
    </div>
  );
}

export default App;
