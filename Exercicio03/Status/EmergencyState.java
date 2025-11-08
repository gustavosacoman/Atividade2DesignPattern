package Status;

import System.ControlSystem;
import interfaces.State;

public class EmergencyState implements State {
    private ControlSystem instance;

    public EmergencyState(ControlSystem instance) {
        this.instance = instance;
    }

    @Override
    public void switchOn() {
        System.out.println("System is already in Emergency State. Immediate action required!");
    }

    @Override
    public void onHighTemperature() {
        System.out.println("System is already in Emergency State. Immediate action required!");
    }

    @Override
    public void onSustainedCriticalTemperature() {
        System.out.println("System is already in Emergency State. Immediate action required!");
    }

    @Override
    public void onCoolingSystemFailure() {
        System.out.println("System is already in Emergency State. Immediate action required!");
    }

   @Override
    public void switchToMaintenanceMode() {
        System.out.println("Switching system to Maintenance Mode from Emergency State.");
        instance.setState(new MaintenanceState(instance));
    }
    
    
}
