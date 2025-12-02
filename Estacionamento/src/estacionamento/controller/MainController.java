package estacionamento.controller;

import estacionamento.model.Client;
import estacionamento.service.ClientServices;

public class MainController {
    private ClientServices clientServices = new  ClientServices();

    // Save the client to the mainView list
    public void addClient(Client client) {
        clientServices.verifyClientsHere(client);
    }

    // Save the client information for future visits
    public void saveClientInfo(Client client) {
        clientServices.verifyClientExists(client);
    }
}
