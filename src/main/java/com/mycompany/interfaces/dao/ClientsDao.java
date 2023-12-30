package com.mycompany.interfaces.dao;

import com.mycompany.db.Database;
import com.mycompany.models.Clients;
import java.util.List;
import javax.swing.JComboBox;

public interface ClientsDao {

    public void record(Clients client) throws Exception;

    public void modify(Clients client) throws Exception;
    public Clients getClientById(int clientId) throws Exception;

    public void delete(int clientId) throws Exception;

    public List<Clients> consult(String name) throws Exception;
    
    public void loadCmb(JComboBox<String> cityCmb) throws Exception;
    
}
