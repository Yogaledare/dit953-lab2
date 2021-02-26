package View;

import Model.EventHandler;
import Model.EventObserver;
import javax.swing.*;
import java.util.List;

// This panel prints car and velocity.
// for each car a new label is created.
public class LoggerPanel extends JPanel implements EventObserver<ILoggable> {
    JTextArea jTextArea = new JTextArea("<Car> : <speed>");

    // Initializes the panel and reads the images
    public LoggerPanel(EventHandler<EventObserver<ILoggable>,ILoggable> handler) {
        handler.addSubscriber(this);
        this.add(jTextArea);
    }


    @Override
    public void actOnPublish(List<? extends ILoggable> loggable) {
        StringBuilder res = new StringBuilder();

        for (ILoggable e : loggable) {
            res.append(e.getModelName()).append(" : ").append(e.getCurrentSpeed()).append("\n");
        }

        jTextArea.setText(res.toString());
    }

}
