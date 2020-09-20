step 1 : Create a java project Sockets
step 2 : create a packet tcpsocket
step 3 : create 2 classes, tcpserver and tcpserver
step 4 : add codes to the respective classes 
step 5 : run the server first 
step 6 : run the client next 

Link for the video : 
Part 1 - https://www.youtube.com/watch?v=c13XxZgUVj0&list=WL&index=8&t=0s
Part 2 - https://www.youtube.com/watch?v=MshSvgwBmU4&list=WL&index=9&t=0s

Everytime after you run the code : 
open terminal and kill the port thatwe used the in the code or else it will create error

command for that is:- 
assume we used port 8080 which had pid 1234

first fire this command :- netstat -ano | find "8080"
second fire this command :- taskkill -pid 1234 /f