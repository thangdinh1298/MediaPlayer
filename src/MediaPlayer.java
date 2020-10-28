import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MediaPlayer {
    public static void main(String[] args) {
//        EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();
//
//        JFrame frame = new JFrame();
//        frame.setContentPane(component);
//        frame.setBounds(200,200,800,600);
//
//        frame.addWindowListener(new WindowAdapter() {
//
//            @Override
//            public void windowClosing(WindowEvent windowEvent) {
//                component.release();
//                System.exit(0);
//            }
//        });
//        frame.setVisible(true);
//
//        component.mediaPlayer().media().play("rtsp://127.0.0.1:8554/stream");
        JFrame frame = new JFrame();
        frame.setContentPane(new M().getMainPanel());
        frame.setBounds(200,200,800,600);
        frame.setVisible(true);
    }
}
