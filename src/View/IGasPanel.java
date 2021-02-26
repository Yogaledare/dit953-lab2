package View;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

/**
 * IGasPanel is used for GasPanel
 */
public interface IGasPanel {
    void setSpinnerChangeListener(ChangeListener listener);
    void setGasButtonActionListener(ActionListener listener);
    void setBrakeButtonActionListener(ActionListener listener);
}
