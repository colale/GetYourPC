package find_pc.bean;

import java.io.Serializable;

public class UserBudgetBean implements Serializable {
    private int range;
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }
}
