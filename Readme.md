# Spreadsheet calc

```
bash-3.2$ cd src/
bash-3.2$  javac -cp . com/Abhishek/Spreadsheet/*.java
bash-3.2$  java -cp . com/Abhishek/Spreadsheet/Spreadsheet
bash-3.2$ cat ../test_input1.txt | java -cp . com/Abhishek/Spreadsheet/Spreadsheet
20.00000
20.00000
20.00000
8.66667
3.00000
1.50000
bash-3.2$ cat ../test_input2.txt | java -cp . com/Abhishek/Spreadsheet/Spreadsheet
cyclic dependency detected
cyclic dependency detected
cyclic dependency detected
cyclic dependency detected
3.00000
cyclic dependency detected
```
