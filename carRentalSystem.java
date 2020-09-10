import java.util.Scanner;
import java.util.*;







// Interface
interface PaymentGateway {
    public void processPayment();
    // public void showClientDetails();
}






class Client  {
    private String name;
    private double amount;
    private int id;

    Client(){

    }

    Client(int id, String name, double amount){
        this.name = name;
        this.id = id;
        this.amount = amount;
    }



    @Override
    public String toString() {
        return " " + id + " \t\t\t" + name + " \t\t\t" + amount +"\t\t\t" + discount_amount + " ";
    }
}







class StandardClient extends Client implements PaymentGateway{
    int discount_rate = 0;
    
    StandardClient(int id, String name, double amount){
        super(id, name, amount);
    }

    @Override
    public void processPayment(){
        discount_amount =  amount * discount_rate * 0.01; 
        amount = amount - discount_amount;
    }
}

class LoyaltyClient extends Client implements PaymentGateway{
    int discount_rate = 10;

    LoyaltyClient(int id, String name, double amount){
        super(id, name, amount);
    }

    @Override
    public void processPayment(){
        discount_amount =  amount * discount_rate * 0.01; 
        amount = amount - discount_amount;
    }

}

class StaffClient extends Client implements PaymentGateway{
    int discount_rate = 20;

    StaffClient(int id, String name, double amount){
        super(id, name, amount);
    }

    @Override
    public void processPayment(){
        discount_amount =  amount * discount_rate * 0.01; 
        amount = amount - discount_amount;
    }
}



class CarBookingService{
    public void processStandardClient(){
        
    }
}








