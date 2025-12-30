package estacionamento.service;
import estacionamento.model.Client;
import estacionamento.repository.ClientRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientServices {
    private ClientRepository clientRepository;
    private ObservableList<Client> clients;
    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
        clients = FXCollections.observableArrayList(clientRepository.getAllClients().values());
    }
    // Returns all clients list
    public ObservableList<Client> getClients() {
        return clients;
    }

    // Verifica se o cliente já não está no estacionamento
    public void addClient(Client client) {
        // VERIFY CLIENT LOGIC HERE
        clientRepository.saveClientToFile(client);
        clients.add(client);
    }

    public void deleteClient(Client client) {
        // Verify if client is on list here
        clientRepository.deleteClientFromFile(client);
        try {
            clients.remove(client);
        } catch (Exception ex) {
            System.out.println("Erro ao apagar cliente da lista de clientes" + ex);
        }
    }

}

