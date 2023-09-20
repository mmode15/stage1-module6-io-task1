package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    private  String getStringValueFromFile(File file) {
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

    public  Profile getDataFromFile(File file) {
        String str = getStringValueFromFile(file);
        String[] strArr = str.split("\n");
        String[] values = new String[4];

        for (int i = 0; i < strArr.length; i++) {
            String[] k = strArr[i].split(" ");
            values[i] = k[1];
        }


        return new Profile(values[0], Integer.parseInt(values[1]), values[2], Long.valueOf(values[3]));
    }


}
