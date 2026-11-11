import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // reading input: provided for you
        Product[] products = new Product[10];  // an array with room for 10 products
        int count = 0;                         // how many products are stored so far
        int choice;
        do {
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();   // clears the leftover newline after nextInt()
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, try again.");
            }
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if(count==products.length){
                        System.out.print("You can't add the products ");
                    }
                    else if(price<=0||quantity<0) {
                        System.out.print("price and quantity can't be zero");
                    }
                    else {
                        Product p1=new Product(name,price,quantity);
                        products[count] = p1;
                        count++;
                        System.out.print(" product added succesfully ");
                    }
                    break;
                case 2:
                    if(count==0){
                        System.out.println("No products");
                    }
                    for(int i=0;i<count;i++){
                        System.out.print((i+1) +".");
                        products[i].display();
                    }
                    break;
                case 3:
                    if(count==0){
                        System.out.println("No products");
                    }
                    else{
                        double totalstockvalue= 0;
                        for(int i=0;i<count;i++){
                            totalstockvalue+= products[i].stockValue();
                        }
                        System.out.println("Total stock value" + totalstockvalue);
                    }
                    break;

                case 4:
                    double avgprice;
                    double totalstockvalue = 0;
                    if(count==0){
                        System.out.println(" No products available");
                    }
                    for(int i=0;i<count;i++) {
                        totalstockvalue += products[i].stockValue();
                    }
                        avgprice = totalstockvalue / count;
                        System.out.println(avgprice);
                        System.out.println((int)avgprice);
                    break;
                case 5:
                    System.out.print("Product number: ");
                    int num = sc.nextInt();
                    System.out.println("Quantity to add: ");
                    int extra = sc.nextInt();
                    sc.nextLine();
                    if(num==0 || num>count||extra<=0){
                        System.out.println("Invalid product number or quantity");
                    }
                    else {
                        products[num - 1].quantity += extra;
                        System.out.println("product restocked successfully ");
                        System.out.println("updated quantity:" + products[num - 1].quantity);
                    }
                    break;
                case 6:
                    System.out.print("Product number: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    if(n<1 || n>count)
                    {
                        System.out.print("Invalid product number");
                    }
                    else if(count==products.length){
                        System.out.print("Product array is full");
                    }
                    else{
                        products[count]= new Product(products[n-1]);
                        count++;
                        System.out.println("Product number copied successfully");

                        System.out.println("Product after duplication");
                        for(int i=0;i<count;i++){
                            System.out.println((i+1) +".");
                            products[i].display();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice != 0);
        System.out.println("Products created in total: " + Product.totalProducts);
    }
}








