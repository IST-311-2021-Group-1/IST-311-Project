package tournamentapp;

//import model.PlayerList;
//import model.StoreList;
//import controller.Navigation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TournamentApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("../view/Navigation.fxml"));
      
        Scene scene = new Scene(root);
        stage.setTitle("Tournament App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
