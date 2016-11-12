package dynamic.algo.service;

import dynamic.algo.data.DataHolder;
import dynamic.algo.data.Item;
import java.util.ArrayList;

/**
 * Created by papu bhattacharya on 12/11/16.
 */
public class DynamicAlgo {
    public DataHolder s;
    /**
     * Constructor for Dynamic algo.
     * @param s, outcome that will be determined in the class
     */
    public DynamicAlgo(DataHolder s)
    {
        this.s = s;
    }
    /**
     * findOptimal method creates a Knapsack using the dynamic programming approach
     * It begins by forming an array that will hold all of the best solutions to the sub problems
     * of the knapsack problem by finding the maximum profit of each item at each weight. The
     * value in the bottom right of the array is the maximum profit that can be attained as it
     * takes into account all of the subproblems.
     * @return a DataHolder containing the optimal solution
     */
    public DataHolder findOptimal()
    {
        //creates arraylist of items in the data set
        ArrayList<Item> items = s.items;
        s.items = new ArrayList<Item>();
        //creates array that will contain the optimal solution as well as the solution to the sub problems
        int[][] array = new int[items.size()][s.maxTime+1];
        //creates an array containing the items that are in the optimal solution
        int[][] itemsToKeep = new int[items.size()][s.maxTime+1];

        //sets all items of item number 0 to 0 for all timeslots up to the max time
        array[0][0] = 0;
        for(int a = 0; a < s.maxTime; a++) {
            array[0][a] = 0;
        }
        //loops through the item numbers
        for(int i = 1; i < array.length; i++)
        {
            //loops through the item weights - finds the optimal solution for the given item and the given imeslot in the array
            for(int j = 1; j < array[i].length; j++)
            {
                if(items.get(i).time <= j && items.get(i).satisfaction + array[i-1][j-items.get(i).time] >= array[i-1][j])
                {
                    array[i][j] = (items.get(i).satisfaction + array[i-1][j-items.get(i).time]);
                    itemsToKeep[i][j] = 1;
                }
                else {
                    array[i][j] = array[i-1][j];
                    itemsToKeep[i][j] = 0;
                }
            }
        }
        int time = s.maxTime;
        int counter = 0;
        //Determines which items were kept in the optimal solution of the problem
        for(int i = items.size()-1; i >= 0 ; i--) {
            if(itemsToKeep[i][time] == 1)
            {
                s.items.add(items.get(i));
                time-=items.get(i).time;
                counter += items.get(i).time;
            }
        }
        //sets the total satisfaction to the item in the bottom right corner of the array which is the optimal solution ot the problem
        s.setSatisfaction(array[items.size()-1][s.maxTime]);
        //returns the optimal solution in the form of a knapsack
        return s;
    }

}
