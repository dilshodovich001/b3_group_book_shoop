package org.example.ui;

import org.example.controller.ProfileController;
import org.example.dto.ProfileRequest;
import org.example.entity.ProfileEntity;
import org.example.enums.ProfileRole;
import org.example.util.ScannerUtil;

public class ProfileUi {
    private final BookUi bookUi = new BookUi();
    private final GenreUi genreUi = new GenreUi();
    private final RegionUi regionUi = new RegionUi();
    private final ProfileController profileController = new ProfileController();

    public void login(String phone, String password) {
        ProfileEntity profile = profileController.login(phone, password);
        if (profile.getRole().equals(ProfileRole.ADMIN)) {
            adminStart(profile);
        } else if (profile.getRole().equals(ProfileRole.USER)) {
            userStart(profile);
        }
    }

    private void userStart(ProfileEntity profile) {
        System.out.println("User menu");
    }

    public String register(ProfileRequest request) {
        return profileController.register(request);
    }

    private int menu() {
        System.out.print("""
                +------  MENU  ------+
                | 1 | Book Section   |
                | 2 | Genre Section  |
                | 3 | Region Section |
                | 4 | Show Profiles  |
                | 5 | Sale History   |
                +--------------------+
                | 0 | Exit           |
                +--------------------+
                | Enter Option ->""");
        return ScannerUtil.SCANNER_NUM.nextInt();
    }

    private void adminStart(ProfileEntity profile) {
       while (true) {
            switch (menu()) {
                case 1 -> bookUi.start(profile);
                case 2 -> genreUi.start();
                case 3 -> regionUi.start();
                case 0 -> {
                    return;
                }
            }
        }
    }
}
