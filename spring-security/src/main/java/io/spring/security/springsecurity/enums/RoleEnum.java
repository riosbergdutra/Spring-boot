package io.spring.security.springsecurity.enums;

public enum RoleEnum {
    ADMIN("admin"),
    USER("user"),;

    private String role;
    
    RoleEnum(String role) {
        role = this.role;
    }
}
