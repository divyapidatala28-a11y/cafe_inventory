1. Actual output and predicted output are same
7 5.0 -126  
Two
Three
--**---
int n = 130;
byte b = (byte) n;**  
int is 32-bit and byte is 8 bit and stores values from -128 to 127. 130 is outside the byte range
when you cast 130 to byte,java keeps only last 8 bits i.e 10000010. first  bit is 1 so it represents negative
number
130-256=-126

2. The static variable totalProducts is shared across the entire class, so there is only one 
counter for all products combined. On the other hand, name is an instance variable, which 
means each individual product has its own separate name. When you add a new item, 
totalProducts increases for everyone, but the name belongs only to that one item.

3. A copy constructor makes a new copy of an existing product at a different place in memory 
Because p1 and p2 are two separate objects, they do not share their details. Changing p2.name 
only edits the copy, so the original p1.name stays exactly as it was.

4. Java forces you to write (int) because converting a decimal number (double) into a whole
number (int) loses data, so Java wants to make sure you are doing it on purpose. When it converts, 
it simply cuts off and throws away everything after the decimal point 

