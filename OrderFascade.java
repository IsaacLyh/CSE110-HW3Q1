



class OrderFascade {
  // These are just here to make things compilable, assume global in scope
/*
	class Time {}
	class ServiceClass {}
	class CustomerID {}
	class ProductID {}
*/
  /*
   * Please implement this class. It should use the Fascade pattern
   * to incorporate the process of ordering behind a simpler 
   * interface via the OrderFascade.
   * 
   * Please complete this class in a sensible way. 
   */
    public static void orderStuff(
        	Time time,
        	ServiceClass serviceClass,
        	CustomerID ID,
        	ProductID Product,
        	ShipperDetails[] sd
    		){
    	//prompt user to enter necessary info to create different details for order;
    	
        InventoryService inventory = new InventoryService();
        FulfillmentService fullfill = new FulfillmentService(sd);
        CustomerRecordService record = new CustomerRecordService();
        
        if(inventory.sellFromInventory(Product)){
            System.out.println("Product Available");
            if(fullfill.fulfill (Product, ID, serviceClass,time)){
                record.recordOrder(time, serviceClass, ID,Product);
            }
            else{
                System.out.println("Unable to Fullfill at Time Requested");
            }
        }
        else{
            System.out.println("Sold Out");
        }
        
    }
    
    public static void main(String[] args){
    	Time time = new Time();
    	ServiceClass serviceClass = null;
    	CustomerID ID = null;
    	ProductID Product = null;
    	ShipperDetails[] sd = null;
    	orderStuff(time, serviceClass, ID, Product, sd);
    }
}
