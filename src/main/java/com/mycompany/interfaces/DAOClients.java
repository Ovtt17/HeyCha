package com.mycompany.interfaces;

import com.mycompany.models.ModelClients;
import java.util.List;

public interface DAOClients {

    public void record(ModelClients client) throws Exception;

    public void modify(ModelClients client) throws Exception;

    public void delete(ModelClients client) throws Exception;

    public List<ModelClients> consult() throws Exception;

    public ModelClients getProductById(int clientId) throws Exception;
}
