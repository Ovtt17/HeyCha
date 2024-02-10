package com.mycompany.interfaces.dao;

import com.mycompany.db.Database;
import com.mycompany.models.Client;
import java.util.List;
import javax.swing.JComboBox;

public interface ClientsDao {

    public void record(Client client) throws Exception;

    public void modify(Client client) throws Exception;
    public Client getClientById(int clientId) throws Exception;

    public void delete(int clientId) throws Exception;

    public List<Client> consult(String name) throws Exception;
    
    public void loadCmb(JComboBox<String> cityCmb) throws Exception;
    
}
