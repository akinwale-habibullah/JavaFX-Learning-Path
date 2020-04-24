import javafx.application.Application;
// stage is the container for the entire application
import javafx.stage.Stage;

public class HelloFx extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello JavaFx");
        // display the GUI
        stage.show();
    }
}
