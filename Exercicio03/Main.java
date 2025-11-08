import System.ControlSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- ☢️ Teste do Padrão State (Usina Nuclear) ---");
        
        ControlSystem usina = new ControlSystem();
        usina.onHighTemperature(); 

        System.out.println("\n[SIMULAÇÃO] Ligando a usina...");
        usina.switchOn();
        System.out.println("-> Estado atual: NormalOperation");

        Thread.sleep(1000);
        usina.currentTemperature = 310;

        System.out.println("-> Temperatura subiu para: " + usina.currentTemperature + "°C");
        usina.onHighTemperature(); 
        System.out.println("-> Estado atual: YellowAlert");

        Thread.sleep(1000);
        usina.currentTemperature = 420;
        System.out.println("-> Temperatura subiu para: " + usina.currentTemperature + "°C");
        usina.onSustainedCriticalTemperature();
        System.out.println("-> Estado atual: RedAlert");

        Thread.sleep(1000);
        usina.onCoolingSystemFailure(); 
        System.out.println("-> Estado atual: EMERGENCY");

        usina.switchOn(); 


        usina.switchToMaintenanceMode();
        System.out.println("-> Estado atual: Maintenance");

   
        usina.switchOn();
        usina.currentTemperature = 250; 
        System.out.println("-> Estado atual: NormalOperation");
        System.out.println("-> Temperatura normalizada: " + usina.currentTemperature + "°C");
        usina.onHighTemperature();
    }
}
