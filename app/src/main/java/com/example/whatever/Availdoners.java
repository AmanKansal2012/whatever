package com.example.whatever;


public class Availdoners {
    String Bloodgrp,Name,Number;

    public Availdoners() {
    }

    public String getBloodgrp() {
        return Bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        Bloodgrp = bloodgrp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public Availdoners(String bloodgrp, String name, String number) {
        Bloodgrp = bloodgrp;
        Name = name;
        Number = number;
    }
}
