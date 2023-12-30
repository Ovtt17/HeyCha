
package com.mycompany.interfaces.dao;

import com.mycompany.models.SalesProducts;
import java.util.List;

public interface SalesDetailsDao {
    public void record (SalesProducts sale) throws Exception;
    public void modify (SalesProducts sale) throws Exception;
    public void delete (Integer saleId, Integer productSizeId) throws Exception;
    public void deleteSoldProduct (int saleId) throws Exception;
    public List<SalesProducts> consult(int saleId) throws Exception;

    public void deleteAll(int saleId);
}
