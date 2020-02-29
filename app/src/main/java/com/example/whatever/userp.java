package com.example.whatever;



public class userp {
    String Disease,Name,Prescribtion,history;

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrescribtion() {
        return Prescribtion;
    }

    public void setPrescribtion(String prescribtion) {
        Prescribtion = prescribtion;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public userp() {
    }

    public userp(String disease, String name, String prescribtion, String history) {
        Disease = disease;
        Name = name;
        Prescribtion = prescribtion;
        this.history = history;
    }
}
