package org.example.ui;

import org.example.entity.ProfileEntity;
import org.example.util.ScannerUtil;

public class BookUi {
    public void start(ProfileEntity profile) {
        while (true){
            switch (menu()){
                case 1->addBook(profile);
            }
        }
    }

    private void addBook(ProfileEntity profile) {
        System.out.println("Book Saved");
    }

    private int menu() {
        System.out.print("""
                +------  MENU  ------+
                | 1 | Add Book       |
                | 2 | Show Book      |
                | 3 | Edit Book      |
                | 4 | Delete Book    |
                +--------------------+
                | 0 | Exit           |
                +--------------------+
                | Enter Option ->""");
        return ScannerUtil.SCANNER_NUM.nextInt();
    }
}
