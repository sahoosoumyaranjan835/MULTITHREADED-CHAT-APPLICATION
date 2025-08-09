 package task;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	private JFrame frame;
	private JTextArea chatArea;
	private JTextField inputField;
	private JButton sendButton, connectButton;

	public ClientGUI() {
		setupGUI();
	}

	private void setupGUI() {
		frame = new JFrame("Java Chat Client");
		chatArea = new JTextArea(20, 40);
		inputField = new JTextField(30);
		sendButton = new JButton("Send");
		connectButton = new JButton("Connect");

		chatArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(chatArea);

		JPanel panel = new JPanel(new FlowLayout());
		panel.add(inputField);
		panel.add(sendButton);
		panel.add(connectButton);

		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Action Listeners
		sendButton.addActionListener(e -> sendMessage());
		inputField.addActionListener(e -> sendMessage());
		connectButton.addActionListener(e -> connectToServer());
	}

	private void connectToServer() {
		try {
			socket = new Socket("localhost", 12345);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

			chatArea.append("Connected to server...\n");

			// Start background thread to read messages
			Thread readerThread = new Thread(() -> {
				try {
					String msg;
					while ((msg = in.readLine()) != null) {
						chatArea.append("Server: " + msg + "\n");
					}
				} catch (IOException ex) {
					chatArea.append("Connection lost.\n");
				}
			});
			readerThread.start();

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(frame, "Cannot connect to server.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void sendMessage() {
		String message = inputField.getText();
		if (message.isEmpty() || out == null) return;
		out.println(message);
		chatArea.append("You: " + message + "\n");
		inputField.setText("");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(ClientGUI::new);
	}
}
