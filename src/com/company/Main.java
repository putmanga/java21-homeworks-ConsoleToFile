package com.company;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger counter = new AtomicInteger(0);
    public static String path;
    //scanner would be enough
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        getPathAndName();

        System.out.println("Введите строки:");
        
        //you could assign a default value instead of starting the business logic outside of the "while" scope
        String s = reader.readLine();
        while (!s.equals("-1")) {
            //if "s" will get a default value - you'll be able to start reading before the thread and 
            //pass the read result to the thread
            new FileCreator(s).start();
            s = reader.readLine();
        }

        reader.close();
    }

    private static void getPathAndName() throws IOException {
        System.out.println("Введите адрес каталога для записи файлов:");
        path = reader.readLine();
        File dir = new File(path);
        while (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Некорректный ввод. Введите адрес каталога для записи файлов:");
            path = reader.readLine();
            dir = new File(path);
        }
    }
}
