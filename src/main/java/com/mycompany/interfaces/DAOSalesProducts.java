
package com.mycompany.interfaces;

import com.mycompany.models.ModelSalesProducts;
import java.util.List;

public interface DAOSalesProducts {
    public void record (ModelSalesProducts sale) throws Exception;
    public void modify (ModelSalesProducts sale) throws Exception;
    public void delete (Integer saleId, Integer productSizeId) throws Exception;
    public void deleteSoldProduct (int saleId) throws Exception;
    public List<ModelSalesProducts> consult(int saleId) throws Exception;

    public void deleteAll(int saleId);
}
