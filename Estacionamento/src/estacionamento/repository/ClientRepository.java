package estacionamento.repository;

import estacionamento.model.Client;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ClientRepository {
    private Map<Integer, Client> clients = new HashMap<>();
    private int nextClientId;
    // Paths to client infos and client plates csv
    private Path clientsInfoPath = Paths.get(System.getProperty("user.dir"), "data", "clientsinfo.csv");
    private Path vehiclesPath = Paths.get(System.getProperty("user.dir"), "data", "plates.csv");

    public ClientRepository() {
        verifyIfFileExists(clientsInfoPath);
        verifyIfFileExists(vehiclesPath);
        loadFiles();
        setNextClientId();
    }

    // Verify if the clients list csv file exists, and if not creates it
    public void verifyIfFileExists(Path path) {
        // Verify if clientsinfo.csv and vehiclesplates.csv file exists, and if not, creates it
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo de informações dos clientes!" + " " + e.getMessage());
            e.printStackTrace();        // Replace this for showing error in ui later
        }
    }

    // Load the Files containing client info and add them to the clients ArrayList
    private void loadFiles() {
        int clientId = 0;
        // Loads clients_info.csv file
        try (BufferedReader br = new BufferedReader(new FileReader(clientsInfoPath.toFile()))) {
            br.readLine(); // Ignores the header line
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isBlank()) continue;
                List<String> clientPlates = new ArrayList<>();
                String[] values = line.split(",");
                clientId = Integer.parseInt(values[0]);
                String clientName =  values[1].trim();
                String clientPhone = values[2].trim();
                // Creates client object and adds it to clients HashMap
                Client client = new Client(clientName, clientPlates, clientPhone);
                client.setClientId(clientId);
                clients.put(clientId, client);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de informações de clientes" + " " + e.getMessage());   // Replace this for showing error in ui later
        }

        // Loads plates.csv file
        try (BufferedReader br = new BufferedReader(new FileReader(vehiclesPath.toFile()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isBlank()) continue;
                String[] plates = line.split(",");
                clientId = Integer.parseInt(plates[0]);
                // Add plates to client plates list
                for (int i = 1; i < plates.length; i++) {
                    clients.get(clientId).addPlate(plates[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de veiculos de clientes! " + " " + e.getMessage());
        }
    }

    // Verify highest saved clientId for setting id for next client
    private void setNextClientId() {
        nextClientId = clients.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
    }

    // Returns all current clients saved
    public Map<Integer, Client> getAllClients() {
        return clients;
    }

    //Saves the client info
    public void saveClientToFile(Client client) {
        // Verify highest clientId on file
        setNextClientId();
        // Saving client id, name, and phonenumber to client info file.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(clientsInfoPath.toFile(), true))) {
            String newClient = nextClientId + ", " + client.getName() + ", "  + client.getPhonenumber();
            bw.newLine();
            bw.write(newClient);
        } catch (IOException e) {
            System.out.println("Erro ao salvar cliente no arquivo csv" + " " + e.getMessage());
        }

        // Saving client vehicle plates to vehicle plates file
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(vehiclesPath.toFile(), true))) {
            StringBuilder clientPlates = new StringBuilder();
            for (String plate : client.getPlates()) {
                clientPlates.append(plate).append(", ");
            }

            String newClientLine = nextClientId + ", " + clientPlates;
            bw.newLine();
            bw.write(newClientLine);
        } catch (IOException e) {
            System.out.println("Erro ao salvar placas de veiculos no arquivo csv" + " " + e.getMessage());
        }
    }

    public void deleteClientFromFile(Client client) {
        StringBuilder clientsInfoFile = new StringBuilder();
        // Loads clientsinfo file and excludes client line to be deleted
        try(BufferedReader br = new BufferedReader(new FileReader(clientsInfoPath.toFile()))) {
            String line;
            clientsInfoFile.append("id, ").append("nome, ").append("telefone");
            br.readLine();
            while((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] info = line.split(",");
                int id =  Integer.parseInt(info[0]);
                if (id != client.getClientId()) {
                    clientsInfoFile.append(line).append("\n");
                }
            }
        } catch(IOException e) {
            System.out.println("Erro ao ler arquivo para deletar informações do cliente" + e.getMessage());
        }
        // Rewriting clientsinfo file without the excluded client
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(clientsInfoPath.toFile(), false))) {
            bw.write(clientsInfoFile.toString());
        } catch(IOException e) {
            System.out.println("Erro ao salvar arquivo após remover o cliente" + e.getMessage());
        }
        // Loads clientplates file and excludes client line to be deleted
        StringBuilder clientPlateFile = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(vehiclesPath.toFile()))) {
            String line;
            clientPlateFile.append("id, ").append("placas, ");
            br.readLine();
            while((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] info = line.split(",");
                int id =  Integer.parseInt(info[0]);
                if (id != client.getClientId()) {
                    clientPlateFile.append(line).append("\n");
                }
            }
        } catch(IOException e) {
            System.out.println("Erro ao ler arquivo de placas dos clientes" + " " + e.getMessage());
        }
        // Rewrites clientplates file after without excluded client
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(vehiclesPath.toFile(), false))) {
            bw.write(clientPlateFile.toString());
        } catch(IOException e) {
            System.out.println("Erro ao salvar arquivo de placas de clientes" + e.getMessage());
        }
    }
}
