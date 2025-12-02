package estacionamento.repository;

import estacionamento.model.Client;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();
    private Path path = Paths.get(System.getProperty("user.dir"), "data", "clientes_presentes.csv");

    public ClientRepository() {
        verifyIfFileExists();
        loadFiles();
    }

    // Verify if the clients list csv file exists, and if not creates it
    public void verifyIfFileExists() {
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo csv" + " " + e.getMessage());
            e.printStackTrace();        // Replace this for showing error in ui later
        }
    }

    // Load the Files containing client info and add them to the clients ArrayList
    private void loadFiles() {
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isBlank()) continue;

                String[] values = line.split(",");
                String clientName =  values[0].trim();
                String vehiclePlate = values[1].trim();
                String clientPhone = values[2].trim();

                Client client = new Client(clientName, vehiclePlate, clientPhone);
                clients.add(client);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo csv" + " " + e.getMessage());   // Replace this for showing error in ui later
        }
    }

    //Saves the client info
    public void saveClient() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()));



        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo csv" + " " + e.getMessage());
        }
    }

}
