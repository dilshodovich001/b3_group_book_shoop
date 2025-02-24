package org.example.ui;

import org.example.util.ScannerUtil;

public class GenreUi {
    public void start() {
        while (true){
            switch (menu()){

            }
        }
    }

    public int menu() {
        System.out.println("*****GENRE*****");
        System.out.println("1.Genre Create");
        System.out.println("2.Genre Update");
        System.out.println("3.Genre Read");
        System.out.println("4.Genre Delete");
        System.out.println("0.Exit");
        System.out.print("Enter menu : ");
        return ScannerUtil.SCANNER_NUM.nextInt();
    }
}
