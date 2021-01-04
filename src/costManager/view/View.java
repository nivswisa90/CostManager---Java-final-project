package costManager.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View implements IView {
    //main members
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel mainCostLabel, mainCategoryLabel, mainReportLabel;
    private JButton mainCostButton, mainCategoryButton, mainReportButton;

    //add a new cost members
    private JFrame addCostFrame;
    private JPanel addCostPanel;
    private JLabel categoryLabel, sumLabel, currencyLabel, dateLabel;
    private JTextField categoryField, sumField, currencyField, dateField;
    private JButton submitCostButton;

    //add new category members


    public View() {
        //main panel
        frame = new JFrame("Cost Manager");
        mainPanel = new JPanel();
        mainCostLabel = new JLabel("Add a new cost");
        mainCategoryLabel = new JLabel("Add a new category");
        mainReportLabel = new JLabel("Get cost reports");
        mainCostButton = new JButton("Go");
        mainCategoryButton = new JButton("Go");
        mainReportButton = new JButton("Go");

        //add cost Panel
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

    public void init() {
        frame.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.CYAN);
        mainPanel.setLayout(new GridLayout(3,2));
        mainPanel.add(mainCostLabel);
        mainPanel.add(mainCostButton);
        mainPanel.add(mainCategoryLabel);
        mainPanel.add(mainCategoryButton);
        mainPanel.add(mainReportLabel);
        mainPanel.add(mainReportButton);

        frame.add(mainPanel);

        frame.setSize(800,400);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

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
