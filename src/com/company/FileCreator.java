package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileCreator extends Thread {
    private String message;

    public FileCreator(String message) {
        this.message = message;
    }

    @Override
    public void run() {

        String fileName = String.format("TextFromConsole%d.txt", Main.counter.incrementAndGet());
        File file = new File(Main.path, fileName);

        try {
            OutputStream outputStream = new FileOutputStream(file);
            byte[] arr = message.getBytes();
            outputStream.write(arr);
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка при создании класса " + fileName);
        }
    }
}
