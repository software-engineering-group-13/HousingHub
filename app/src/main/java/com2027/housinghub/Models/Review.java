package com2027.housinghub.Models;

/**
 * Review class that holds the stars and comments on landlords
 */
public class Review {

    private String reviewId;
    private int stars;
    private String reviewTitle;
    private String reviewDescription;

    public Review(){

    }

    /**
     *
     * @param stars
     * @param reviewTitle
     * @param reviewDescription
     */
    public Review (int stars, String reviewTitle, String reviewDescription){
        this.stars =stars;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
