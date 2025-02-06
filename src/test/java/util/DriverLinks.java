package util;


public enum DriverLinks {

    REGISTER_PAGE("https://parabank.parasoft.com/parabank/register.htm"),
    LOGIN_PAGE("https://parabank.parasoft.com/parabank/login");
    public static final String CHROME_DRIVER_PATH = "C:\\chromedriver.exe";

    private final String url;


    DriverLinks(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}