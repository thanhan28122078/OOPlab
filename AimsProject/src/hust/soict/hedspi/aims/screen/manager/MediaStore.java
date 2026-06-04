package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = createPlayDialog(media);
                    dialog.setVisible(true);
                    dialog.setSize(300, 300);
                    dialog.pack();
                }
            });
            container.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    static JDialog createPlayDialog(Media media) {
        JDialog playDialog = new JDialog();
        playDialog.setTitle("Playing: " + media.getTitle());
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        playDialog.setModal(true);

        Container container = playDialog.getContentPane();
        container.setLayout(new BorderLayout(10, 10));
        ((JPanel) container).setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel;
        if (media instanceof DigitalVideoDisc dvd) {
            titleLabel = new JLabel("Playing DVD: " + dvd.getTitle());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            infoPanel.add(titleLabel);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            infoPanel.add(new JLabel("Length: " + dvd.getLength() + " min"));
        } else if (media instanceof CompactDisc cd) {
            titleLabel = new JLabel("Playing CD: " + cd.getTitle());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            infoPanel.add(titleLabel);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            infoPanel.add(new JLabel("Artist: " + cd.getArtist()));
            infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            infoPanel.add(new JLabel("Length: " + cd.getLength() + " min"));
        } else {
            infoPanel.add(new JLabel("Playing: " + media.getTitle()));
            infoPanel.add(new JLabel("Media type not specifically handled for detailed view."));
        }
        for(Component comp : infoPanel.getComponents()){
            if(comp instanceof JLabel){
                ((JLabel)comp).setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        }

        container.add(infoPanel, BorderLayout.CENTER);
        JButton stopButton = new JButton("Stop Playing");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playDialog.dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(stopButton);
        container.add(buttonPanel, BorderLayout.SOUTH);
        playDialog.pack();
        playDialog.setLocationRelativeTo(null);

        return playDialog;
    }

}