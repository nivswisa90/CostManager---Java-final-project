package costManager.model;

import java.util.Date;

public interface IModel {
    public void addCostItem(CostItem item) throws CostManagerException;
    public void deleteCostItem(CostItem item) throws CostManagerException;
    public void addNewCategory(Category category) throws CostManagerException;
    public void getCostReport(Date start, Date end) throws CostManagerException;
    public void getPieChart(Date start, Date end) throws CostManagerException;// and the way it splits?????

}
