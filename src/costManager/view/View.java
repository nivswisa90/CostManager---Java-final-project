package costManager.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View implements IView {
    //add a new cost members
    private JFrame addCostFrame;
    private JPanel addCostPanel;
    private JLabel categoryLabel, sumLabel, currencyLabel, dateLabel;
    private JTextField categoryField, sumField, currencyField, dateField;
    private JButton submitCostButton;

    public View() {
        addCostFrame = new JFrame("Add a new cost");
        addCostPanel = new JPanel();
        categoryLabel = new JLabel("Choose category");
        sumLabel = new JLabel("Insert the amount");
        currencyLabel = new JLabel("Choose the currency");
        dateLabel = new JLabel("Select the date");
        categoryField = new JTextField();
        sumField = new JTextField();
        currencyField = new JTextField();
        dateField = new JTextField();
        submitCostButton = new JButton("Submit");

    }



    @Override
    public void displayAddCostItem() {
        addCostPanel.setBackground(Color.YELLOW);
        addCostFrame.setLayout(new BorderLayout());
        addCostPanel.setLayout(new GridLayout(5,2));

        addCostPanel.add(categoryLabel);
        addCostPanel.add(categoryField);
        addCostFrame.add(addCostPanel);
        addCostPanel.add(sumLabel);
        addCostPanel.add(sumField);
        addCostPanel.add(currencyLabel);
        addCostPanel.add(currencyField);
        addCostPanel.add(dateLabel);
        addCostPanel.add(dateField);
        addCostPanel.add(submitCostButton);

        addCostFrame.setSize(800,400);
        addCostFrame.setVisible(true);

        addCostFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void displayAddNewCategory() {

    }

    @Override
    public void displayGetCostReport() {

    }
}
