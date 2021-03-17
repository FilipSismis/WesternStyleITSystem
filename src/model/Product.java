package model;

public class Product {

    private String productId;
    private String name;
    private int minStock;
    private int currentStock;
    private Supplier supplier;

    public Product(String productId, String name, int minStock, int currentStock){
        this.productId = productId;
        this.name = name;
        this.minStock = minStock;
        this.currentStock = currentStock;
    }
    public void setCurrentStock(int newCurrentStock) {
    	this.currentStock = newCurrentStock;
    }
    
    public int getCurrentStock() {
    return this.currentStock;
    }
    public String getProductionId(){
        return this.productId;
    }


}