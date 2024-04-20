 # Steps

 ### 1. Create [ServerInterface.java](ServerInterface.java)

 - Create ServerInterface which extends remote
 - Declare "concat" method which throws RemoteException

 ### 2. Create [Servant.java](Servant.java)

 - Create Servant Class which extends UnicastRemoteObject and implements the ServerInterface
 - Declare Servant constructor which throws RemoteException and runs super()
 - Define the concat method 

 ### 3. Create [Server.java](Server.java)

 - In main add try catch block
 - Create Servant object
 - Add Naming.bind to "/Server"

 ### 4. Create [Client.java](Client.java)

 - In main add try catch block 
 - Initiate Scanner
 - Take two string to concatinate
 - Initate Server Interface Object to lookup localhost
 - Run the concat function throw ServerInterface Object 


---

 # Execution

Three Seperate Terminals 

**Compile Java code :** 
```bash
javac *.java
```

### 1. Run 
```bash
rmiregistry
```
### 2. Execute 
```bash
java Server
```
### 3. Execute 
```bash
java Client
```
#### - Input two String
#### - Output will be displayed