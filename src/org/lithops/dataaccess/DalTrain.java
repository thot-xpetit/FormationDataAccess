/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lithops.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ginko.core.dataAccess.DalBaseAccess;
import org.ginko.core.models.StringIdentificator;
import org.ginko.core.sql.StoredProcedure;
import org.lithops.core.model.Train;

/**
 *
 * @author Administrateur
 */
public class DalTrain extends DalBaseAccess<Train,String> {
    /* Connstructors */
    public DalTrain(String jndi, Train data) {
        super(jndi, data);
        
    }
    
    public DalTrain(String jndi) {
        super(jndi); 
    }
    
    public DalTrain(String jndi, StringIdentificator id) {
        super(jndi, id);
    }
    
    /* Private Methods */

    /* Protected Methods */

    @Override
    protected void getDeleteSQLQuery(StringBuilder sqlquery) {
        if (_data != null) {
            sqlquery.append("DELETE FROM \"Train\" \n");
            sqlquery.append("WHERE \"NumTrain\"='");
            sqlquery.append(_data.getNumber());
            sqlquery.append("'");
            sqlquery.append("\n");
        }
    }

    @Override
    protected void getInsertSQLQuery(StringBuilder sqlquery) {
        if (_data != null) {
            sqlquery.append("INSERT INTO \"Train\" \n");
            sqlquery.append("(\"NumTrain\", \"DepartureCity\", \"ArrivalCity\", \"DepartureHour\") \n");
            sqlquery.append("VALUES \n");
            sqlquery.append("('" + _data.getNumber() + "','" + _data.getDepartureCity()+ "','" + _data.getArrivalCity() + "'," + Integer.toString(_data.getDepartureHour()) + ")\n");
        }
    }

    @Override
    protected void getModifySQLQuery(StringBuilder sqlquery) {
        if (_data != null) {
            sqlquery.append("UPDATE \"Train\" \n");
            sqlquery.append("SET \"DepartureCity\"='" + _data.getDepartureCity()+ "'\n");
            sqlquery.append(",\"ArrivalCity\"='" + _data.getArrivalCity()+ "'\n");
            sqlquery.append(",\"DepartureHour\"=" + Integer.toString(_data.getDepartureHour()) + "\n");
            sqlquery.append("WHERE \"NumTrain\"='");
            sqlquery.append(_data.getNumber());
            sqlquery.append("'");
            sqlquery.append("\n");
        }
        
    }

    @Override
    protected void getReadSQLQuery(StringBuilder sqlquery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void getReadByIDSQLQuery(StringBuilder sqlquery) {
        sqlquery.append("SELECT \"NumTrain\" \n");
        sqlquery.append(",\"DepartureCity\" \n");
        sqlquery.append(",\"ArrivalCity\" \n");
        sqlquery.append(",\"DepartureHour\" \n");
        sqlquery.append("FROM \"Train\"\n");
        sqlquery.append("WHERE \"NumTrain\"='");
        sqlquery.append(this.getId());
        sqlquery.append("'");
        sqlquery.append("\n");
    }

    @Override
    protected void getReadByParameterSQLQuery(StringBuilder sqlquery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadDeleteStoredProc(String storedproc, HashMap parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadInsertStoredProc(String storedproc, HashMap parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadModifyStoredProc(String storedproc, HashMap parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadReadStoredProc(String storedproc, HashMap parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadReadByIDStoredProc(String storedproc, HashMap parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadReadByParameterStoredProc(String storedproc, HashMap parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnBeginReadResultSet(ResultSet rs) {
        _data = new Train();
    }

    @Override
    protected void OnReadResultSet(ResultSet rs) {
        try {
            _data.setNumber(rs.getString("NumTrain").trim());
            _data.setDepartureCity(rs.getString("DepartureCity").trim());
            _data.setArrivalCity(rs.getString("ArrivalCity").trim());
            _data.setDepartureHour(rs.getInt("DepartureHour"));
        } catch (SQLException ex) {
            Logger.getLogger(DalTrain.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    protected void OnEndReadResultSet(ResultSet rs) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnNoDataFound() {
        _data = new Train();
    }

    @Override
    protected void OnBeginDeleteData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnDeleteData(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnEndDeleteData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnBeginWriteData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnWriteData(Object obj) {

    }

    @Override
    protected void OnEndWriteData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnReadAffectedRecords(ResultSet rs) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnGeneratedKey(ResultSet rs) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void getMaxIdent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setMaxIdent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnBeginCreateData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnCreateData(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnEndCreateData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnBeginUpdateData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnUpdateData(Object obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnEndUpdateData() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void addSQLParameter() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadDeleteStoredProc(StoredProcedure storedproc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadInsertStoredProc(StoredProcedure storedproc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadModifyStoredProc(StoredProcedure storedproc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadReadStoredProc(StoredProcedure storedproc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadReadByIDStoredProc(StoredProcedure storedproc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void loadReadByParameterStoredProc(StoredProcedure storedproc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
