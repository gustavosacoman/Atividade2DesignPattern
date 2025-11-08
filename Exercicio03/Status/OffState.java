package Status;

import System.ControlSystem;
import interfaces.State;

public class OffState implements State {
    private ControlSystem instance;

    public OffState(ControlSystem instance) {
        this.instance = instance;
    }

    @Override
    public void switchOn() {
        instance.setState(new NormalOperationState(instance));
    }

    @Override
    public void onHighTemperature() {
        System.out.println("System is off. Cannot process high temperature event.");
    }

    @Override
    public void onSustainedCriticalTemperature() {
        System.out.println("System is off. Cannot process sustained critical temperature event.");
    }

    @Override
    public void onCoolingSystemFailure() {
        System.out.println("System is off. Cannot process cooling system failure event.");
    }

    @Override
    public void switchToMaintenanceMode() {
        System.out.println("Switching system to Maintenance Mode from Off State.");
        instance.setState(new MaintenanceState(instance));
    }
    
}
