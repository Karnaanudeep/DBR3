package org.example.utils;

public class DBNativeSQLQuries {
    public static final String VICTIM_DELETE = "delete from victim_details where VictimAge=?";
    public static final String VICTIM_FETCH_BY_AGE = "select * from victim_details where VictimAge=?";
    public static final String VICTIM_FETCH_ALL = "select * from victim_details";
    public static final String VICTIM_FETCH_BY_STATUS = "select * from victim_details where VaccinatedStatus=?";
    public static final String VICTIM_FETCH_BY_DOG_BREED = "select * from victim_details where DogBreed=?";
    public static final String VICTIM_ADD = "insert into victim_details(VictimName, VictimAge, DogBreed, VaccinatedStatus, VictimAddress) values(?,?,?,?,?)";
    public static final String VICTIM_UPDATE = "update victim_details set VictimAddress=? where VictimAge=?";
    public static final String ADDRESS_FETCH_ALL = null;

    public  static  final String DATABASE_URL = "jdbc:mysql://localhost:3306/DogBiteVictimRegistry";
    public  static  final String USER = "springstudent";
    public  static  final String PASSWORD = "springstudent";
    public  static  final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
}
