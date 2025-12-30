package estacionamento.controller;

import estacionamento.model.Client;
import estacionamento.repository.ClientRepository;
import estacionamento.service.ClientServices;
import javafx.collections.ObservableList;

public class MainController {
    private final ClientRepository clientRepository;
    private final ClientServices clientServices;

    public MainController(ClientRepository clientRepository, ClientServices clientServices) {
        this.clientRepository = clientRepository;
        this.clientServices = clientServices;
    }

    public ObservableList<Client> getClients() {
         return clientServices.getClients();
    }

    public void addClient(Client client) {
        clientServices.addClient(client);
    }

    public void deleteClient(Client client) {
        clientServices.deleteClient(client);
    }
}
