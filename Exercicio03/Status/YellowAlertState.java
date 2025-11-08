package Status;

import System.ControlSystem;
import interfaces.State;

public class YellowAlertState implements State {
    private ControlSystem instance;

    public YellowAlertState(ControlSystem instance) {
        this.instance = instance;
    }

    @Override
    public void switchOn() {
        System.out.println("System is already ON in Yellow Alert State.");
    }

    @Override
    public void onHighTemperature() {
        System.out.println("System is already in Yellow Alert State. Monitoring temperature...");
    }

    @Override
    public void onSustainedCriticalTemperature() {
        if (instance.currentTemperature > instance.criticalTemperatureThreshold) {
            System.out.println("Sustained critical temperature detected! Switching to Red Alert State.");
            instance.setState(new RedAlertState(instance));
        } else {
            System.out.println("Temperature is high but not critical. Continuing in Yellow Alert State.");
        }

    }

    @Override
    public void onCoolingSystemFailure() {
        System.out.println("you cannot change from Yellow Alert State to Emergency" +
          "State due to cooling system failure.");
    }

    @Override
    public void switchToMaintenanceMode() {
        System.out.println("Switching system to Maintenance Mode from Yellow Alert State.");
        instance.setState(new MaintenanceState(instance));
    }
    
}
