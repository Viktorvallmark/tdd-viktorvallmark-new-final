package com.tddslutprojektviktorvallmark;


import Jama.Matrix;

import java.util.Iterator;
import java.util.Objects;

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
    public void setListOfVectors(double[][] vectorList)
    {
        this.listOfVectors = vectorList;
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
                //Distance calculation
                double[] tempVector = vectorList[0];
                double[] distance = new double[4];
                for(int i = 1; i < vectorList.length; i++)
                {
                    distance[i-1] = distance2d(tempVector, vectorList[i]);
                    tempVector = vectorList[i];
                }
                //Comparisons
                if(distance[0]==distance[1] && distance[2]==distance[3])
                {
                    answer += "Square";
                }else if ((distance[0] < distance[1] || distance[1] < distance[0]) && (distance[2] < distance[3] || distance[3] < distance[2]))
                {
                    answer += "Rectangle";
                }else if (((distance[0] == distance[1]) || (distance[0] == distance[2]) || (distance[0] == distance[3])) && (((vectorList[0][0]+vectorList[1][0])/2.0d) ==((vectorList[0][1]+vectorList[1][1])/2.0d)))
                {
                    answer += "Parallelogram";
                }else
                    answer += "2d-shape";
            }

            case 5 ->
            {
                double[] tempVector = vectorList[0];
                double[] distance = new double[4];
                for(int i = 1; i < vectorList.length; i++)
                {
                    distance[i-1] = distance2d(tempVector, vectorList[i]);
                    tempVector = vectorList[i];
                }
                if((distance[0]==distance[1] && distance[2]==distance[3]))
                {
                    if((vectorList[4][2] != vectorList[3][2]) && (vectorList[4][2] != vectorList[2][2])&& (vectorList[4][2] != vectorList[1][2]) && (vectorList[4][2] != vectorList[0][2]))
                    {
                        answer += "Pyramid from square found \n";
                    }else
                        answer += "No pyramid from identified square found \n";
                }else
                    answer += "No square or pyramid from square found \n";

                if((distance[0] < distance[1] || distance[1] < distance[0]) && (distance[2] < distance[3] || distance[3] < distance[2]))
                {
                    if((vectorList[4][2] != vectorList[3][2]) && (vectorList[4][2] != vectorList[2][2])&& (vectorList[4][2] != vectorList[1][2]) && (vectorList[4][2] != vectorList[0][2]))
                    {
                        answer += "Pyramid from rectangle found";
                    }else
                        answer += "No pyramid from identified rectangle found";
                }else
                    answer += "No rectangle or pyramid from rectangle found";
            }
            case 8 ->
            {
                ///IMPLEMENT https://math.stackexchange.com/questions/1629899/given-eight-vertices-how-to-verify-they-form-a-cube
                //Making a matrix full of distances between points
                double[][] distMatrix = new double[8][8];
                //Populate the matrix with all distances from all points
                for(int i = 0; i < vectorList.length; i++)
                {
                    for(int j = 0; j < vectorList.length; j++)
                    {
                        distMatrix[i][j] = distance3d(vectorList[i],vectorList[j]);
                    }
                }

                //Checking the distMatrix for 0 on the diagonal and that they contain 3 base lengths, 3 diagonal lengths and 1 diagonal volume length
                //In this program a base length is length 1, diagonal length is 2*1 and diagonal volume length is 3*1
                int a = 0;
                int two_a= 0;
                int three_a= 0;

                for(int k = 0; k < vectorList.length; k++)
                {
                    if(!(distMatrix[k][k]==0))
                    {
                        answer += "3-d shape";
                        break;
                    }
                    for(int l = k + 1; l < vectorList.length; l++)
                    {
                        if(distMatrix[k][l] == Math.sqrt(3.0d))
                        {
                            three_a ++;
                        }
                        else if(distMatrix[k][l] == Math.sqrt(2))
                        {
                            two_a ++;
                        }
                        else if(distMatrix[k][l] == 1)
                        {
                            a++;
                        }
                    }
                    if(a == 3 && two_a == 3 && three_a == 1 && distMatrix[k][k] == 0)
                    {
                        answer += "Cube";
                        break;
                    }
                }

                //Check if it forms a rectangular prism

                for(int i = 0; i < vectorList.length; i++)
                {
                    for(int j = i+1; j < vectorList.length; j++ )
                    {
                        if(!((distMatrix[i][j] == 1) || (distMatrix[i][j] == Math.sqrt(2)) || (distMatrix[i][j] == Math.sqrt(3))) && distMatrix[i][i] == 0)
                        {
                            answer += "3-d Rectangle";
                        }
                    }
                }
            }
        }
    return answer;
    }
}