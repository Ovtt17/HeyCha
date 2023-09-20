package com.mycompany.interfaces;

import com.mycompany.models.ModelClients;
import java.util.List;
import javax.swing.JComboBox;

public interface DAOClients {

    public void record(ModelClients client) throws Exception;

    public void modify(ModelClients client) throws Exception;
    public ModelClients getClientById(int clientId) throws Exception;

    public void delete(ModelClients client) throws Exception;

    public List<ModelClients> consult(String name) throws Exception;
    
    public void loadCmb(JComboBox<String> cityCmb) throws Exception;
    
}
