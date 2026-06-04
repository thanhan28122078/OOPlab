package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
    }
    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4,2,2,2));
        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        center.add(new JLabel("Enter the title : "));
        TextField title = new TextField(20);
        center.add(title);

        center.add(new JLabel("Enter the category : "));
        TextField category = new TextField(20);
        center.add(category);

        center.add(new JLabel("Enter the cost : "));
        TextField cost = new TextField(20);
        center.add(cost);
        center.add(new JPanel());


        JButton button = new JButton("Add");
        button.setPreferredSize(new Dimension(80, 30));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(button);

        center.add(buttonPanel);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Book book = new Book(title.getText(), category.getText(), Float.parseFloat(cost.getText()));
                store.addMedia(book);
                Container cp = new Container();
                cp.add(createCenter(), BorderLayout.CENTER);
                cp.revalidate();
                title.setText("");
                category.setText("");
                cost.setText("");
            }
        });

        return center;
    }
    public static void main(String[] args) {
        Store store = new Store();
        new AddBookToStoreScreen(store);
    }

}