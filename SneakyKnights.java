// Rebecca Calderon
// COP 3503
// Fall 2022
// 4877902

import java.io.*;
import java.util.*;
import java.awt.*;
import java.util.HashSet;
import java.awt.Point;



public class SneakyKnights
{
    public static int column = 0;
    public static int row = 0;


    public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateString, int boardSize) // throws Exception
    {
        // creating a hashset here
        HashSet <Point> knights = new HashSet<Point>();

        // these Points here are going to be used to hard code our knight
        // checks:
        Point upLeft;
        Point upRight;
        Point downLeft;
        Point downRight;
        Point leftUp;
        Point leftDown;
        Point rightUp;
        Point rightDown;
        Point knightPoint;


        // loop for 8 different checks:
        for (int i = 0; i < coordinateString.size(); i++)
        {
            // coordinateStrings conversion
            knightPoint = stringToNum(coordinateString.get(i));


            // COLUMN UP TWO CHECKING LEFT AND RIGHT POINT
            if ((column + 2 < boardSize) && (row - 1 < boardSize))
            {
                upLeft = new Point(column+2, row-1);
                if (knights.contains(knightPoint))
                    return false;
                else
                    knights.add(upLeft);

            }

            if ((column + 2 < boardSize) && (row + 1 < boardSize))
            {
                upRight = new Point(column+2, row+1);
                if (knights.contains(knightPoint))
                    return false;
                else  
                    knights.add(upRight);

            }

            // COLUMN DOWN TWO CHECKING LEFT AND RIGHT POINT
            if ((column - 2 < boardSize ) && (row - 1 < boardSize))
            {
                downLeft = new Point(column-2, row-1);
                if (knights.contains(knightPoint))
                    return false;
                else
                    knights.add(downLeft);

            }

            if ((column - 2 < boardSize) && (row + 1 < boardSize))
            {
                downRight = new Point(column-2, row+1);
                if (knights.contains(knightPoint))
                    return false;
                else
                    knights.add(downRight);

            }

            // ROW TO THE RIGHT CHECKING DOWN AND UP POINT
            if ((column - 1 < boardSize ) && (row + 2 < boardSize))
            {
                rightDown = new Point(column-2, row-1);
                if (knights.contains(knightPoint))
                    return false;
                else
                    knights.add(rightDown);

            }

            if ((column + 1 < boardSize) && (row + 2 < boardSize))
            {
                rightUp = new Point(column-2, row-1);
                if (knights.contains(knightPoint))
                    return false;
                else
                    knights.add(rightUp);


            }

            // ROW TO THE LEFT CHECKING DOWN AND UP POINT
            if ((column - 1 < boardSize) && (row - 2 < boardSize))
            {
                leftDown = new Point(column-2, row-1);
                if (knights.contains(knightPoint))
                    return false;
                else
                    knights.add(leftDown);

            }

            if ((column + 1 < boardSize) && (row - 2 < boardSize ))
            {
                leftUp = new Point(column-2, row-1);
                if (knights.contains(knightPoint))
                    return false;
                else
                    knights.add(leftUp);

            }

            // knight added to the list if it wasn't in the set already:
            knights.add(knightPoint);
            
        }
        // returning true if the knight was not in the hashset, with it now being added
        return true;

    }



    
    public static Point stringToNum(String col) //return point
    {
        column = 0;
        row = 0;

        for (int i = 0; i < col.length(); i++)
        {
            // checking if index is a letter
            if (Character.isLetter(col.charAt(i)))
            {

                // horner's rule -> coordinate of the letters
                column *= 26;
                column +=  (col.charAt(i) - 'a' + 1);   

            }

            // checking if index is a number
            if (Character.isDigit(col.charAt(i)))
            {
                row *= 10;
                row +=  (col.charAt(i) - '0'); 

            }

        }
        return new Point(column,row);
    }


    public static double difficultyRating()
    {
        return 4.0; 
    }
    public static double hoursSpent()
    {
        return 60.0;
    }
   

}
