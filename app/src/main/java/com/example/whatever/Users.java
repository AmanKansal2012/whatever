package com.example.whatever;

public class Users {
    String Domain,Name;

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Users() {
    }

    public Users(String domain, String name) {
        Domain = domain;
        Name = name;
    }
}
