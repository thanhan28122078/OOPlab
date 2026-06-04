package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store,"Add CD");
    }

    private class AddTracksToCompactDiscScreen extends AddItemToStoreScreen {
        private CompactDisc cd;
        private JLabel lblTrackNo;
        private JTextField tfTitle;
        private JTextField tfLength;
        private int screenIndex;
        private int numberOfTrack;
        JButton button = new JButton("Add");


        @Override
        protected JPanel createCenter() {
            JPanel center = new JPanel();
            center.setLayout(new GridLayout(3, 2, 2, 3));

            center.add(new JLabel("Enter the title : "));
            TextField tfTitle = new TextField(30);
            center.add(tfTitle);

            center.add(new JLabel("Enter the length : "));
            TextField tfLength = new TextField(30);
            center.add(tfLength);

            center.add(new JPanel());
            JButton button = new JButton("Add");
            button.setPreferredSize(new Dimension(80, 30));
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(button);

            center.add(buttonPanel);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String title = tfTitle.getText();
                    int length = 0;

                    try {
                        length = Integer.parseInt(tfLength.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Độ dài track phải là một số!", "Lỗi đầu vào", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Track track = new Track(title, length);

                    if (screenIndex >= numberOfTrack) {
                        JOptionPane.showMessageDialog(null, "CD đã đầy. Không thể thêm track mới.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        cd.addTrack(track);
                        JOptionPane.showMessageDialog(null, "Đã thêm track '" + title + "' vào CD.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                    }
                }
            });

            return center;
        }

        public AddTracksToCompactDiscScreen(Store store, CompactDisc cd, Integer numberOfTrack) {
            super(store, "Add Tracks");
            this.cd = cd;
            this.screenIndex = 0;
            this.numberOfTrack = numberOfTrack;
        }

        void reset() {
            screenIndex++;
            setVisible(true);
        }
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(8,2,2,3));

        center.add(new JLabel("Enter the title : "));
        TextField title = new TextField(30);
        center.add(title);

        center.add(new JLabel("Enter the category : "));
        TextField category = new TextField(30);
        center.add(category);

        center.add(new JLabel("Enter the director : "));
        TextField director = new TextField(30);
        center.add(director);

        center.add(new JLabel("Enter the length : "));
        TextField length = new TextField(30);
        center.add(length);

        center.add(new JLabel("Enter the cost : "));
        TextField cost = new TextField(30);
        center.add(cost);

        center.add(new JLabel("Enter the artist : "));
        TextField artist = new TextField(30);
        center.add(artist);

        center.add(new JLabel("Enter the number of Track : "));
        TextField numberOfTrack = new TextField(30);
        center.add(numberOfTrack);

        center.add(new JPanel());


        JButton button = new JButton("Add");
        button.setPreferredSize(new Dimension(80, 30));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button);

        center.add(buttonPanel);



        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CompactDisc cd = new CompactDisc(title.getText(), category.getText(),
                        director.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText()), artist.getText());
                store.addMedia(cd);
                AddCompactDiscToStoreScreen.this.dispose();
                AddTracksToCompactDiscScreen addTrackScreen = new AddTracksToCompactDiscScreen(store, cd, Integer.parseInt(numberOfTrack.getText()));
                Container cp = new Container();
                cp.add(createCenter(), BorderLayout.CENTER);
                cp.revalidate();
                director.setText("");
                length.setText("");
                title.setText("");
                category.setText("");
                cost.setText("");
            }
        });

        return center;
    }
    public static void main(String[] args) {
        Store store = new Store();
        new AddCompactDiscToStoreScreen(store);

    }

}
