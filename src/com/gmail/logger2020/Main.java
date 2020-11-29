package com.gmail.logger2020;

import java.io.*;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Через сканер выводим нужное нам значение

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите одно из значений: DEBUG, WARNING, ERROR)");
        String typeLog = sc.next();
        Date date = new Date();
        MessageLogs logs = MessageLogs.valueOf(MessageLogs.class, typeLog);
        /*System.out.println(logs +" - " +date);*/

        //Проверяем есть ли такой файл если нет создаем новый
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateText = dateFormat.format(date);
        File wr = new File(dateText + ".txt");
        if (!wr.exists()) {
            wr.createNewFile();
            System.out.println("Был создан новый файл");

        } else {
            System.out.println("Файл уже существует");
        }

        //Записываем данные в файл
        try {
            File fn = wr;
            FileWriter lg = new FileWriter(fn, true);
            lg.write(logs + " - " + date + "\n");
            lg.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Поиск файла в папке + считывание с текста
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите дату создания файла (пример 20.07.2020)");
        String search = sc1.next();
        {
            File directory = new File(".");
            MyFileNameFilter filter = new MyFileNameFilter(search);
            {
                String[] filtration = directory.list(filter);

                if (filtration == null) {
                    System.out.println("Файл не найден");
                } else {
                    for (int i = 0; i < filtration.length; i++) {
                        System.out.println(filtration[i] + " Файл существует");
                    }
                }
            }
        }
        File fn = wr;
        String text = loadFromFile(new File(String.valueOf(fn)));
        System.out.println(text);
    }

    public static String loadFromFile(File file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(file)) {
            for (; sc.hasNextLine(); ) {
                sb.append(sc.nextLine()).append(System.lineSeparator());

            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return sb.toString();


        //Сортировка


        // Поиск в файле

    }

}