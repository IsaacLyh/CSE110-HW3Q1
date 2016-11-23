class FulfillmentService {

  // These are just here to make things compilable, assume global in scope
  /*
	class Time {}
  class ShipperDetails{}
  class ServiceClass {}
  class CustomerID {}
  class ProductID {}
  */
 
  public FulfillmentService(ShipperDetails[] sd) {
    // Imagine more code here
  }

  
  private boolean doableETA(ServiceClass sc, CustomerID cid, Time eta) { 
    // Imagine more code here
    return true; 
  }

  
  public boolean fulfill (ProductID pid, CustomerID cid, ServiceClass sc, 
                          Time eta) { 
    if (!doableETA(sc,cid,eta)) return false;


    // Imagine more code here

    return true;
  }

  
}
