package application;

import entities.Product;
import entities.UsedProduct;
import entities.ImportedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);


        System.out.print("Enter the number of products: ");
        int numProd = scan.nextInt();

        List<Product> listProd = new ArrayList<>();

        for (int i = 1; i <= numProd; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char tag = scan.next().charAt(0);

            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();

            System.out.print("Price: ");
            Double price = scan.nextDouble();

            if (tag == 'c') {
                listProd.add(new Product(name, price));
            }else if (tag == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = pattern.parse(scan.next());
                listProd.add(new UsedProduct(name, price, manufactureDate));
            }else if (tag == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = scan.nextDouble();
                listProd.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product prod : listProd) {
            System.out.println(prod.priceTag());
        }

        scan.close();
    }
}
