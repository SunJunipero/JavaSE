package com.relations.example;

import java.util.Date;

public class IdCard {
    private Integer number;
    private Date dateExpire;

    public IdCard(Integer number){
        this.number = number;
    }

    public IdCard(Integer number, Date dateExpire) {
        this.number = number;
        this.dateExpire = dateExpire;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }
}
