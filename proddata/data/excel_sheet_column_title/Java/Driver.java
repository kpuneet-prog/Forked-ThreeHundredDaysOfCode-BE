package excel_sheet_column_title.Java;

import java.io.*;
import java.util.*;

public class Driver {
    private static List<String> method(String filePath) {
        ArrayList<String> al = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;
            while ((str = buffer.readLine()) != null) {
                str.trim();
                str = str.replace("\"","");
                al.add(str);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println(drivercode() ? "Accepted" : "Wrong Answer");
    }

    static boolean drivercode() {
        String filePath = "proddata/data/excel_sheet_column_title/testcases.txt";
        List<String> al = method(filePath);

        int testcases = Integer.parseInt(al.remove(0));
        String out;
        int input1 = 0;

        boolean b = true;
        for (int i = 0; i < 2 * testcases; i++) {
            if (i % 2 == 0) {
                input1 = Integer.parseInt(al.get(i));
            } else {
                out = al.get(i);
                String user_out= user(input1);
                b = b & out.equals(user_out)  ? true : false;
                if (b == false) {
                    System.out.println("Test case");
                    System.out.println(input1);
                    System.out.println("Your output " + user_out);
                    System.out.println("Expected output " + out);
                    return b;
                }
            }
        }
        return b;
    }

    public static String user(int n) {
        excel_sheet_column_title.Java.Solution sol = new excel_sheet_column_title.Java.Solution();
        return sol.convertToTitle(n);
    }

}

