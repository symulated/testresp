import java.util.*;
import java.io.*;
import java.util.Scanner;
public class OrderedListDemo {
    public static void main(String[]args) throws IOException{
        Scanner kb=new Scanner(System.in);
        System.out.println("Enter the name of the first file you would like to read from : ");
        String filename=kb.nextLine();
        System.out.println("Enter the name of the second file you would like to read from: ");
        String filename2=kb.nextLine();

        File file1=new File(filename);
        File file2=new File(filename2);

        Scanner inputFile1=new Scanner(file1);
        Scanner inputFile2=new Scanner(file2);

        OrderedList<String> nameList1=new OrderedList<String>();
        OrderedList<String> nameList2=new OrderedList<String>();

        while (inputFile1.hasNext()){
            String name=inputFile1.next();
            nameList1.add(name);
        }
        while (inputFile2.hasNext()){
            String name=inputFile2.next();
            nameList2.add(name);
        }
        inputFile1.close();
        inputFile2.close();
        System.out.println(OrderedList.mergeLists(nameList1, nameList2));

        nameList1.enumerate();
        nameList2.enumerate();


    }
}
