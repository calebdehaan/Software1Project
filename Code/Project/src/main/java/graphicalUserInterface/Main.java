package graphicalUserInterface;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private static BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Main Application");
		showMainView();
		showMainItems();
	}
	
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}
	
	public static void showCreatePlayerScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("createNewPlayer/CreatePlayer.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}
	
	public static void showPreGameScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("preGame/PreGame.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}
	
	public static void showGameScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("game/Game.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}
	
	public static void showGameOver() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("gameOver/GameOver.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
