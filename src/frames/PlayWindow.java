package frames;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PlayWindow {
    private JFrame frame;

    public PlayWindow(String streamName) {
        EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();

        frame = new JFrame();
        frame.setContentPane(component);
        frame.setBounds(200,200,800,600);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                component.release();
            }
        });
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        component.mediaPlayer().media().play("rtsp://127.0.0.1:8554/" + streamName);
    }
}
