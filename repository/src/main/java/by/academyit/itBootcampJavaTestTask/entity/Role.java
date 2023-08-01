package by.academyit.itBootcampJavaTestTask.entity;

public enum Role {
    ADMINISTRATOR("Administrator"),
    SALE_USER("Sale User"),
    CUSTOMER_USER("Customer User"),
    SECURE_API_USER("Secure API User");
    private final String code;

    Role(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
