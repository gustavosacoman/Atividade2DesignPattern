package interfaces;

public interface State {
    
    void switchOn();

    void onHighTemperature();

    void onSustainedCriticalTemperature();

    void onCoolingSystemFailure();

    void switchToMaintenanceMode();

}
