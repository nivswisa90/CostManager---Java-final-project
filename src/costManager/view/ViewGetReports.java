package costManager.view;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class ViewGetReports {
    /**
     * view get reports members
     */
    private JPanel getReportPanel, buttonsPanel;
    private JLabel initialDateLabel, endDateLabel;
//    private JTextField initialDateField, endDateField;
    private JButton pieButton, reportButton, backButton;
    private JDatePickerImpl datePickerInitial, datePickerEnd;

    /**
     * view get reports constructor
     */
    public ViewGetReports() {
        getReportPanel = new JPanel();
        buttonsPanel = new JPanel();
        initialDateLabel = new JLabel("Choose initial date");
//        initialDateField = new JTextField();
        endDateLabel = new JLabel("Choose end date");
//        endDateField = new JTextField();
        pieButton = new JButton("Pie");
        reportButton = new JButton("Report");
        backButton = new JButton("Back");
        UtilDateModel modelInitial = new UtilDateModel();
        UtilDateModel modelEnd = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanelInitial = new JDatePanelImpl(modelInitial, p);
        JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd, p);
        datePickerInitial = new JDatePickerImpl(datePanelInitial, new DateLabelFormatter());
        datePickerEnd = new JDatePickerImpl(datePanelEnd, new DateLabelFormatter());
    }

    /**
     * Prepares the get reports panel
     * @return the reports panel
     */
    public JPanel addToGetReportsPanel() {
        getReportPanel.setBackground(Color.orange);
        getReportPanel.setLayout(new GridLayout(2,2));

        getReportPanel.add(initialDateLabel);
        getReportPanel.add(datePickerInitial);
        getReportPanel.add(endDateLabel);
        getReportPanel.add(datePickerEnd);
        

        return getReportPanel;
    }

    /**
     * Prepares the buttons panel for reports panel
     * @return the buttons panel for reports panel
     */
    public JPanel buttons() {
        buttonsPanel.setLayout(new GridLayout(1,3));
        buttonsPanel.add(backButton);
        buttonsPanel.add(pieButton);
        buttonsPanel.add(reportButton);
        
        return buttonsPanel;
    }
}
