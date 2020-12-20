package costManager.model;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws CostManagerException {
        DerbyDBModel model = new DerbyDBModel();

        try {
            model.createConnection();
//            model.deleteTable("categories");
//            model.createTable("categories", "(id int generated always as identity PRIMARY KEY , name varchar(256))");
//            model.createTable("inventory", "(id int generated always as identity PRIMARY KEY,categoryId int,amount double, " +
//                    "currency varchar(250),description varchar(250),date DATE, FOREIGN KEY (categoryId) REFERENCES categories(id))");


//            Category cat = new Category(4,"Shopping");
//            model.addNewCategory(cat);
            List<Category> categoryList = model.getCategoryList();
//            for(int i = 0; i<categoryList.size(); i++) {
//                System.out.println(categoryList.get(i));
//            }
//            CostItem item = new CostItem(15, categoryList.get(0),14.33, Currency.EURO,"test4","2021-12-03");
//            model.addCostItem(item);
            model.getCostReport("2020-12-01", "2020-12-31");

        }catch (CostManagerException e) {
            throw new CostManagerException("cant", e);
        }
        finally {
            try {
                model.stopConnection();
            }catch (CostManagerException e){
                throw new CostManagerException("Error closing connection");
            }
        }







//           CostItem item = new CostItem(5,"Arnona", 99.6, Currency.GBP, "Third cost", "2020-12-16");
//           model.addCostItem(item);
//            model.deleteCostItem(item);
//            model.createTable("inventory","(id int PRIMARY KEY,category varchar(256),amount double, currency varchar(250),description varchar(250),date varchar(256))");
//            model.createTable("category", "(id int PRIMARY KEY , name varchar(256))");
//            model.addNewCategory(4, "Test2");
//            model.deleteTable("category");

//            model.getId("inventory");

    }
}
