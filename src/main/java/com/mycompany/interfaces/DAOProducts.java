package com.mycompany.interfaces;

import com.mycompany.models.ModelProducts;
import java.util.List;

/**
 *
 * @author Ovett
 */
public interface DAOProducts {
    public void record (ModelProducts product) throws Exception;
    public void modify (ModelProducts product) throws Exception;
    public void delete (ModelProducts product) throws Exception;
    public List<ModelProducts> consult() throws Exception;
    
}
