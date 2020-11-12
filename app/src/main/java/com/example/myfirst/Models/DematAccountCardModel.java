package com.example.myfirst.Models;

public class DematAccountCardModel {

    private String companyName;
    private int companyLogoResource;
    private int accountTitleResource;
    private boolean featured;
    private float ratingNumber;
    private String dematParentPage;



    public DematAccountCardModel(String companyName, int companyLogoResource, int accountTitleResource, boolean featured, float ratingNumber, String dematParentPage) {
        this.companyName = companyName;
        this.companyLogoResource = companyLogoResource;
        this.accountTitleResource = accountTitleResource;
        this.featured = featured;
        this.ratingNumber = ratingNumber;
        this.dematParentPage = dematParentPage;
    }

    public String getDematParentPage() {
        return dematParentPage;
    }

    public void setDematParentPage(String dematParentPage) {
        this.dematParentPage = dematParentPage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyLogoResource() {
        return companyLogoResource;
    }

    public void setCompanyLogoResource(int companyLogoResource) {
        this.companyLogoResource = companyLogoResource;
    }

    public int getAccountTitleResource() {
        return accountTitleResource;
    }

    public void setAccountTitleResource(int accountTitleResource) {
        this.accountTitleResource = accountTitleResource;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public float getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(float ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
}