class MyMainClass {
  public static void main(String[] args) {

    String name;
    double payment;
    int id = 3;

    Scanner myInput = new Scanner(System.in);



    ArrayList<StandardClient> arraylist_standard = new ArrayList<StandardClient>();
    ArrayList<LoyaltyClient> arraylist_loyalty = new ArrayList<LoyaltyClient>();
    ArrayList<StaffClient> arraylist_staff = new ArrayList<StaffClient>();

   

    StandardClient stdClient = new StandardClient(1, "kushal", 100);
    stdClient.processPayment();
    arraylist_standard.add(stdClient);

    LoyaltyClient ltyClient = new LoyaltyClient(2, "mohan", 180);
    ltyClient.processPayment();
    arraylist_loyalty.add(ltyClient);

    StaffClient stfClient = new StaffClient(3, "shyam", 200);
    stfClient.processPayment();
    arraylist_staff.add(stfClient);

    

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
        System.out.println("Enter your option:"); 
        int case_number = myInput.nextInt(); 

        switch(case_number){
              case 1:
                System.out.println("Client ID\t\t Name\t\t Total Amount\t\t Discount Amount");
                for(Client str: arraylist_standard){
                    System.out.println(str);
                }

                System.out.println("Enter ID of an existing client or  0 to enter a new one: ");
                int case_1_no = myInput.nextInt();
                if(case_1_no == 0){
                    myInput.nextLine();
                    System.out.println("Enter the name of Client: ");
                    name = myInput.nextLine();
                    System.out.println("Enter the amount of this payment: ");
                    payment = myInput.nextInt();
                    id = id + 1;
                    System.out.println("--Processing Standard Payment--");

                    StandardClient stdClient1 = new StandardClient(id, name, payment);
                    stdClient1.processPayment();
                    arraylist_standard.add(stdClient1);

                    System.out.println("...");
                    System.out.println("...");
                    System.out.println("Finished processing payment.");

                    break;
                }
                else{
                    for (StandardClient client :arraylist_standard ) {
                        if(client.id == case_1_no){
                           System.out.println("Enter the amount of this payment: ");
                           payment = myInput.nextInt();  

                           System.out.println("--Processing Standard Payment--");

                           double temp_amount_std = client.amount;
                           double temp_discount_amount_std = client.discount_amount;


                           client.amount = payment;

                           client.processPayment();

                           client.amount += temp_amount_std;
                           client.discount_amount += temp_discount_amount_std;

                           System.out.println("...");
                           System.out.println("...");
                           System.out.println("Finished processing payment.");
                        }
                    }

                    break;
                }
            case 2:
                System.out.println("Client ID\t\t Name\t\t Total Amount\t\t Discount Amount");
                for(Client str: arraylist_loyalty){
                    System.out.println(str);
                }
                
                System.out.println("Enter ID of an existing client or  0 to enter a new one: ");
                int case_2_no = myInput.nextInt();
                if(case_2_no == 0){
                    myInput.nextLine();
                    System.out.println("Enter the name of Client: ");
                    name = myInput.nextLine();
                    System.out.println("Enter the amount of this payment: ");
                    payment = myInput.nextInt();
                    id = id + 1;
                    System.out.println("--Processing Loyalty Payment--");

                    LoyaltyClient ltyClient1 = new LoyaltyClient(id, name, payment);
                    ltyClient1.processPayment();
                    arraylist_loyalty.add(ltyClient1);

                    System.out.println("...");
                    System.out.println("...");
                    System.out.println("Finished processing payment.");

                    break;
                }
                else{
                    for (LoyaltyClient client :arraylist_loyalty ) {
                        if(client.id == case_2_no){
                           System.out.println("Enter the amount of this payment: ");
                           payment = myInput.nextInt(); 

                           System.out.println("--Processing Loyalty Payment--"); 

                           double temp_amount_lty = client.amount;
                           double temp_discount_amount_lty = client.discount_amount;


                           client.amount = payment;

                           client.processPayment();

                           client.amount += temp_amount_lty;
                           client.discount_amount += temp_discount_amount_lty;


                           System.out.println("...");
                           System.out.println("...");
                           System.out.println("Finished processing payment.");
                        }
                    }

                    break;
                }
            case 3:
                System.out.println("Client ID\t\t Name\t\t Total Amount\t\t Discount Amount");
                for(Client str: arraylist_staff){
                    System.out.println(str);
                }
                
                System.out.println("Enter ID of an existing client or  0 to enter a new one: ");
                int case_3_no = myInput.nextInt();
                if(case_3_no == 0){
                    myInput.nextLine();
                    System.out.println("Enter the name of Client: ");
                    name = myInput.nextLine();
                    System.out.println("Enter the amount of this payment: ");
                    payment = myInput.nextInt();
                    id = id + 1;
                    System.out.println("--Processing Staff Payment--");


                    StaffClient stfClient1 = new StaffClient(id, name, payment);
                    stfClient1.processPayment();
                    arraylist_staff.add(stfClient1);

                    System.out.println("...");
                    System.out.println("...");
                    System.out.println("Finished processing payment.");

                    break;
                }
                else{
                    for (StaffClient client :arraylist_staff ) {
                        if(client.id == case_3_no){
                           System.out.println("Enter the amount of this payment: ");
                           payment = myInput.nextInt();  

                           System.out.println("--Processing Staff Payment--");

                           double temp_amount_stf = client.amount;
                           double temp_discount_amount_stf = client.discount_amount;


                           client.amount = payment;

                           client.processPayment();

                           client.amount += temp_amount_stf;
                           client.discount_amount += temp_discount_amount_stf;

                           System.out.println("...");
                           System.out.println("...");
                           System.out.println("Finished processing payment.");
                        }
                    }

                    break;
                }
            case 4:
                System.out.println("--List of Clients--");

                System.out.println("Client ID\t\t Name\t\t Total Amount\t\t     Discount Amount");
                System.out.println("Standard Clients:");
                
                for(Client str: arraylist_standard){
                    System.out.println(str);
                }

                System.out.println("Loyalty Clients:");
                
                for(Client str: arraylist_loyalty){
                    System.out.println(str);
                }

                System.out.println("Staff Clients:");
                
                for(Client str: arraylist_staff){
                    System.out.println(str);
                }

                break;

            case 5:
                System.out.println("--Report to View Payments Received--");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Type of Account\t\tTotal Amount Received\t\tDiscounts Given");
                System.out.println("--------------------------------------------------------------------------");
                double total_standard_amount = 0;
                double total_standard_discount = 0; 
                double total_loyalty_amount = 0;
                double total_loyalty_discount =0;
                double total_staff_amount = 0;
                double total_staff_discount = 0;
                double total_all_amount; 
                double total_all_discount;


                for (StandardClient client :arraylist_standard ) {
                    total_standard_amount += client.amount;
                    total_standard_discount += client.discount_amount;
                }
                for (LoyaltyClient client :arraylist_loyalty ) {
                    total_loyalty_amount += client.amount;
                    total_loyalty_discount += client.discount_amount;
                }
                for (StaffClient client :arraylist_staff ) {
                    total_staff_amount += client.amount;
                    total_staff_discount += client.discount_amount;
                }

                System.out.println("Standard\t\t" + total_standard_amount + "\t\t\t\t" + total_standard_discount);
                System.out.println("Loyalty\t\t\t" + total_loyalty_amount + "\t\t\t\t" + total_loyalty_discount);
                System.out.println("Staff\t\t\t" + total_staff_amount + "\t\t\t\t" + total_staff_discount);

                total_all_amount = total_standard_amount + total_loyalty_amount + total_staff_amount;
                total_all_discount = total_standard_discount + total_loyalty_discount + total_staff_discount;

                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Total\t\t\t" + total_all_amount + "\t\t\t\t" + total_all_discount);
                System.out.println("--------------------------------------------------------------------------");

                break;
            case 6:
                System.out.println("-- Exiting Federation Car Rental Payment Tracking System --");
                System.out.println("........");
                System.out.println(" -- Goodbye! --");
                System.exit(0); 
        } 
    }
  }
}
