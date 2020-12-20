package costManager.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import costManager.model.*;

public class DerbyDBModelTest {

    private DerbyDBModel model = new DerbyDBModel();
    CostItem item;
    Category cat;
    @Before
    public void setUp() throws Exception {
        model.createConnection();
        cat = new Category(1,"Water");
        item = new CostItem(10, cat,45.5, Currency.ILS,"Salary","2020-02-20");

    }

    @After
    public void tearDown() throws Exception {
        cat = null;
        item = null;
        model.stopConnection();
    }

    @Test
    public void addCostItem(){
        String expected = "Problem with adding cost!";
        try {
            model.addCostItem(item);
        } catch (CostManagerException e) {
            assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void deleteCostItem() {
    }

    @Test
    public void addNewCategory() {
        String expected = "Problem with adding cost!";
        try {
            model.addNewCategory(cat);
        } catch (CostManagerException e) {
            assertEquals(expected,e.getMessage());
        }
    }

    @Test
    public void getCostReport() {
    }

    @Test
    public void getPieChart() {
    }
}