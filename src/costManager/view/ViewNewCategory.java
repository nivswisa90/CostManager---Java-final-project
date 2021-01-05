package costManager.view;

import javax.swing.*;
import java.awt.*;


public class ViewNewCategory {
    /**
     * view new category members
     */
    private JPanel addCategoryPanel;
    private JLabel addCategoryLabel;
    private JTextField addCategoryField;
    private JButton addCategoryButton, backButton;

    /**
     * view new category constructor
     */
    public ViewNewCategory() {
        addCategoryPanel = new JPanel();
        addCategoryLabel = new JLabel("Insert a new category");
        addCategoryField = new JTextField();
        addCategoryButton = new JButton("Add");
        backButton = new JButton("Back");
    }

    /**
     * Prepares the new category panel
     * @return the new category panel
     */
    public JPanel addToCategoryPanel() {
        addCategoryPanel.setBackground(Color.red);
        addCategoryPanel.setLayout(new GridLayout(2,2));

        addCategoryPanel.add(addCategoryLabel);
        addCategoryPanel.add(addCategoryField);
        addCategoryPanel.add(backButton);
        addCategoryPanel.add(addCategoryButton);

//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                addCategoryPanel.setVisible(false);
//                View view = new View();
//                view.init();
//            }
//        });

        return addCategoryPanel;
    }

}
