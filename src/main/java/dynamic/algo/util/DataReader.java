package dynamic.algo.util;

import dynamic.algo.data.DataHolder;
import dynamic.algo.data.Item;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by papu bhattacharya on 10/11/16.
 */
public class DataReader {
    public String filename;
    /**
     * Constructor for KnapsackDataReader sets the filename passed to the instance of filename in the class
     * @param filename, the file containing the knapsack information
     */
    public DataReader(String filename)
    {
        this.filename=filename;
    }
    //Create scanner object to read in the data from file
    private Scanner s;
    /**
     * readPoints method reads in the information in the data file.  It sets the first number to the number of items, the next number
     * to the maximum time, and then creates an arraylist of items for the numbers in the rest of the data file.  If the file cannot
     * be the user is notified that the file cannot be opened
     * @paramfilename, the name of the file containing the knapsack data
     * @return, Knapsack that has all of the information contained in the file in the form of a knapsack
     */
    public DataHolder readPoints()
    {
        //Makes sure the file can be opened
        try
        {
            this.s = new Scanner(new BufferedReader(new FileReader(filename)));
        }
        catch (IOException e)
        {
            System.err.println("Cannot open file");
        }
        int totalTime=0;
        //sets total time to the next int in the file
        if(s.hasNext())
        {
            totalTime=s.nextInt();
        }

        int numItems=0;
        //sets num items to the first int in the file
        if(s.hasNext())
        {
            numItems=s.nextInt();
        }
        //creates a data holder object
        DataHolder dataHolder=new DataHolder(totalTime);
        for(int j=0; j<numItems; j++)
        {
            // adds all the items to the knapsack list of items
            dataHolder.items.add(new Item(j+1, s.nextInt(),s.nextInt()));
        }
        // Sorts the items by the ratio of their satisfaction to time
        Collections.sort(dataHolder.items);
        // adds the object representing the "top" of the tree
        dataHolder.items.add(0,new Item(0,0,0));
        return dataHolder;
    }
}
