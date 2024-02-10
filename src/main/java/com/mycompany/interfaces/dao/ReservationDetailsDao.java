package com.mycompany.interfaces.dao;

import com.mycompany.models.ReservationDetail;
import java.util.List;

public interface ReservationDetailsDao {
    public void record (ReservationDetail rDetails) throws Exception;
    public void modify (ReservationDetail rDetails) throws Exception;
    public void delete (Integer reservationId, Integer productSizeId) throws Exception;
    public void deleteSoldProduct (int reservationId) throws Exception;
    public List<ReservationDetail> consult(int reservationId) throws Exception;
    
    public void deleteAll(int reservationId);
}
