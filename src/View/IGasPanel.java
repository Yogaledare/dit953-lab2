package View;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public interface IGasPanel {
    void setSpinnerChangeListener(ChangeListener listener);
    void setGasButtonActionListener(ActionListener listener);
    void setBrakeButtonActionListener(ActionListener listener);
}
