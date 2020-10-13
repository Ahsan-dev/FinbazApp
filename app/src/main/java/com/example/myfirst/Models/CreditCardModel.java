package com.example.myfirst.Models;

public class CreditCardModel {

    private String cardName;
    private int cardLogoResource;
    private int cardTitleResource;
    private boolean featured;
    private float ratingNumber;
    private String fyf;
    private String rf;

    public CreditCardModel(String cardName, int cardLogoResource, int cardTitleResource, boolean featured, float ratingNumber, String fyf, String rf) {
        this.cardName = cardName;
        this.cardLogoResource = cardLogoResource;
        this.cardTitleResource = cardTitleResource;
        this.featured = featured;
        this.ratingNumber = ratingNumber;
        this.fyf = fyf;
        this.rf = rf;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardLogoResource() {
        return cardLogoResource;
    }

    public void setCardLogoResource(int cardLogoResource) {
        this.cardLogoResource = cardLogoResource;
    }

    public int getCardTitleResource() {
        return cardTitleResource;
    }

    public void setCardTitleResource(int cardTitleResource) {
        this.cardTitleResource = cardTitleResource;
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

    public String getFyf() {
        return fyf;
    }

    public void setFyf(String fyf) {
        this.fyf = fyf;
    }

    public String getRf() {
        return rf;
    }

    public void setRf(String rf) {
        this.rf = rf;
    }
}
