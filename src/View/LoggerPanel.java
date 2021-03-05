package View;

import Observer.EventSource;
import Observer.EventObserver;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

/**
 * LoggerPanel creates an JTextArea and
 * prints each car model and speed in format "CarModel : Speed"
 * each car on a separate row.
 */
public class LoggerPanel extends JPanel implements EventObserver<ILoggable> {
    /**
     * Local variables
     */
    JTextArea jTextArea = new JTextArea("<Car> : <speed>"); // dummy text

    /**
     * Initialize the panel "JTextArea", and listen to ILoggable changes from Observer.EventObserver.
     * @param source where to spy for changes.
     */
    public LoggerPanel(EventSource<ILoggable> source) {
        source.addSubscriber(this);
        this.add(jTextArea);
    }

    /**
     * Observer.EventHandler tells us there is a change - then we do an update.
     * @param loggable, for each ILoggable object we update the view with new values.
     */
    @Override
    public void actOnPublish(Collection<ILoggable> loggable) {
        StringBuilder res = new StringBuilder();
        DecimalFormat df = new DecimalFormat("###.#");

        for (ILoggable e : loggable) {

            res.append(e.getName()).append(" : ").append(df.format(e.getSpeed())).append("\n");
        }
        jTextArea.setText(res.toString());
    }

}
