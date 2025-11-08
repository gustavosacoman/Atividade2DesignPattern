package Status;

import System.ControlSystem;
import interfaces.State;

public class NormalOperationState implements State {
    private ControlSystem instance;

    public NormalOperationState(ControlSystem instance) {
        this.instance = instance;
    }

    @Override
    public void switchOn() {
        System.out.println("System is already on and operating normally.");
    }

    @Override
    public void onHighTemperature() {
        if (instance.currentTemperature > instance.highTemperatureThreshold) {
            System.out.println("High temperature detected! Switching to Yellow Alert State.");
            instance.setState(new YellowAlertState(instance));
        } else {
        System.out.println("System is operating normally. Monitoring temperature...");
        }
    }

    @Override
    public void onSustainedCriticalTemperature() {
        System.out.println("System is operating normally. Monitoring temperature...");
    }

    @Override
    public void onCoolingSystemFailure() {
        System.out.println("System is operating normally. Monitoring cooling system...");
    }

    @Override
    public void switchToMaintenanceMode() {
        System.out.println("Switching system to Maintenance Mode from Normal Operation State.");
        instance.setState(new MaintenanceState(instance));
    }
}
