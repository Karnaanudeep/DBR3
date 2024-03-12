package org.example.model;

import org.example.dao.VictimDAO;
import org.example.entity.VictimPojo;
import org.example.service.VictimDAOImp;
import org.example.utils.DBConnection;
import org.example.utils.DBNativeSQLQuries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class VictimModel {

    private   Connection  connection ;
    private Scanner scanner;

    private VictimDAO victimDAO;

    public VictimModel(){
        if(connection == null){
            connection = DBConnection.getDBConnection();
        }
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        if(victimDAO == null){
            victimDAO = new VictimDAOImp();
        }
        displayOperations();
    }

    public void addVictim(){
        System.out.println("ENTER VICTIM NAME");
        String victimName = scanner.next();
        System.out.println("ENTER DOG BREED");
        String dogBreed = scanner.next();
        System.out.println("ENTER VICTIM AGE");
        int victimAge = scanner.nextInt();
        System.out.println("ENTER VICTIM ADDESS");
        String  address = scanner.next();
        System.out.println("ENTER DOG VACCINATED STATUS");
        boolean status = scanner.nextBoolean();
        VictimPojo victimPojo = new VictimPojo(victimName,victimAge,dogBreed,status,address);
        victimDAO.addVictim(victimPojo);
    }
    public List<VictimPojo> findVictimByStatus(){
        System.out.println("ENTER VICTIM STATUS");
        boolean status = scanner.nextBoolean();
        List<VictimPojo> victimPojoList= victimDAO.fetchByVaccinatedStatus(status);
        victimPojoList.forEach(victim->{
            System.out.println(victim);
        });
        displayOperations();
        return  null;

    }
    public  void fetchAllVictims(){
        List<VictimPojo> victimPojoList= victimDAO.fetchAllVictims();
        victimPojoList.forEach(victim->{
            System.out.println(victim);
        });
    }
    public void findVictimByAge(){
        System.out.println("FIND VICTIMS BY AGE");
        int age = scanner.nextInt();
        List<VictimPojo> list = victimDAO.fetchAVictim(age);
        list.forEach(vi->System.out.println(vi));

        displayOperations();

    }
    public void removeVictim(){
        System.out.println(" REMOVE");
        displayOperations();

    }
    public void updateVictim(){
    }
    public  void displayOperations(){
        System.out.println("*********ENTER THE OPEARTIONS OPTIONS************");
        System.out.println("1.ADD VICTIM");
        System.out.println("2.FIND VICTIM BY AGE ");
        System.out.println("3.FIND VICTIM BY STATUS");
        System.out.println("4.REMOVE VICTIM BY AGE");
        System.out.println("5.UPDATE VICTIM");
        System.out.println("6.FETCH ALL VICTIMS");
        int option = scanner.nextInt();

        switch (option){
            case  1: addVictim();
                     break;
            case  2: findVictimByAge();
                break;
            case  3: findVictimByStatus();
                break;
            case  4: removeVictim();
                break;
            case  5: updateVictim();
                break;
            case  6: fetchAllVictims();
                break;
            default: System.out.println("PLEASE ENTER VALID OPTION");
                    displayOperations();

        }




    }




}

