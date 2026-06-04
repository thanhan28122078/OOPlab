package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    Store store;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        setTitle(title);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
    }

    public JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;

    }
    public JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");


        JMenuItem viewStore = new JMenuItem("View hust.soict.hedspi.test1.store");
        menu.add(viewStore);
        viewStore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AddItemToStoreScreen.this.dispose();
                new StoreManagerScreen(store);
            }
        });

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        smUpdateStore.add(addBookItem);
        addBookItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store);
            }
        });


        JMenuItem addCDItem = new JMenuItem("Add CD");
        smUpdateStore.add(addCDItem);
        addCDItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store);
            }
        });


        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVDItem);
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store);
            }
        });
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;

    }


    public JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        String dynamicFrameTitle = getTitle();

        JLabel titleLabel = new JLabel(dynamicFrameTitle); // Sử dụng tiêu đề động của JFrame

        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 20));
        titleLabel.setForeground(Color.RED);

        header.add(Box.createHorizontalGlue());
        header.add(titleLabel);
        header.add(Box.createHorizontalGlue());

        header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // (top, left, bottom, right)

        return header;
    }
    protected abstract JPanel createCenter();
}