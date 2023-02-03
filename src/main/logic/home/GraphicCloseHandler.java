package home;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
public class GraphicCloseHandler implements EventHandler<WindowEvent> {
    @Override
    public void handle(WindowEvent event) {
        Home home=new Home();
        Home.quit();
    }
}