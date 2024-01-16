/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Raja
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("kjbkjhl");
        try {
            String bdt = "2022/05/10";
            String adt = "2022/05/12";

            LocalDate dt1 = LocalDate.parse(bdt);
            LocalDate dt2 = LocalDate.parse(adt);

            long nof = ChronoUnit.DAYS.between(dt1, dt2);

            System.out.println(nof);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
