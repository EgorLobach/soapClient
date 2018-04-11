package client.controller;


import client.IServiceStub;
import org.apache.axis2.AxisFault;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientController{
    private IServiceStub serviceStub;

    public ClientController() {
        try {
            serviceStub =
                    new IServiceStub("http://localhost:8080/axis2/services/IService?wsdl");
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    public void addItem(IServiceStub.Item item){
        IServiceStub.AddItem addItem = new IServiceStub.AddItem();
        addItem.setArgs0(item);
        try {
            serviceStub.addItem(addItem);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void updateItem(IServiceStub.Item item){
        IServiceStub.UpdateItem updateItem = new IServiceStub.UpdateItem();
        updateItem.setArgs0(item);
        try {
            serviceStub.updateItem(updateItem);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void deleteItem(String name){
        IServiceStub.DeleteItem deleteItem = new IServiceStub.DeleteItem();
        deleteItem.setArgs0(name);
        try {
            serviceStub.deleteItem(deleteItem);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public List<IServiceStub.Item> getItems(){
        List<IServiceStub.Item> items = new ArrayList<>();
        try {
            IServiceStub.GetItems getItems = new IServiceStub.GetItems();
            IServiceStub.GetItemsResponse response = serviceStub.getItems(getItems);
            IServiceStub.Item[] itemsMas = response.get_return();
            items = Arrays.asList(itemsMas);
        }catch (RemoteException e) {
            e.printStackTrace();
        }
        return items;
    }
}
