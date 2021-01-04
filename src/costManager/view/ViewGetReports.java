package costManager.view;

import javax.swing.*;
import java.awt.*;

public class ViewGetReports {
    //get reports members
    private JPanel getReportPanel;
    private JLabel initialDateLabel, endDateLabel;
    private JTextField initialDateField, endDateField;
    private JButton pieButton, reportButton;
    
    public ViewGetReports() {
        //get reports Panel
        getReportPanel = new JPanel();
        initialDateLabel = new JLabel("Choose initial date");
        initialDateField = new JTextField();
        endDateLabel = new JLabel("Choose end date");
        endDateField = new JTextField();
        pieButton = new JButton("Pie");
        reportButton = new JButton("Report");
    }
    
    public JPanel addToGetReportsPanel() {
        getReportPanel.setBackground(Color.orange);
        getReportPanel.setLayout(new GridLayout(2,2));

        getReportPanel.add(initialDateLabel);
        getReportPanel.add(initialDateField);
        getReportPanel.add(endDateLabel);
        getReportPanel.add(endDateField);
        getReportPanel.add(pieButton);
        getReportPanel.add(reportButton);
        
        return getReportPanel;
    }
}
