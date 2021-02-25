package View;

import Model.LoggerObserver;
import Model.LoggerHandler;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// This panel prints car and velocity.
// for each car a new label is created.
public class LoggerPanel extends JPanel implements LoggerObserver {
    // private List<ILoggable> loggables = new ArrayList<>();
//    JPanel panel = new JPanel(new GridLayout(0, 1));
    JTextArea jTextArea = new JTextArea("<Car> : <speed>");

    // Initializes the panel and reads the images
    public LoggerPanel(LoggerHandler handler) {
        handler.addSubscriber(this);
//        String res = generateCarSpeeds();
//        label.setText(res);
//        this.add(jTextArea);

        this.add(jTextArea);
    }


    // This method is called each time the panel updates/refreshes/repaints itself



/*
    private String generateCarSpeeds() {
        StringBuilder res = new StringBuilder();
        for (ILoggable e : loggables) {
            res.append(e.getModelName()).append(" : ").append(e.getCurrentSpeed()).append("\n");
        }
        return res.toString();
    }
*/

    @Override
    public void actOnPublish(List<? extends ILoggable> loggable) {
        StringBuilder res = new StringBuilder();

        for (ILoggable e : loggable) {
            res.append(e.getModelName()).append(" : ").append(e.getCurrentSpeed()).append("\n");
//            JLabel label = new JLabel(e.getModelName() + " : " + e.getCurrentSpeed());
//            panel.add(label);
        }

        jTextArea.setText(res.toString());
    }


    private void setCarList(ILoggable l) {

    }
}
