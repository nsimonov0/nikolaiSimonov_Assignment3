import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fakerGeneration {
    public static void generate() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter a file path for your csv");
        String filePath = myInput.nextLine();
        System.out.println("How many records would you like to generate?");
        String numRecords = myInput.nextLine();
        int numRecs = Integer.parseInt(numRecords);

        Faker faker = new Faker();

        PrintWriter mywriter = null;
        try {
            File myFile = new File(filePath);
            if (!myFile.exists()) {
                throw new FileNotFoundException("File not found :(");
            }
            mywriter = new PrintWriter(myFile);
        } catch
        (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (index <= numRecs) {
            String address = faker.address().streetAddress();
            String email = faker.internet().emailAddress();
            int quantity = faker.number().numberBetween(1,5);
            double price = faker.number().randomDouble(2,95,1300);
            int size = faker.number().numberBetween(4,18);

            String columnList = address + ',' + email + ',' + quantity + ',' + price + ',' + size;
            sb.append(columnList);
            sb.append('\n');
            index++;
        }
        mywriter.append(sb.toString());
        mywriter.close();
        System.out.println("done!");
    }
}
