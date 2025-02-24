package org.example.ui;

import org.example.controller.RegionController;
import org.example.dto.RegionRequest;
import org.example.dto.RegionResponse;
import org.example.enums.Language;
import org.example.util.ScannerUtil;

import java.util.List;

public class RegionUi {
    private final RegionController regionController = new RegionController();

    public void start() {
        while (true) {
            switch (menu()) {
                case 1 -> createRegion();
                case 2 -> updateRegion();
                case 3 -> readRegion();
                case 4 -> deleteRegion();
                case 5 -> showRegion();
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void showRegion() {
        System.out.print("Enter language (en/ru/uz):");
        String lang = ScannerUtil.SCANNER_STR.next().toLowerCase();
        List<RegionResponse> regionResponses = regionController.showRegion(Language.valueOf(lang));
        regionResponses.forEach(System.out::println);
    }

    private void deleteRegion() {

    }

    private void readRegion() {

    }

    private void updateRegion() {

    }

    private void createRegion() {
        System.out.print("Enter name uz: ");
        String nameUz = ScannerUtil.SCANNER_STR.next();
        System.out.print("Enter name ru: ");
        String nameRu = ScannerUtil.SCANNER_STR.next();
        System.out.print("Enter name en: ");
        String nameEn = ScannerUtil.SCANNER_STR.next();
        String response = regionController.createRegion(new RegionRequest(nameUz, nameRu, nameEn));
        System.out.println(response);
    }

    public int menu() {
        System.out.println("*****REGION*****");
        System.out.println("1.Region Create");
        System.out.println("2.Region Update");
        System.out.println("3.Region Read");
        System.out.println("4.Region Delete");
        System.out.println("5.Region List");
        System.out.println("0.Exit");
        System.out.print("Enter menu : ");
        return ScannerUtil.SCANNER_NUM.nextInt();
    }
}
