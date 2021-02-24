package Model;

import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public interface ICarView {
    void setGasButtonActionListener(ActionListener listener);
    void setBrakeButtonActionListener(ActionListener listener);
    void setStartButtonActionListener(ActionListener listener);
    void setStopButtonActionListener(ActionListener listener);
    void setTurboOnButtonActionListener(ActionListener listener);
    void setTurboOffButtonActionListener(ActionListener listener);
    void setLiftBedButtonActionListener(ActionListener listener);
    void setLowerBedButtonActionListener(ActionListener listener);
    void setSpinnerChangeListener(ChangeListener listener);
}
