package com.tddslutprojektviktorvallmark;


public class FinnFormen {

    private double[][] listOfVectors;

    public FinnFormen(int numOfVectors)
    {
        listOfVectors = new double[numOfVectors][3];
        for(int i = 0; i < numOfVectors; i++)
        {
            double[] vector = new double[3];

            for(int j = 0; j < vector.length; j++)
            {
                vector[j] = Math.random();
                if(vector[j] < 0.5d)
                {
                    vector[j] = 0.0d;
                }else
                    vector[j] = 1.0d;
                assert listOfVectors != null;
                listOfVectors[i][j] = vector[j];
            }
        }
    }

    public double[][] getListOfVectors()
    {
        return listOfVectors;
    }

    public void printInfo(double[][] vector)
    {
        for(double[] vec : vector)
        {
            for(double cord : vec)
            {
                System.out.println(cord+" ");
            }
            System.out.println();
        }
    }

    private double distance2d(double[] first, double[] second)
    {
        double x1 = first[0];
        double y1 = first[1];
        double x2 = second[0];
        double y2 = second[1];

        return Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
    }

    private double distance3d(double[] first, double[] second)
    {
        double x1 = first[0];
        double y1 = first[1];
        double z1 = first[2];
        double x2 = second[0];
        double y2 = second[1];
        double z2 = second[2];
;
        return Math.sqrt((z2-z1)*(z2-z1)+(y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
    }

    public String checkShape(double[][] vectorList)
    {
        String answer = "";

        switch (vectorList.length) {
            case 0 -> answer += "None";

            case 1 -> answer += "Dot";

            case 2 -> answer += "Line";

            case 3 -> answer += "Triangle";

            case 4 ->
            {
                double[] tempVector = vectorList[0];
                double[] distance = new double[4];
                for(int i = 1; i < vectorList.length; i++)
                {
                    distance[i-1] = distance2d(tempVector, vectorList[i]);
                    tempVector = vectorList[i];
                }
                if(distance[0]==distance[1] && distance[2]==distance[3])
                {
                    answer += "Square";
                }else if ((distance[0] < distance[1] || distance[1] < distance[0]) && (distance[2] < distance[3] || distance[3] < distance[2]))
                {
                    answer += "Rectangle";
                }else if (distance[0] < distance[1])
                {
                    answer += "Parallelogram";
                }else
                    answer += "2d-shape";
            }

            case 5 ->
            {

            }
            case 8 ->
            {
                answer += "";
            }
        }
    return answer;
    }
}