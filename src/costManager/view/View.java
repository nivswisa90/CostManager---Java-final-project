package costManager.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View implements IView {
    /**
     * main page members
     */
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel mainCostLabel, mainCategoryLabel, mainReportLabel;
    private JButton mainCostButton, mainCategoryButton, mainReportButton;


    /**
     * View class constructor
     */
    public View() {
        frame = new JFrame("Cost Manager");
        mainPanel = new JPanel();
        mainCostLabel = new JLabel("Add a new cost");
        mainCategoryLabel = new JLabel("Add a new category");
        mainReportLabel = new JLabel("Get cost reports");
        mainCostButton = new JButton("Go");
        mainCategoryButton = new JButton("Go");
        mainReportButton = new JButton("Go");
    }


    /**
     *  Initialize every member of the main page
     */
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

        /**
         * Clicking the main cost button display the add new cost item layout
         */
        mainCostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayAddCostItem();
            }
        });
        /**
         * Clicking the main category button display the add new category layout
         */
        mainCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayAddNewCategory();
            }
        });

        /**
         * Clicking the main report button display the get reports layout
         */
        mainReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayGetCostReport();
            }
        });
        /**
         * Clicking the x button of the window the program is exit with status 0
         */
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void displayAddCostItem() {
        ViewCostItem costItem = new ViewCostItem();
        frame.add(costItem.addFieldsToPanel());
    }

    @Override
    public void displayAddNewCategory() {
        ViewNewCategory newCategory = new ViewNewCategory();
        frame.add(newCategory.addToCategoryPanel());
    }

    @Override
    public void displayGetCostReport() {
        ViewGetReports reports = new ViewGetReports();
        frame.add(reports.addToGetReportsPanel(), BorderLayout.CENTER);
        frame.add(reports.buttons(), BorderLayout.SOUTH);
    }
}
