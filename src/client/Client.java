package client;

import client.controller.ClientController;
import client.view.MainFrame;

public class Client {
    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        new MainFrame(clientController);
    }
}
