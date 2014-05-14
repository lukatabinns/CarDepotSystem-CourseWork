
import java.util.*;
public class Depot
{
    private String depotName = "";
    private HashMap<String,Vehicle> vehicles;
    private Collection<Vehicle>vehicle_data;
    public Depot(String depot) {
        depotName = depot;
        vehicles = new HashMap<String,Vehicle>();
        vehicle_data = vehicles.values();
    }
    public void addVehicle(Vehicle v)
    {
        vehicles.put(v.getCode(),v);
        v.setHomeDepot(depotName);
    }
    public void removeVehicle(String code) {
        vehicles.remove(code);
    }
    public Vehicle findVehicleByCode(String code) {
        if(vehicles.get(code) != null) {
            return vehicles.get(code);
        } else {
            return null;
        }
    }
            {
        Object[] vehicleArray = (Object[]) vehicles.values().toArray();
        return vehicleArray;
    }
    public boolean rentVehicle(String code, Date dateOfReturn) {
        Object o = vehicles.get(code);
        if(o != null) {
            if(o instanceof RentableCar) {
                RentableCar v = (RentableCar) o;
                v.pickUp(dateOfReturn);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    public boolean returnVehicle(String code) {
       Object o = vehicles.get(code);
        if(o != null) {
            if(o instanceof RentableCar) {
                RentableCar v = (RentableCar) o;
                if(v.isRented()) {
                    v.dropOff();
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return false;
        }
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        result.append(this.getClass().getName() + " Object {" + newLine);
        result.append(" Name of Depot: " + depotName + newLine);
        result.append(" Number of Vehicles in Depot: " + vehicles.size() + newLine);
        if(vehicles.size() > 0) {
        result.append(" Vehicles in Depot: " + newLine);
        for (Iterator it = vehicle_data.iterator(); it.hasNext();) {
            Vehicle v = (Vehicle) it.next();
            result.append(v.toString());
        }
    }
        result.append("}"); 
        return result.toString();
    }
}
