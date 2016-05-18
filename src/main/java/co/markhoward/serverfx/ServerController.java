package co.markhoward.serverfx;

import java.io.File;

import co.markhoward.serverfx.server.Server;
import co.markhoward.serverfx.server.UnderTowServer;
import co.markhoward.serverfx.utils.ServerUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

public class ServerController {
	@FXML
	private Button startButton;
	
	@FXML
	private Button stopButton;
	
	@FXML
	private Button chooseDirectory;
	
	@FXML
	private Label directoryLabel;
	
	@FXML
	private TextField portTextField;
	
	@FXML
	private AnchorPane anchorPane;
	
	private File outputDirectory;
	private Server server;
	
	@FXML
	private void onStartServer(ActionEvent event){
		int port = ServerUtils.toInt(portTextField.getText(), DEFAULT_PORT);
		if(port == DEFAULT_PORT){
			portTextField.setText(Integer.toString(port));
		}
		
		server = new UnderTowServer(port);
		server.start(outputDirectory, LOCALHOST);
		startButton.setDisable(true);
		stopButton.setDisable(false);
		anchorPane.getScene().getWindow();
	}
	
	@FXML
	private void onStopServer(ActionEvent event){
		server.stop();
		stopButton.setDisable(true);
		startButton.setDisable(false);
	}
	
	@FXML
	private void onChooseDirectory(ActionEvent event){
		DirectoryChooser directoryChooser = new DirectoryChooser();
		outputDirectory = directoryChooser.showDialog(anchorPane.getScene().getWindow());
		if(outputDirectory != null)
			directoryLabel.setText(outputDirectory.getAbsolutePath());
	}
	
	private static final int DEFAULT_PORT = 8080;
	private static final String LOCALHOST = "localhost";
}
