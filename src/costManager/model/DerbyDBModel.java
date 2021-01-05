package costManager.model;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DerbyDBModel implements IModel {
    /**
     * DataBase model using DerbyDB and implements the IModel interface, create embedded connection to the DB,
     * creates a DB called gagamoDB at the end close the connections.
     */
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:gagamoDB;create=true";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet rs = null;



    public void createConnection() throws CostManagerException {
        /**
         * using the Driver and trying to connect and create the data base,
         * if fail exception will be catch and throws error of the cost manager exception class.
         */
        try {
            Class.forName(driver);
            //getting connection by calling get connection
            connection = DriverManager.getConnection(protocol);
            statement = connection.createStatement();

        }
        catch(SQLException | ClassNotFoundException e) {
            throw new CostManagerException("Problem with the connection",e);
        }
    }

    public void stopConnection() throws CostManagerException {
        /**
         * At end of using the connection, trying to close statement and the result set,
         * if fail thrown exception of cost manager exception class.
         */
        if(statement != null) try{
            statement.close();
        }catch (SQLException e){
            throw new CostManagerException("Problem with closing statement!",e);
        }
        if(rs != null) try {
            rs.close();
        }
        catch (SQLException e){
            throw new CostManagerException("Problem with closing result", e);
        }
    }

    public void createTable(String tableName, String columns) throws CostManagerException {
        /**
         * Using just at the beginning, creates a table with name and information.
         * if table created successfully enters 3 default categories to a defined table;
         * happens only once!.
         */

        createConnection();
        String query = "CREATE table " + tableName + " " + columns;
        try{
            statement.execute(query);
            if(tableName.equals("categories")) {
                addNewCategory(new Category(1,"Water"));
                addNewCategory(new Category(2, "Electricity"));
                addNewCategory(new Category(3,"Arnona"));
            }
            System.out.println("Table " + tableName + " created successfully");
        }catch(SQLException e) {
            throw new CostManagerException("Problem with creation a table!",e);
        }
        stopConnection();
    }

    public List<Category> getCategoryList() throws CostManagerException {
        /**
         * Using SQL query to get all the categories from the table , enter them to a new list and returns it.
         */

        createConnection();
        List<Category> categoryList = new ArrayList<Category>();

        try{
            String query = "SELECT * FROM categories";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Category category = new Category(rs.getInt("id"),rs.getString("name"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new CostManagerException("Problem with add category to the list");
        }
        stopConnection();
        return categoryList;
    }

    public void deleteTable(String tableName) throws CostManagerException {
        /**
         * help function, if we want to change the table and delete.
         */
        createConnection();
        String query = "DROP table " + tableName;
        try {
            statement.execute(query);
            System.out.println("Deleted table " + tableName);
        }catch(SQLException e) {
            throw new CostManagerException("Problem with adding cost!",e);
        }
        stopConnection();
    }

    @Override
    public void addCostItem(CostItem item) throws CostManagerException {
        /**
         * Using query to add values into fixed table of cost items,
         * first making prepared statements and then safely enter each value to his place,
         * then execute the statement and if thrown exception it will be catch by our costmangerexception class.
         */

        createConnection();
        try{
            String query = "INSERT into inventory (categoryId,amount,currency,description,date) "
                    + "values (?,?,?,?,?)";
            String date = item.getDate();

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = formatter.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,item.getCategory().getId());
            preparedStmt.setDouble (2, item.getAmount());
            preparedStmt.setString  (3, item.getCurrency().name());
            preparedStmt.setString(4, item.getDescription());
            preparedStmt.setDate(5, sqlDate);

            // execute the prepared statement
            preparedStmt.execute();
        }
        catch(SQLException | ParseException e) {
            throw new CostManagerException("Problem with adding cost!",e);
        }
        stopConnection();
    }

    @Override
    public void deleteCostItem(CostItem item) throws CostManagerException {
        /**
         * Deleting from the table in the data base by using query , if fail exception will be catch.
         */
        createConnection();
        try{
            statement.executeUpdate("DELETE from inventory WHERE id=" + item.getId() + "");
        }
        catch(SQLException e) {
            throw new CostManagerException("Problem with deleting cost!",e);
        }
        stopConnection();
    }

    @Override
    public void addNewCategory(Category category) throws CostManagerException {
        /**
         * Making Prepared statement and enter his value safely to the table.
         *
         */
        createConnection();
        try{
            String query = "INSERT into categories (name) " + "values (?)";
            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1,category.getName());

            // execute the prepared statement
            preparedStmt.execute();
        }
        catch(SQLException e) {
            throw new CostManagerException("Problem with adding cost!",e);
        }
        stopConnection();
    }

    @Override
    public void getCostReport(String start, String end) throws CostManagerException {
        /**
         * Get all the cost between start date to end date, using the result set to output stream the data.
         * if fail throws exception.
         */
        createConnection();
        String query = "SELECT * FROM inventory WHERE Date between '" + start + "' and '" + end + "'";
        try {
            rs = statement.executeQuery(query);
            while(rs.next()) {
                System.out.println("id - " + rs.getInt("id") + " \nCategory - " +
                        rs.getInt("categoryId") + " \nAmount - " + rs.getDouble("amount") +
                        " \ncurrency - " + rs.getString("currency") +
                        " \nDescription - " + rs.getString("description") + " \nDate - " + rs.getDate("date"));
            }
        } catch (SQLException e) {
            throw new CostManagerException("Problem getting data from specified dates");
        }
        stopConnection();
    }

    @Override
    public void getPieChart(String start, String end) throws CostManagerException {
        /**
         * using jfreechart library to create image of pie chart with the relevant information,
         * inner join both tables inventory and category to get the name of the category,
         * between start and end dates,  the result (dataset) will be use  in the library function to create the pie chart.
         */
        createConnection();
        try{
            String joinQuery = "SELECT * FROM inventory INNER JOIN categories on categoryId=categories.id WHERE Date " +
                    "between '" + start + "' and '" + end + "'";
            rs = statement.executeQuery(joinQuery);
            DefaultPieDataset dataset = new DefaultPieDataset();
            while(rs.next()){
                dataset.setValue(rs.getString("name"),Double.parseDouble(rs.getString("amount")));
            }
            JFreeChart chart = ChartFactory.createPieChart("Category - amounts",dataset,true,true,false);
            int width = 560;
            int height = 370;
            File pieChart = new File("Pie_Chart.jpeg");
            ChartUtilities.saveChartAsJPEG(pieChart,chart,width,height);

        } catch (SQLException | IOException e) {
            throw new CostManagerException("Problem getting data from specified dates");
        }
        stopConnection();
    }
}


