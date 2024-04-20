import { useState, useEffect } from 'react';
import Axios from 'axios';
import './App.css';

function App() {
  const [data, setData] = useState([]);

  useEffect(() => {
    Axios.get('http://localhost:3000/users')
      .then(response => setData(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div className='card'>
      {data.map((person, index) => (
        <div key={index}>
          <div>
            <div>{person.name}</div>
            <div>{person.phone}</div>
            <div>{person.email}</div>
            <br />
          </div>
        </div>
      ))}
    </div>
  )
}

export default App;
