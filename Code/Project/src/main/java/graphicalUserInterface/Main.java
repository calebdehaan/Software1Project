package graphicalUserInterface;

import java.awt.desktop.ScreenSleepEvent;
import java.io.IOException;
import java.util.ArrayList;

import graphicalUserInterface.game.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Main Application");
		showMainView();
		showLoginPage();
	}
	
	private void showLoginPage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("loginPage/LoginPage.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 800, 600);
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

		/*
		 * Stage addDialogStage = new Stage();
		 * addDialogStage.setTitle("Add new Player");
		 * addDialogStage.initModality(Modality.WINDOW_MODAL);
		 * addDialogStage.initOwner(primaryStage); Scene scene = new
		 * Scene(createPlayer); addDialogStage.setScene(scene);
		 * addDialogStage.showAndWait();
		 */
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

	public static void showGameOverScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("gameOver/GameOver.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}

	public static void showTurnoverScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("turnover/Turnover.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}

	public static void showPlayerStatsScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("playerStats/PlayerStats.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}

	public static void showCreateNewPlayerVerificationScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("createNewPlayerVerification/CreateNewPlayerVerification.fxml"));
		BorderPane createPlayer = loader.load();
		mainLayout.setCenter(createPlayer);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
