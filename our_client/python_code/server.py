import socket
import threading

logFile=open('connectionLogs.txt','w')

#Setup Variables
IP = "192.168.1.11"
port = 30006
Buffer = 1024
connection= False
# In and Out data
re_commands = []
send_commands = []

def listen(connection):
    print("Listener has started.")
    while True:
        cur_move = []
        tmp_val = 0
        data = connection.recv(4096)
        print(data.decode("ASCII")[0:2])
        if data.decode("ASCII")[0:3]=="END":
            print("Listener Stopped")
            print(re_commands)
            break
        # Decodes each movement into the original list element
        for x in data.decode("ASCII"):
            try:
                tmp_val = int(x)
                cur_move.append(tmp_val)
            except ValueError:
                continue
        re_commands.append(cur_move)
def sender(connection):
    print("Sender has started")
    while True:
        if(len(send_commands) > 0):
            connection.send(send_commands[0])
            send_commands.remove(0)

def waitForClient():
    #Beginning search for clients
    print("Looking for Connections...")
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((IP,port))
    s.listen(5)
    conn, addr = s.accept()
    print("Connection Made")
    # Start 2 threads, listener and sender
    listener = threading.Thread(target = listen, args  = (conn,))
    listener.start()
    send = threading.Thread(target = sender, args  = (conn,))
    send.start()
    #_thread.start_new_thread(passwordVerification(),args=(conn,addr))



#Runs the program
waitForClient()
