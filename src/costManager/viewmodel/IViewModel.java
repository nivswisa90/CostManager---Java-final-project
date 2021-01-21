package costManager.viewmodel;

import costManager.model.Category;
import costManager.model.CostItem;
import costManager.model.IModel;
import costManager.view.IView;
import org.jfree.chart.JFreeChart;

import java.util.List;

public interface IViewModel {
    public void setView(IView view);
    public void setModel(IModel model);
    public void addCostItem(CostItem item);
    public void getReport(String initDate, String endDate);
    public void addNewCategory(Category category);
    public List<String> getCategoryList();
    public JFreeChart getPieChart(String initDate, String endDate);
}
