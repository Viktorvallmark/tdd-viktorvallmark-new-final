package com.tddslutprojektviktorvallmark;

public class Main  {


    public static void main(String[] args)   {

        FinnFormen finnFormen = new FinnFormen(4);
        double[][] k = finnFormen.getListOfVectors();

        finnFormen.printInfo(k);

        System.out.println(finnFormen.checkShape(k));
}

}
