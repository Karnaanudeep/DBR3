package org.example.service;

import org.example.dao.VictimDAO;
import org.example.entity.VictimPojo;
import org.example.utils.DBConnection;
import org.example.utils.DBNativeSQLQuries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VictimDAOImp implements VictimDAO {

    private Connection connection ;
    private Scanner scanner;

    public VictimDAOImp(){
        if(connection == null){
            connection = DBConnection.getDBConnection();
        }
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
    }
    @Override
    public List<VictimPojo> fetchAllVictims() {
        List<VictimPojo> victimPojoList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_FETCH_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String breed = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                String address = resultSet.getString(6);
                VictimPojo victimPojo = new VictimPojo(name,age,breed,status,address);
                victimPojoList.add(victimPojo);
            }
        }
        catch (Exception exception){
            exception.printStackTrace();

        }
        return victimPojoList;
    }

    @Override
    public List<VictimPojo> fetchAVictim(int victimAge) {
        List<VictimPojo> list = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_FETCH_BY_AGE);
            preparedStatement.setInt(1,victimAge);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String breed = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                String address = resultSet.getString(6);
                VictimPojo victimPojo = new VictimPojo(name,age,breed,status,address);
                list.add(victimPojo);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated) {
        List<VictimPojo> list = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_FETCH_BY_AGE);
            preparedStatement.setBoolean(1,isVaccinated);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String breed = resultSet.getString(4);
                boolean status = resultSet.getBoolean(5);
                String address = resultSet.getString(6);
                VictimPojo victimPojo = new VictimPojo(name,age,breed,status,address);
                list.add(victimPojo);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

        return list;
    }

    @Override
    public void removeVictim(int victimAge) {


    }

    @Override
    public VictimPojo addVictim(VictimPojo victimPojo) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DBNativeSQLQuries.VICTIM_ADD);
            preparedStatement.setString(1,victimPojo.getName());
            preparedStatement.setInt(2,victimPojo.getAge());
            preparedStatement.setString(3, victimPojo.getDogBreed());
            preparedStatement.setBoolean(4,victimPojo.getDogVaccinatedStatus());
            preparedStatement.setString(5,victimPojo.getAddress());
            int k = preparedStatement.executeUpdate();
            if(k>0){
                return null;
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }


        return null;
    }

    @Override
    public VictimPojo updateVictim(VictimPojo updateVictim) {
        return null;
    }
}
