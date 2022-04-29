package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
    	String out;
        int contBaterry=0;
        int contReBaterry=0;
        for(int i=0;i<MAX_BATTERIES;i++){
            if(batteries[i] instanceof RechargeableBattery && batteries[i]!=null){
                contReBaterry ++;
            }else{
                contBaterry ++;
            }
        }
        out = "\n Normal Battery = " + contBaterry + "\n Rechargeable Battery = " + contReBaterry;
        return out;
    }
    
    public String showBatteriesInfo() {
    	String str = "";
        for(int i=0;i<MAX_BATTERIES && batteries[i]!=null;i++){
            if(batteries[i] instanceof RechargeableBattery){
                RechargeableBattery thebattery = (RechargeableBattery)batteries[i];
                str += "\n Bateria recargable" +
                "\nNombre: " + batteries[i].getName() +
                "\nCosto de vida util: " + thebattery.calculateUsefulLife();
            }else{
                str += "\n Bateria no recargable" + 
                "\nNombre: " + batteries[i].getName() +
                "\nCosto de vida util: 0";
            }
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
		double lifeCost = 0.0;
        int contReB = 0;
        double promLifeCost = 0.0;
        for(int i=0;i<MAX_BATTERIES;i++){
            if(batteries[i] instanceof RechargeableBattery){
                contReB ++;
                RechargeableBattery thebattery = (RechargeableBattery)batteries[i];
                lifeCost += thebattery.calculateUsefulLife();
            }
        }
        promLifeCost = lifeCost/contReB;
        return promLifeCost;
	}

}
