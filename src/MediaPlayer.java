import frames.MainWindow;

import javax.swing.*;

public class MediaPlayer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new MainWindow().getMainPanel());
        frame.setBounds(200,200,800,600);
        frame.setVisible(true);
    }
}
