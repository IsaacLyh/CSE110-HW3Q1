



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
        
       //Check if the product is available in the inventory
        if(inventory.sellFromInventory(Product)){
            System.out.println("Product Available");
            //Check if the order can be fulfilled with these current settings
            if(fullfill.fulfill (Product, ID, serviceClass,time)){
                //The order can be fulfilled, so go ahead and record it
                record.recordOrder(time, serviceClass, ID,Product);
            }
            else{
                //The order cannot be fulfilled, so do not record it
                System.out.println("Unable to Fullfill at Time Requested");
            }
        }
        else{
            //Product is not available in the inventory
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
