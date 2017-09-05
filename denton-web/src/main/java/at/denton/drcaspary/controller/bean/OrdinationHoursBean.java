package at.denton.drcaspary.controller.bean;

/**
 *
 * @author mczirfusz
 */
public class OrdinationHoursBean {
    
    private String weekDay;
    private String hourFrom;
    private String hourTo;
    private String lunchTime;

    public OrdinationHoursBean(final String weekDay, final String hourFrom, final String hourTo, final String lunchTime) {
        this.weekDay = weekDay;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.lunchTime = lunchTime;
    }
    
    public String getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(final String hourFrom) {
        this.hourFrom = hourFrom;
    }

    public String getHourTo() {
        return hourTo;
    }

    public void setHourTo(final String hourTo) {
        this.hourTo = hourTo;
    }

    public String getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(final String lunchTime) {
        this.lunchTime = lunchTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(final String weekDay) {
        this.weekDay = weekDay;
    }
    
}
