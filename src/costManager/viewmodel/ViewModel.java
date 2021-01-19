package costManager.viewmodel;

import costManager.model.Category;
import costManager.model.CostItem;
import costManager.model.CostManagerException;
import costManager.model.IModel;
import costManager.view.IView;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ViewModel implements IViewModel {

    private IModel model;
    private IView view;
    private ExecutorService pool;

    public ViewModel() {
        pool = Executors.newFixedThreadPool(10);
    }

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public void addCostItem(CostItem item) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    model.addCostItem(item);
                    view.showMessage("Cost item added successfully!!");
                    CostItem[] items = model.getCostItems();
                    view.showItems(items);
                } catch (CostManagerException e) {
                    view.showMessage((e.getMessage()));
                }
            }
        });
    }

    @Override
    public List<String> getCategoryList() {
        List<String> categories = null;
        try {
            categories = model.getCategoryList();
        } catch (CostManagerException e) {
            e.printStackTrace();
        }
        finally {
            return categories;
        }
    }
}

