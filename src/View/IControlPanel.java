package View;

import java.awt.event.ActionListener;

public interface IControlPanel {
    void setStartButtonActionListener(ActionListener listener);
    void setStopButtonActionListener(ActionListener listener);
    void setTurboOnButtonActionListener(ActionListener listener);
    void setTurboOffButtonActionListener(ActionListener listener);
    void setLiftBedButtonActionListener(ActionListener listener);
    void setLowerBedButtonActionListener(ActionListener listener);
}
