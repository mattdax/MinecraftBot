import socket
import _thread
import datetime

#configuring time settings
now = datetime.datetime.now()

#opening the accounts file so that it can be read

logFile=open('connectionLogs.txt','w')

#Setup Variables
IP = "192.168.1.11"
port = 30000
Buffer = 1024
connection= False

clientErrorMessage=""

def waitForClient():
    #Beginning search for clients
    print("Looking for Connections...")
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((IP,port))
    s.listen(5)
    conn, addr = s.accept()
    print("successful Connection")
    print(conn,addr)
    conn.send("Poo poo".encode())
    #logFile.write("["+now.strftime("%Y-%m-%d %H:%M")+"] Connection from",addr)
    #making a new thread so that the program can keep searching for new connections
    #_thread.start_new_thread(passwordVerification(),args=(conn,addr))

#Introduction to threading, still learning about this
#_thread.start_new_thread(waitForClient())

#Runs the program
waitForClient()
