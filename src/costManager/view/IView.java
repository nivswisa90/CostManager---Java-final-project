package costManager.view;


public interface IView {
    /**
     * Display the GUI for add a new cost item layout
     */
    public void displayAddCostItem();
    /**
     * Display the GUI for add a new category layout
     */
    public void displayAddNewCategory();
    /**
     * Display the GUI for get the selected report(pie, regular report)
     */
    public void displayGetCostReport();
    //    public void displayPieChart(Map map);
}
