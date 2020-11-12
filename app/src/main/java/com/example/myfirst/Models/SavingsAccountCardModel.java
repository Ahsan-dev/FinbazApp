package com.example.myfirst.Models;

public class SavingsAccountCardModel {

    private String bankname;
    private int bankLogoResource;
    private int bankTitleResource;
    private boolean featured;
    private String ir;
    private String mb;
    private String aoc;
    private float ratingNumber;
    private String parentPage;




    public SavingsAccountCardModel(int bankLogoResource, int bankTitleResource, boolean featured, String ir, String mb, String aoc, float ratingNumber, String bankname,String parentPage) {
        this.bankLogoResource = bankLogoResource;
        this.bankTitleResource = bankTitleResource;
        this.featured = featured;
        this.ir = ir;
        this.mb = mb;
        this.aoc = aoc;
        this.ratingNumber = ratingNumber;
        this.bankname = bankname;
        this.parentPage = parentPage;
    }

    public String getParentPage() {
        return parentPage;
    }

    public void setParentPage(String parentPage) {
        this.parentPage = parentPage;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public int getBankLogoResource() {
        return bankLogoResource;
    }

    public void setBankLogoResource(int bankLogoResource) {
        this.bankLogoResource = bankLogoResource;
    }

    public int getBankTitleResource() {
        return bankTitleResource;
    }

    public void setBankTitleResource(int bankTitleResource) {
        this.bankTitleResource = bankTitleResource;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getIr() {
        return ir;
    }

    public void setIr(String ir) {
        this.ir = ir;
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb;
    }

    public String getAoc() {
        return aoc;
    }

    public void setAoc(String aoc) {
        this.aoc = aoc;
    }

    public float getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(float ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
}
