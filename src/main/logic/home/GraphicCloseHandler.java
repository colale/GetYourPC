package home;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
public class GraphicCloseHandler implements EventHandler<WindowEvent> {//manage the window close click graphic event
    @Override
    public void handle(WindowEvent event) {
        Home.quit();
    }
}