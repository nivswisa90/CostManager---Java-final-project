package costManager.view;

import javax.swing.*;
import java.awt.*;

public class ViewCostItem {
    /**
     * view cost item members
     */
    private JPanel addCostPanel, submitPanel;
    private JLabel categoryLabel, sumLabel, currencyLabel, dateLabel;
    private JTextField categoryField, sumField, currencyField, dateField;
    private JButton submitCostButton, backButton;

    /**
     * view cost item constructor
     */

    public ViewCostItem() {
        addCostPanel = new JPanel();
        submitPanel = new JPanel();
        categoryLabel = new JLabel("Choose category");
        sumLabel = new JLabel("Insert the amount");
        currencyLabel = new JLabel("Choose the currency");
        dateLabel = new JLabel("Select the date");
        categoryField = new JTextField();
        sumField = new JTextField();
        currencyField = new JTextField();
        dateField = new JTextField();
        submitCostButton = new JButton("Submit");
        backButton = new JButton("Back");
    }

    /**
     * Prepares the add new cost panel
     * @return the cost item panel
     */
    public JPanel addFieldsToPanel() {
        addCostPanel.setBackground(Color.YELLOW);
        addCostPanel.setLayout(new GridLayout(5, 2));

        addCostPanel.add(categoryLabel);
        addCostPanel.add(categoryField);
        addCostPanel.add(sumLabel);
        addCostPanel.add(sumField);
        addCostPanel.add(currencyLabel);
        addCostPanel.add(currencyField);
        addCostPanel.add(dateLabel);
        addCostPanel.add(dateField);
        addCostPanel.add(backButton);
        addCostPanel.add(submitCostButton);
        
        return addCostPanel;
    }
    
    
}
