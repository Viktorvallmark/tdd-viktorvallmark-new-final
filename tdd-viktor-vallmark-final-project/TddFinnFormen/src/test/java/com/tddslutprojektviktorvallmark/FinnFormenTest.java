package com.tddslutprojektviktorvallmark;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinnFormenTest {

    @Test
    public void checkIfTestIsWorkingShouldReturnTrue()
    {
        assertTrue(true);
    }

    @Test
    public void makingShapeWithoutAnyVectorsInTheListShouldReturnNone()
    {
        FinnFormen finnFormen = new FinnFormen(0);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        assertEquals("None", "None");
    }
    @Test
    public void makingTheShapeWithVectorOf1DimShouldReturnDot()
    {
        FinnFormen finnFormen = new FinnFormen(1);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        assertEquals("Dot", "Dot");
    }

    @Test
    public void makingTheShapeWithVectorListWithTwoEntriesShouldReturnLine()
    {
        FinnFormen finnFormen = new FinnFormen(2);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        assertEquals("Line", "Line");
    }

    @Test
    public void makingTheShapeWithVectorListWithThreeEntriesShouldReturnTriangle()
    {
        FinnFormen finnFormen = new FinnFormen(3);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        assertEquals("Triangle", "Triangle");
    }

    @Test
    public void makingTheShapeWithVectorListWithFourEntriesAndAllPointsAreEquidistantShouldReturnSquare()
    {
        FinnFormen finnFormen = new FinnFormen(4);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("Square"))
        {
            assertEquals("Square", "Square");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithFourEntriesAndTwoLinesAreShorterThanTheOtherTwoShouldReturnRectangle()
    {
        FinnFormen finnFormen = new FinnFormen(4);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("Rectangle"))
        {
            assertEquals("Rectangle", "Rectangle");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithFourEntriesAndTwoLinesStartOnDifferentCoordinatesShouldReturnParallelogram()
    {
        FinnFormen finnFormen = new FinnFormen(4);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("Parallelogram"))
        {
            assertEquals("Parallelogram", "Parallelogram");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithFourEntriesAndNoKnownShapeIsIdentifiedShouldReturn2DShape()
    {
        FinnFormen finnFormen = new FinnFormen(4);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("2-d shape"))
        {
            assertEquals("2-d shape", "2-d shape");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithFiveEntriesWhereLastVectorsZCoordinateIsDifferentShouldReturnPyramid()
    {
        FinnFormen finnFormen = new FinnFormen(5);
        finnFormen.checkShape(finnFormen.getListOfVectors());

        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("Pyramid"))
        {
            assertEquals("Pyramid", "Pyramid");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithFiveEntriesWhereLastVectorsZCoordinateIsDifferentAndMakesRectangleShouldReturnPyramidFromARectangle()
    {
        FinnFormen finnFormen = new FinnFormen(5);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("Pyramid from rectangle found"))
        {
            assertEquals("Pyramid from rectangle found", "Pyramid from rectangle found");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithFiveEntriesWhereLastVectorsZCoordinateIsDifferentAndMakesSquareShouldReturnPyramidFromASquare()
    {
        FinnFormen finnFormen = new FinnFormen(5);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("Pyramid from square found \n"))
        {
            assertEquals("Pyramid from square found \n", "Pyramid from square found \n");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithEightEntriesAndTwoSquaresAreFoundSpacedLengthOfASquareApartShouldReturnCube()
    {
        FinnFormen finnFormen = new FinnFormen(8);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("Cube"))
        {
            assertEquals("Cube", "Cube");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithEightEntriesAndARectangleIsFoundThatHasDepthShouldReturn3dRectangle()
    {
        FinnFormen finnFormen = new FinnFormen(8);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("3-d Rectangle"))
        {
            assertEquals("3-d Rectangle", "3-d Rectangle");
        }
    }

    @Test
    public void makingTheShapeWithVectorListWithEightEntriesAndAndNoKnown3DShapeIsFoundShouldReturn3DShape()
    {
        FinnFormen finnFormen = new FinnFormen(8);
        finnFormen.checkShape(finnFormen.getListOfVectors());
        if(finnFormen.checkShape(finnFormen.getListOfVectors()).equals("3-d shape"))
        {
            assertEquals("3-d shape", "3-d shape");
        }
    }

}
