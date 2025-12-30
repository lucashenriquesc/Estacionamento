package estacionamento.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<String> plates;
    private String phonenumber;
    private int clientId;

    public Client(String clientName, List<String> vehiclePlate, String clientPhone) {
        this.name = clientName;
        this.plates = new ArrayList<>(vehiclePlate);
        this.phonenumber = clientPhone;
    }

    // Client info getters and setters
    public int getClientId() { return clientId; }
    public String getName() { return name; }
    public String getPhonenumber() { return phonenumber; }

    public void setClientId(int clientId) { this.clientId = clientId; }
    public void setName(String name) { this.name = name; }
    public void setPlate(List<String> plates) { this.plates = plates; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    // Add new plate to client plates list
    public void addPlate(String plate) {
        this.plates.add(plate);
    }

    // Get plates list
    public List<String> getPlates() {
        return plates;
    }
}
