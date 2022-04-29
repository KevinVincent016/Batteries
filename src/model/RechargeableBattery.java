package model;

public class RechargeableBattery extends Battery implements Rechargeable {
    
    public static final char BATTERY_LITIO = 'l';
    public static final char BATTERY_NIQUEL_CADIO = 'n';
    public static final double FACTOR_LITIO = 0.92;
    public static final double FACTOR_NIQUEL_CADIO = 0.80;
    private int chargerNumber;
    private char type;

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type){
        super(name, voltage, cost, capacity);
        this.chargerNumber=chargerNumber;
        this.type=type;
    }

    public double calculateUsefulLife(){
        double usefulLife = 0.0;
        if(type=='l'){
            usefulLife = super.getCost() * super.getVoltage() * getCapacity() / 1000 * chargerNumber * FACTOR_LITIO;
        }
        if(type=='n'){
            usefulLife = super.getCost() * super.getVoltage() * getCapacity() / 1000 * chargerNumber * FACTOR_NIQUEL_CADIO;
        }
        return usefulLife;
    }
}
