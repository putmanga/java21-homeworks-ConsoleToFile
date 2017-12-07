package com.company;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger counter = new AtomicInteger(0);
    public static String path;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        getPathAndName();

        System.out.println("Введите строки:");
        String s = reader.readLine();
        while (!s.equals("-1")) {
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
