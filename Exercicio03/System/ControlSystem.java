package System;

import Status.OffState;
import interfaces.State;

public class ControlSystem {
    
    private State state;
    public double currentTemperature;
    public double highTemperatureThreshold = 300.0;
    public double criticalTemperatureThreshold = 400.0;

    public ControlSystem() {
        this.currentTemperature = 25.0; 
        this.state = new OffState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void switchOn() {
        state.switchOn();
    }
    
    public void onHighTemperature() {
        state.onHighTemperature();
    }

    public void onSustainedCriticalTemperature() {
        state.onSustainedCriticalTemperature();
    }

    public void onCoolingSystemFailure() {
        state.onCoolingSystemFailure();
    }

    public void switchToMaintenanceMode() {
        state.switchToMaintenanceMode();
    }
}
