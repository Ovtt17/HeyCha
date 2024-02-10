
package com.mycompany.interfaces.dao;

import com.mycompany.models.SaleDetail;
import java.util.List;

public interface SalesDetailsDao {
    public void record (SaleDetail sale) throws Exception;
    public void modify (SaleDetail sale) throws Exception;
    public void delete (Integer saleId, Integer productSizeId) throws Exception;
    public void deleteSoldProduct (int saleId) throws Exception;
    public List<SaleDetail> consult(int saleId) throws Exception;

    public void deleteAll(int saleId);
}
