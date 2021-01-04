package costManager.view;

import javax.swing.*;
import java.awt.*;

public class ViewNewCategory {
    //add new category members
    private JPanel addCategoryPanel;
    private JLabel addCategoryLabel;
    private JTextField addCategoryField;
    private JButton addCategoryButton;
    
    public ViewNewCategory() {
        //add category Panel
        addCategoryPanel = new JPanel();
        addCategoryLabel = new JLabel("Insert a new category");
        addCategoryField = new JTextField();
        addCategoryButton = new JButton("Add");
    }
    
    public JPanel addToCategoryPanel() {
        addCategoryPanel.setBackground(Color.GRAY);
        addCategoryPanel.setLayout(new GridLayout(2,1));

        addCategoryPanel.add(addCategoryLabel);
        addCategoryPanel.add(addCategoryField);
        addCategoryPanel.add(addCategoryButton);
        
        return addCategoryPanel;
    }
}
