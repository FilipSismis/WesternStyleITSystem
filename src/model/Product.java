package model;

public class Product {

    private String productCode;
    private String name;
    private int minStock;
    private int currentStock;
    private Supplier supplier;
    private int id;

    public Product(String productCode, String name, int minStock, int currentStock, Supplier supplier){
        this.productCode = productCode;
        this.name = name;
        this.minStock = minStock;
        this.currentStock = currentStock;
        this.supplier = supplier;
    }
    
    public void setCurrentStock(int currentStock) {
    	this.currentStock = currentStock;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getCurrentStock() {
    	return this.currentStock;
    }
    
    public String getProductCode(){
        return this.productCode;
    }
    
    public int getId() {
    	return this.id;
    }

}