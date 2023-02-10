package find_pc.model;

public class UserRequest {
    private String distance;
    private String configChoice;
    private int budgetRange;
    private double latRequest;
    private double longRequest;
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getConfigChoice() {
        return configChoice;
    }

    public void setConfigChoice(String configChoice) {
        this.configChoice = configChoice;
    }

    public int getBudgetRange() {
        return budgetRange;
    }

    public void setBudgetRange(int budgetRange) {
        this.budgetRange = budgetRange;
    }

    public double getLatRequest() {
        return latRequest;
    }

    public void setLatRequest(double latRequest) {
        this.latRequest = latRequest;
    }

    public double getLongRequest() {
        return longRequest;
    }

    public void setLongRequest(double longRequest) {
        this.longRequest = longRequest;
    }

}
