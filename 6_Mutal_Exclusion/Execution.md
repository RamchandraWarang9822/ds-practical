# Steps 

### Create [TokenRing.java](TokenRing.java)

- Import Scanner
- Initiate main and scanner within main
- Declare all the variables like ```nodes``` , ```sender``` , ```reciever``` , ```data```
- Take the number of ```nodes``` from the user
- Initiate ```choice``` to 1
- Declare a while loop until ```choice == 1``` 
- Take ```sender``` , ```reciever``` , ```data``` from user
- Print the output using circular loop ```i % n``` 
- Declare a inner while loop ```choice != 2```
- Add try-catch to catch exception in setting ```choice``` 
- Ask the user for his ```choice``` to continue again
    - Yes : 1
    - No : 2
- Add conditions to validate user input for choice

---

# Execution

```bash
javac TokenRing.java
```

```bash
java TokenRing
```