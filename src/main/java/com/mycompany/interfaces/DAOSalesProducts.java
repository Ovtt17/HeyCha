
package com.mycompany.interfaces;

import com.mycompany.models.ModelSalesProducts;
import java.util.List;

public interface DAOSalesProducts {
    public void record (ModelSalesProducts sale) throws Exception;
    public void modify (ModelSalesProducts sale) throws Exception;
    public void delete (int saleId) throws Exception;
    public List<ModelSalesProducts> consult(String name) throws Exception;
    public ModelSalesProducts getSaleById(int saleId) throws Exception;
}
