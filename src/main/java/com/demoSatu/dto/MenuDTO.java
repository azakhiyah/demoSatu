package com.demoSatu.dto;

public class MenuDTO {
    private String menuName;
    private String menuDescription;

    public MenuDTO(String menuName, String menuDescription) {
        this.menuName = menuName;
        this.menuDescription = menuDescription;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return this.menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

}
