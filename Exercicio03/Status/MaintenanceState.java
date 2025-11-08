package Status;

import System.ControlSystem;
import interfaces.State;

public class MaintenanceState implements State {
    private ControlSystem instance;

    public MaintenanceState(ControlSystem instance) {
        this.instance = instance;
    }

    @Override
    public void switchOn() {
        instance.setState(new NormalOperationState(instance));
    }

    @Override
    public void onHighTemperature() {
        System.out.println("System is under maintenance. Temperature monitoring is disabled.");
    }

    @Override
    public void onSustainedCriticalTemperature() {
        System.out.println("System is under maintenance. Temperature monitoring is disabled.");
    }

    @Override
    public void onCoolingSystemFailure() {
        System.out.println("System is under maintenance. Cooling system status is not monitored.");
    }

    @Override
    public void switchToMaintenanceMode() {
        System.out.println("System is already in Maintenance Mode.");
    }
    
}
