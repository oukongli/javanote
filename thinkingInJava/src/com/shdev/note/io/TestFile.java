package com.shdev.note.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ou_ko on 2017/2/17.
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("note.txt");
        BufferedReader bufferedReader = null;
        try {
            long startTime = System.nanoTime();
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            int count = 0;
            Field field;
            List<Field> fieldList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String datas[] = line.split("\\|", -1);
                    if (datas.length == 4) {
                        if (datas[0].equals("1") && datas[1].equals("2") && datas[2].equals("3") && datas[3].trim().equals("4")) {
                            field = new Field();
                            field.setInfo_1(datas[0]);
                            field.setInfo_2(datas[1]);
                            field.setInfo_3(datas[2]);
                            field.setInfo_4(datas[3]);
                            addFieldToList(fieldList, field);
                            count++;
                        }
                    }
                }
            }
            System.out.println("time:" + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime));
            System.out.println("count:" + count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    private static void addFieldToList(List<Field> fieldList, Field field) {
        fieldList.add(field);
        if (fieldList.size() >= 10000000) {
            fieldList.clear();
            System.out.println("field.clear()");
        }
    }

    public static class Field {
        private String info_1;
        private String info_2;
        private String info_3;
        private String info_4;


        public Field() {
        }

        public Field(String info_1, String info_2, String info_3, String info_4) {
            this.info_1 = info_1;
            this.info_2 = info_2;
            this.info_3 = info_3;
            this.info_4 = info_4;
        }

        public String getInfo_1() {
            return info_1;
        }

        public void setInfo_1(String info_1) {
            this.info_1 = info_1;
        }

        public String getInfo_2() {
            return info_2;
        }

        public void setInfo_2(String info_2) {
            this.info_2 = info_2;
        }

        public String getInfo_3() {
            return info_3;
        }

        public void setInfo_3(String info_3) {
            this.info_3 = info_3;
        }

        public String getInfo_4() {
            return info_4;
        }

        public void setInfo_4(String info_4) {
            this.info_4 = info_4;
        }
    }
}
