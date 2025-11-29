package estacionamento.controller;

import estacionamento.model.Client;
import estacionamento.service.ClientServices;

public class MainController {
    private ClientServices clientServices = new  ClientServices();

    public void saveClient(Client client) {

        clientServices.verifyClient(client);
    }
}
