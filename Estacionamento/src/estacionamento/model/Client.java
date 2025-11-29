package estacionamento.model;

public class Client {
    private String name;
    private String plate;
    private String phonenumber;

    public Client(String clientName, String vehiclePlate, String clientPhone) {
        this.name = clientName;
        this.plate = vehiclePlate;
        this.phonenumber = clientPhone;
    }

    public String getName() { return name; }
    public String getPlate() { return plate; }
    public String getPhonenumber() { return phonenumber; }

    public void setName(String name) { this.name = name; }
    public void setPlate(String plate) { this.plate = plate; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
}
