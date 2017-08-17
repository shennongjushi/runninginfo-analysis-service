package lab1.domain;

import lombok.Data;

@Data
public class Response {
    private String runningId;
    private double totalRunningTime;
    private int heartRate;
    private int userId;
    private String userName;
    private String userAddress;
    RunningInformation.HealthWarningLevel healthWarningLevel;

    public Response(){}

    public Response(String runningId, double totalRunningTime, int heartRate, int userId, String userName, String userAddress, RunningInformation.HealthWarningLevel healthWarningLevel) {
        this.runningId = runningId;
        this.totalRunningTime = totalRunningTime;
        this.heartRate = heartRate;
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.healthWarningLevel = healthWarningLevel;
    }
}
