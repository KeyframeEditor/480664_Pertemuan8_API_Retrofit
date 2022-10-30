package com.example.pertemuan8api.recyclerview;

public class ActivityData {
    private String activityName;
    private String activityType;
    private String activityDifficulty;

    public ActivityData(String activityName, String activityType, String activityDifficulty) {
        this.activityName = activityName;
        this.activityType = activityType;
        this.activityDifficulty = activityDifficulty;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityDifficulty() {
        return activityDifficulty;
    }

    public void setActivityDifficulty(String activityDifficulty) {
        this.activityDifficulty = activityDifficulty;
    }
}
