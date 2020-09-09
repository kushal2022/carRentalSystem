
// Interface
interface paymentGateway {
  public void employeePayment();
    public void standardPayment();
    public void loyaltyPayment();
}


class Client implements paymentGateway {
    String name;
    int id;
    int amount;

    Client(){

    }

    Client(String name, int id, int amount){
        this.name = name;
        this.id = id;
        this.amount = amount;
    }
    @Override
    public void employeePayment(){

    }
    @Override
    public void standardPayment(){

    }
    @Override
    public void loyaltyPayment(){
        
    }
}

class MyMainClass {
  public static void main(String[] args) {
    Client newClient1 = new Client("Standard", 1, 200);
    Client newClient2 = new Client("Loyalty", 1, 200);
    Client newClient3 = new Client("Staff", 1, 200);


    System.out.println("Federation Car Rental Payment Tracking System");
        System.out.println("=============================================");
        
        while(true){
            System.out.println("Select an option from the menu below:");
            System.out.println("1. Standard Payment");
            System.out.println("2. Loyalty Payment");
            System.out.println("3. Employee Payment");
            System.out.println("4. Display List of Clients");
            System.out.println("5. Generate Report To View Payments Received");
            System.out.println("6. Exit");
            
        }
  }
}
