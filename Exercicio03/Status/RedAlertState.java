package Status;

import System.ControlSystem;
import interfaces.State;

public class RedAlertState implements State {
    private ControlSystem instance;

    public RedAlertState(ControlSystem instance) {
        this.instance = instance;
    }

    @Override
    public void switchOn() {
        System.out.println("System is already on in Red Alert State. Immediate action required!");
    }

    @Override
    public void onHighTemperature() {
        if (instance.currentTemperature < instance.criticalTemperatureThreshold) {
            System.out.println("Temperature has decreased below critical threshold. Switching to Yellow Alert State.");
            instance.setState(new YellowAlertState(instance));
        }
        else {
            System.out.println("Temperature is still critical. Remaining in Red Alert State.");
        }
    }

    @Override
    public void onSustainedCriticalTemperature() {
        System.out.println("System is already in Red Alert State due to sustained critical temperature!");
    }

    @Override
    public void onCoolingSystemFailure() {
        System.out.println("Cooling system failure detected! Immediate action required!");
        instance.setState(new EmergencyState(instance));
    }

    @Override
    public void switchToMaintenanceMode() {
        System.out.println("Switching system to Maintenance Mode from Red Alert State.");
        instance.setState(new MaintenanceState(instance));
    }
}
