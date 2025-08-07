import React from "react";  
import Welcome from "./Welcome";
import AddNumbers from "./AddNumbers";
import UserInput from "./UserInput";
import UserInput2 from "./UserInpu2";
function App() {
  return (
    <div>
      <h1>Welcome to React Frontend!</h1>
      <Welcome name="John Doe" />
      <Welcome name="Jane Smith" />
      <Welcome name="Alice Johnson" />
      <AddNumbers a={5} b={10} />
      <AddNumbers a={20} b={30} />
      <UserInput />
      <UserInput2 />
    </div>
  );
}

export default App;
