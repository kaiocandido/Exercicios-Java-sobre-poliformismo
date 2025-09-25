import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int number = sc.nextInt();

        List<Product> list = new ArrayList<>();


        for (int i =0; i < number; i++){
            System.out.println("Product #" + (i +1 ) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            String option = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (option.equals("c")){
                Product p = new Product(name, price);
                list.add(p);
            }else if(option.equals("u")){
                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));

            }else{
                System.out.print("Custom fee: ");
                double taxa = sc.nextDouble();
                list.add(new ImportedProduct(name, price, taxa));
            }
        }

        System.out.println("Price Tags");
        for (Product a : list){
            System.out.println(a.priceTag());
        }

        sc.close();

    }
}
