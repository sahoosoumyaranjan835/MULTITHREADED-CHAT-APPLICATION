# MULTITHREADED-CHAT-APPLICATION

COMPANY : CODTECH IT SOLUTIONS
NAME : SOUMYA RANJAN SAHOO
INTERN ID : CT06DH674
DOMAIN : JAVA
DURATION : 6 WEEKS
MENTOR : NEELA SANTHOSH

## DESCRIPTION ##
Deliverable: Java Multi-Threaded Chat Application with GUI Client
Objective
This Java program implements a simple TCP-based chat application where a multi-threaded server handles multiple client connections, and the client uses a Swing-based graphical interface to send and receive messages. The server echoes back received messages, and the client displays them in real-time.

Architecture Overview
The program consists of two main components:

Server (Server and ClientHandler classes) – Listens for client connections and processes messages.

Client (ClientGUI class) – Provides a GUI for connecting to the server, sending, and receiving messages.

Server Functionality
Class: Server

The server listens on port 12345 using a ServerSocket.

It continuously waits for incoming connections using accept().

When a client connects, a new ClientHandler thread is started to manage communication with that client.

Class: ClientHandler (extends Thread)

Responsible for handling a single connected client.

Uses BufferedReader to read messages sent by the client.

Uses PrintWriter to send messages back to the client (echo functionality).

Runs in a loop, continuously reading and responding until the client disconnects.

Flow:

Server starts and prints "Server started...".

A client connects, and the server prints "New client connected: [socket details]".

The ClientHandler reads messages, logs them on the server console, and sends them back to the client.

Client Functionality
Class: ClientGUI

Provides a graphical user interface built using Java Swing components.

Components include:

JTextArea for displaying the chat history (non-editable).

JTextField for typing messages.

JButton “Send” for sending messages.

JButton “Connect” for establishing a connection to the server.

GUI Layout:

Center: Scrollable chat area (JScrollPane containing JTextArea).

Bottom: Input panel with text field and buttons using FlowLayout.

Key Methods:

setupGUI() – Initializes and arranges GUI components, sets listeners for buttons and input field.

connectToServer() – Creates a socket connection to "localhost" on port 12345, initializes input/output streams, and starts a background thread for receiving server messages.

sendMessage() – Sends the user-typed message to the server and displays it in the chat area.

Program Workflow
Start the server by running Server.java.

Start the client by running ClientGUI.java.

Click Connect in the client to establish a connection.

Type a message in the input field and click Send or press Enter.

The server receives the message, logs it, and sends it back with "Echo:" prefixed.

The client displays both the sent and echoed messages in the chat area.

Key Features
Multi-threaded Server: Handles multiple clients concurrently.

Real-time Communication: Messages are sent and received instantly.

GUI Client: User-friendly interface for interaction.

Event Handling: Button clicks and Enter key trigger sending messages.

TCP Networking: Uses sockets for reliable message transfer.

Conclusion
This Java program effectively demonstrates multi-threaded socket programming and GUI development. The server listens for multiple connections, each handled in its own thread, ensuring scalability. The client provides a clean, interactive interface for sending and receiving messages, making it an excellent foundation for building a more advanced chat system.


Event Handling: Button clicks and Enter key trigger sending messages.

TCP Networking: Uses sockets for reliable message transfer.
