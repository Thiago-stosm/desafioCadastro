package service;

import java.io.*;
import java.util.Scanner;

import static java.lang.IO.println;

public class FileService {

    public static void reader(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String line = "";
        while(true){
            if (line != null) {
               println(line);

            }else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();
    }

    public static void writer(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String line = "";
        Scanner sc = new Scanner(System.in);
        line = sc.nextLine();
        buffWrite.append(line + "\n");
        buffWrite.close();
    }
}
