package dynamic.algo.data;

import java.util.ArrayList;

/**
 * Created by papu bhattacharya on 10/11/16.
 */
public class DataHolder {

    public int maxTime;
    public int timeSlice;
    public ArrayList<Item> items;
    public int satisfaction;

    public int getTimeSlice() {
        return timeSlice;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    /**
     * Constructor of DataHolder creates a bucket
     * @param maxTime, the maximum time that can be placed in the knapsack
     */
    public DataHolder(int maxTime)
    {
        this.maxTime = maxTime;
        this.items=new ArrayList<Item>();
        this.satisfaction = 0;
    }
    public DataHolder(int maxTime, ArrayList<Item> i)
    {
        this.maxTime = maxTime;
        this.items = i;
        this.satisfaction = 0;
    }
    /**
     * setSatisfaction sets the satisfaction of the problem
     * @param satisfaction, an int determining the satisfaction.
     */
    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }
    /**
     * setTime sets the time of the eating
     * @param time, an int determining the time.
     */
    public void setTime(int time) {
        this.timeSlice = time;
    }
    /**
     * calculateSatisfaction determines the total satisfaction of the items in the knapsack and stores
     * it as the satisfaction of the problem.
     */
    public void calculateSatisfaction() {
        int counter = 0;
        for(Item i: items)
            counter+=i.satisfaction;
        this.satisfaction = counter;
    }
    /**
     * calculateTime determines the total time of the items in the DataHolder and stores
     * it as the time of the problem.
     */
    public void calculateTime() {
        int counter = 0;
        for(Item i: items)
            counter+=i.time;
        this.timeSlice = counter;
    }

}
