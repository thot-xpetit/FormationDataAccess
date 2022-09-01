/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lithops.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.ginko.core.dataAccess.DalBaseAccess;
import org.ginko.core.models.StringIdentificator;
import org.ginko.core.sql.StoredProcedure;
import org.lithops.core.model.BookTrain;
import org.lithops.core.model.BookTrainList;


/**
 *
 * @author Administrateur
 */
public class DalBookTrainlist extends DalBaseAccess<BookTrainList, String> {
    /* Components */

    /* Constants */

    /* Properties */
    

    /* Connstructors */
    public DalBookTrainlist(String jndi, BookTrainList data) {
        super(jndi, data);
    }
    
    public DalBookTrainlist(String jndi) {
        super(jndi);
    }
    
    public DalBookTrainlist(String jndi, StringIdentificator id) {
        super(jndi, id);
    }
    
    /* Private Methods */

    /* Protected Methods */

    @Override
    protected void getDeleteSQLQuery(StringBuilder sqlquery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void getInsertSQLQuery(StringBuilder sqlquery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void getModifySQLQuery(StringBuilder sqlquery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void getReadSQLQuery(StringBuilder sqlquery) {
        sqlquery.append("SELECT BookNumber \n");
        sqlquery.append(",NumberPlaces \n");
        sqlquery.append(",NumTrain \n");
        sqlquery.append(",DepartureCity \n");
        sqlquery.append(",ArrivalCity \n");
        sqlquery.append(",DepartureHour \n");
        sqlquery.append("FROM BookTrain\n");
        sqlquery.append("INNER JOIN Train ON Train.NumTrain=BookTrain.TrainNumber\n");
    }

    @Override
    protected void getReadByIDSQLQuery(StringBuilder sqlquery) {
        sqlquery.append("SELECT BookNumber \n");
        sqlquery.append(",NumberPlaces \n");
        sqlquery.append(",NumTrain \n");
        sqlquery.append(",DepartureCity \n");
        sqlquery.append(",ArrivalCity \n");
        sqlquery.append(",DepartureHour \n");
        sqlquery.append("FROM BookTrain\n");
        sqlquery.append("INNER JOIN Train ON Train.NumTrain=BookTrain.TrainNumber\n");
        sqlquery.append("WHERE BookNumber='");
        sqlquery.append(this.getId());
        sqlquery.append("'");
        sqlquery.append("\n");
    }

    @Override
    protected void getReadByParameterSQLQuery(StringBuilder sqlquery) {
        /*
        if (getParameter().containsKey(COUNTRYID)) {
            sqlquery.append("SELECT City.Id AS CityId \n");
            sqlquery.append(",City.Name AS CityName \n");
            sqlquery.append(",City.PostCode AS CityPostCode \n");
            sqlquery.append(",City.CountryId AS CityCountryId \n");
            sqlquery.append(",Country.Id AS CountryId \n");
            sqlquery.append(",Country.Name AS CountryName \n");
            sqlquery.append(",Country.CountryCode AS CountryCode \n");
            sqlquery.append("FROM City, Country\n");
            sqlquery.append("WHERE City.countryId=Country.Id \n");
            sqlquery.append("AND City.CountryId='");
            sqlquery.append(getParameter().get(COUNTRYID));
            sqlquery.append("' \n");
            sqlquery.append("' ORDER BY City.Name");
        } else {
            sqlquery.append("SELECT City.Id AS CityId \n");
            sqlquery.append(",City.Name AS CityName \n");
            sqlquery.append(",City.PostCode AS CityPostCode \n");
            sqlquery.append(",City.CountryId AS CityCountryId \n");
            sqlquery.append(",Country.Id AS CountryId \n");
            sqlquery.append(",Country.Name AS CountryName \n");
            sqlquery.append(",Country.CountryCode AS CountryCode \n");
            sqlquery.append("FROM City, Country\n");
            sqlquery.append("WHERE City.countryId=Country.Id \n");
            sqlquery.append("AND City.Id='");
            sqlquery.append(getID());
            sqlquery.append("'");
        }
        */
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
        _data = new BookTrainList();
    }

    @Override
    protected void OnReadResultSet(ResultSet rs) {
        BookTrain booktrain = new BookTrain();     
        try {
            booktrain.setBookNumber(rs.getString("BookNumber").trim());
            booktrain.setNumberPlace(rs.getInt("NumberPlaces"));
            booktrain.getTrain().setNumber(rs.getString("NumTrain").trim());
            booktrain.getTrain().setDepartureCity(rs.getString("DepartureCity").trim());
            booktrain.getTrain().setArrivalCity(rs.getString("ArrivalCity").trim());
            booktrain.getTrain().setDepartureHour(rs.getInt("DepartureHour"));
            _data.add(booktrain);
        }
        catch(SQLException e){
            
        }
    }

    @Override
    protected void OnEndReadResultSet(ResultSet rs) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnNoDataFound() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnBeginDeleteData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnDeleteData(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnEndDeleteData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnBeginWriteData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnWriteData(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnEndWriteData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnReadAffectedRecords(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    @Override
    protected void OnGeneratedKey(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnCreateData(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnEndCreateData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnBeginUpdateData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnUpdateData(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void OnEndUpdateData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
