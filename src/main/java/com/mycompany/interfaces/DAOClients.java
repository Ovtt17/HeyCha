package com.mycompany.interfaces;

import com.mycompany.models.ModelClients;
import java.util.List;

/**
 *
 * @author Ovett
 */
public interface DAOClients {
    public void record (ModelClients client) throws Exception;
    public void modify (ModelClients client) throws Exception;
    public void delete (ModelClients client) throws Exception;
    public List<ModelClients> consult() throws Exception;
}
