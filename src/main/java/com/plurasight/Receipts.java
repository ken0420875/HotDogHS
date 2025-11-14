package com.plurasight;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipts {public static void saveReceipt(Order order) {
    try {
        // Create receipts folder if it doesn't exist
        File receiptsDir = new File("receipts");
        if (!receiptsDir.exists()) {
            receiptsDir.mkdir();
        }

        // Generate a clean timestamp (NO slashes)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String timestamp = dateFormat.format(new Date());
        String filename = "receipts/" + timestamp + ".txt";

        // Write receipt content
        FileWriter writer = new FileWriter(filename);

        writer.write("KEN'S FULL FRANKS\n\n");
        writer.write(order.getReceiptText()); // you already have this method

        writer.close();

        System.out.println("Receipt saved to: " + filename);

    } catch (Exception e) {
        System.out.println("Error saving receipt: " + e.getMessage());
    }
}
}

