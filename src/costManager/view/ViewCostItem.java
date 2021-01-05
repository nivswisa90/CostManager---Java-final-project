package costManager.view;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class ViewCostItem {
    /**
     * view cost item members
     */
    private JPanel addCostPanel, submitPanel;
    private JLabel categoryLabel, sumLabel, currencyLabel, dateLabel;
    private JTextField sumField;
    private JDatePickerImpl datePicker;
    private JComboBox categoryBox, currencyBox;
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
        //Temporary category array, in VM we would do it dynamic
        String categories[] = {"Arnona", "Electricity", "Water"};
        categoryBox = new JComboBox(categories);
        sumField = new JTextField();
        //Same that categories
        String currency[] = {"ILS", "USD", "EURO", "GBP"};
        currencyBox = new JComboBox(currency);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
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
        addCostPanel.add(categoryBox);
        addCostPanel.add(sumLabel);
        addCostPanel.add(sumField);
        addCostPanel.add(currencyLabel);
        addCostPanel.add(currencyBox);
        addCostPanel.add(dateLabel);
        addCostPanel.add(datePicker);
        addCostPanel.add(backButton);
        addCostPanel.add(submitCostButton);
        
        return addCostPanel;
    }

}

