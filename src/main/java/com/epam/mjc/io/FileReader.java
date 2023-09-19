package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    private String getStringValueFromFile(File file){
        String str = "";
        try (InputStream input = new FileInputStream(file.getAbsolutePath())) {
            int c;
            while ((c = input.read()) != -1) {
                str += (char) c;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
    public Profile getDataFromFile(File file) {
        String str = getStringValueFromFile(file);
        String[] strArr = str.split("\n");
        String name = "";
        Integer age = 0;
        String email = "";
        Long phone = 0L;

        for (int i = 0; i < strArr.length; i++) {
            String[] k = strArr[i].split(" ");
            switch (i) {
                case 0:
                    name = k[1];
                    break;
                case 1:
                    age = Integer.parseInt(k[1]);
                    break;
                case 2:
                    email = k[1];
                    break;
                case 3:
                    phone = Long.valueOf(k[1]);
                    break;
            }

        }

        return new Profile(name, age, email, phone);
    }


}
