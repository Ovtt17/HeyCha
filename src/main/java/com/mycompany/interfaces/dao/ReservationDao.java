package com.mycompany.interfaces.dao;

import com.mycompany.models.Reservation;
import com.mycompany.models.Sale;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;

public interface ReservationDao {
    public Integer record (Reservation reservation) throws Exception;
    public Integer modify (Reservation reservation) throws Exception;
    public void delete (int reservationId) throws Exception;
    public List<Reservation> consult(Date date) throws Exception;
    public Reservation getReservationById(int reservationId) throws Exception;
    
    public void loadClientsCmb(JComboBox<String> cmbClients) throws Exception;
//    public void loadFilterCmb(JComboBox<String> cmbProductsName, JComboBox<String> cmbClientsName) throws Exception;
    public void fillComboBox(Connection conn, JComboBox<String> comboBox, String query) throws SQLException;
}
