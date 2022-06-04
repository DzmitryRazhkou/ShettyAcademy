package com.mystore.qa.utils;

import java.util.ArrayList;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT_DurationOfSeconds = 30;
    public static long WEBDRIVERWAIT_DurationOfSeconds = 10;
    static Xls_Reader reader;


//  MY STORE PAGE:

    public static ArrayList<Object[]> getDataSectionWomen() {

        String excelPath = System.getProperty("user.dir") + "/src/main/java/com/mystore/qa/config/data.xlsx";
        String sheetName = "sectionWomen";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String women = reader.getCellData(sheetName, "first", rowNum);
            String dresses = reader.getCellData(sheetName, "second", rowNum);
            String t_shirt = reader.getCellData(sheetName, "third", rowNum);

            Object ob[] = {women, dresses, t_shirt};

            myData.add(ob);
        }

        return myData;
    }

    public static ArrayList<Object[]> getDataMiddleBoxText() {

        String excelPath = System.getProperty("user.dir") + "/src/main/java/com/mystore/qa/config/data.xlsx";
        String sheetName = "middleBoxText";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String comeVisitUs = reader.getCellData(sheetName, "first", rowNum);
            String callUs = reader.getCellData(sheetName, "second", rowNum);
            String howToPayDues = reader.getCellData(sheetName, "third", rowNum);

            Object ob[] = {comeVisitUs, callUs, howToPayDues};

            myData.add(ob);
        }

        return myData;
    }

    public static ArrayList<Object[]> getFooterMyAccount() {

        String excelPath = System.getProperty("user.dir") + "/src/main/java/com/mystore/qa/config/data.xlsx";
        String sheetName = "getFooterMyAccount";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String myOrders = reader.getCellData(sheetName, "first", rowNum);
            String myCreditSlips = reader.getCellData(sheetName, "second", rowNum);
            String myAddresses = reader.getCellData(sheetName, "third", rowNum);
            String myPersonalInfo = reader.getCellData(sheetName, "fourth", rowNum);

            Object ob[] = {myOrders, myCreditSlips, myAddresses, myPersonalInfo};

            myData.add(ob);
        }

        return myData;
    }

    public static ArrayList<Object[]> getFooterInformation() {

        String excelPath = System.getProperty("user.dir") + "/src/main/java/com/mystore/qa/config/data.xlsx";
        String sheetName = "getFooterInformation";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String specials = reader.getCellData(sheetName, "first", rowNum);
            String newProducts = reader.getCellData(sheetName, "second", rowNum);
            String bestSellers = reader.getCellData(sheetName, "third", rowNum);
            String ourStores = reader.getCellData(sheetName, "fourth", rowNum);
            String contactUs = reader.getCellData(sheetName, "fifth", rowNum);
            String terms = reader.getCellData(sheetName, "sixth", rowNum);
            String aboutUs = reader.getCellData(sheetName, "seventh", rowNum);
            String siteMap = reader.getCellData(sheetName, "eighth", rowNum);

            Object ob[] = {specials, newProducts, bestSellers, ourStores, contactUs, terms, aboutUs, siteMap};

            myData.add(ob);
        }

        return myData;
    }

    public static ArrayList<Object[]> getFooterStoreInfo() {

        String excelPath = System.getProperty("user.dir") + "/src/main/java/com/mystore/qa/config/data.xlsx";
        String sheetName = "getFooterStoreInfo";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String geoLocation = reader.getCellData(sheetName, "first", rowNum);
            String phone = reader.getCellData(sheetName, "second", rowNum);
            String email = reader.getCellData(sheetName, "third", rowNum);

            Object ob[] = {geoLocation, phone, email};

            myData.add(ob);
        }

        return myData;
    }

//    LOGIN PAGE

//    1. CREATE ACCOUNT

    public static ArrayList<Object[]> getCreateAccountEmails() {

        String excelPath = System.getProperty("user.dir") + "/src/main/java/com/mystore/qa/config/data.xlsx";
        String sheetName = "createAccount";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String emailCreateAccount = reader.getCellData(sheetName, "emailCreateAccount", rowNum);

            Object ob[] = {emailCreateAccount};

            myData.add(ob);
        }

        return myData;
    }

}
