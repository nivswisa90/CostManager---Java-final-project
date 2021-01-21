package costManager.view;


import costManager.model.CostItem;
import costManager.viewmodel.IViewModel;
import org.jfree.chart.JFreeChart;

public interface IView {
    /**
     * Display the GUI for add a new cost item layout
     */
//    public void displayAddCostItem();
    /**
     * Display the GUI for add a new category layout
     */
//    public void displayAddNewCategory();
    /**
     * Display the GUI for get the selected report(pie, regular report)
     */
//    public void displayGetCostReport();
    //    public void displayPieChart(Map map);
    public void showMessage(String text);
    public void showItems(CostItem[] vec);
    public void setViewModel(IViewModel vm);
//    public void showCategories(String category);
}
