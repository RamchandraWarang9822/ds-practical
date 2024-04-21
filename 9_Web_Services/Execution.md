# Steps 

### Create [Backend](Backend) directory 

```powershell
cd Backend
npm init -y
```

### Install Express and Cors

```powershell
npm i express cors
```

###  Create [Index.js](Backend/index.js) 

- Import express and cors
- Initiate ```app``` using ```express()```
- Let ```app``` user ```cors()```
- Create an array ```[]``` of object ```{}``` named as ```data```
- Let the app listen on port **3000**
- Set app to get ```/users``` path to **PUT** response as ```data```

### Start the Server

```powershell
node index.js
```

- Check response at http://localhost:3000/users  

---

### [Frontend](Frontend)

### Create React Application ( _using vite template_ )

```powershell
# Run this command
npm create vite Frontend

# Select these options
√ Package name: ... frontend # Default value
√ Select a framework: » React # Select React with arrow keys
√ Select a variant: » JavaScript

cd Frontend
npm i axios # This will install all packages including axios
```

### Change Frontend Code [App.jsx](Frontend/src/App.jsx)

- Clear ```App.jsx``` 
- Add ```react , axios , App.css``` import
- Initiate ```data``` usestate
- Implement ```useEffect```
    - Use Axios to get response from http://localhost:3000/users
    - Set ```data``` state to ```response.data```

- Return the html structure you want to view the data in 
- Use ```data.map``` to create a basic card to display each users data in response

```jsx
<div className='card'>
    {data.map((person, index) => (
        <div key={index}>
        <div>
            <div>{person.name}</div>
            <div>{person.phone}</div>
            <div>{person.email}</div>
            <br/>
        </div>
        </div>
    ))}
</div>
```

- Add ```export default App;```

### Run the application

```powershell
npm run dev
```

###

---

# Execution

- After running both application check below links and console 
- Backend : http://localhost:3000/users
- Frontend : http://localhost:5173/

- _If nothing is being rendered in Frontend there might be an issue with the response or the server_
