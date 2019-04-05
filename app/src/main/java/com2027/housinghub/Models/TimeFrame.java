package com2027.housinghub.Models;

/**
 *
 */
public class TimeFrame {
    private DateHelper startDateHelper;
    private DateHelper endDateHelper;

    /**
     *
     * @param start
     * @param end
     */
    public TimeFrame(DateHelper start, DateHelper end){
        this.startDateHelper = start;
        this.endDateHelper = end;
    }

    /**
     *
     */
    public TimeFrame(){

    }

    public DateHelper getEndDateHelper() {
        return endDateHelper;
    }

    public void setEndDateHelper(DateHelper endDateHelper) {
        this.endDateHelper = endDateHelper;
    }

    public DateHelper getStartDateHelper() {
        return startDateHelper;
    }

    public void setStartDateHelper(DateHelper startDateHelper) {
        this.startDateHelper = startDateHelper;
    }


    //add a toString Here...
    @Override
    public String toString(){
        return startDateHelper.getMonthString() +" - " + endDateHelper.getMonthString();
    }
}
