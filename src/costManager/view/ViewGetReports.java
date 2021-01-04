package costManager.view;

import javax.swing.*;
import java.awt.*;

public class ViewGetReports {
    /**
     * view get reports members
     */
    private JPanel getReportPanel, buttonsPanel;
    private JLabel initialDateLabel, endDateLabel;
    private JTextField initialDateField, endDateField;
    private JButton pieButton, reportButton, backButton;

    /**
     * view get reports constructor
     */
    public ViewGetReports() {
        getReportPanel = new JPanel();
        buttonsPanel = new JPanel();
        initialDateLabel = new JLabel("Choose initial date");
        initialDateField = new JTextField();
        endDateLabel = new JLabel("Choose end date");
        endDateField = new JTextField();
        pieButton = new JButton("Pie");
        reportButton = new JButton("Report");
        backButton = new JButton("Back");
    }

    /**
     * Prepares the get reports panel
     * @return the reports panel
     */
    public JPanel addToGetReportsPanel() {
        getReportPanel.setBackground(Color.orange);
        getReportPanel.setLayout(new GridLayout(2,2));

        getReportPanel.add(initialDateLabel);
        getReportPanel.add(initialDateField);
        getReportPanel.add(endDateLabel);
        getReportPanel.add(endDateField);
        

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
