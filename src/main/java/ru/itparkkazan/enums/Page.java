package ru.itparkkazan.enums;

public enum Page {
    INDEX_PAGE("index.jsp"),
    REG_PAGE("/views/registration.jsp"),
    SUCCESS_REG_PAGE("/views/successRegClient.jsp"),
    AUTH_PAGE("/views/auth.jsp");

    private String page;

    Page(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public String toString() {
        return page;
    }

}
