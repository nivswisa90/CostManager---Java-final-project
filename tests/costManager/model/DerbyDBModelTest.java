//package costManager.model;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import costManager.model.*;
//
//public class DerbyDBModelTest {
//
//    private DerbyDBModel model = new DerbyDBModel();
//    CostItem item;
//    Category cat;
//    @Before
//    public void setUp() throws Exception {
//        model.createConnection();
//        cat = new Category(1,"Water");
//        item = new CostItem(10, cat,45.5, Currency.ILS,"Salary","2020-02-20");
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        cat = null;
//        item = null;
//        model.stopConnection();
//    }
//
//    @Test
//    public void addCostItem() throws CostManagerException {
//        String expected = "Problem with adding cost!";
//        assertEquals(expected, model.addCostItem(),null);
//    }
//
//    @Test
//    public void deleteCostItem() {
//    }
//
//    @Test
//    public void addNewCategory() {
//    }
//
//    @Test
//    public void getCostReport() {
//    }
//
//    @Test
//    public void getPieChart() {
//    }
//}