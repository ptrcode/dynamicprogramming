package dynamic.algo.data;

import java.util.ArrayList;

/**
 * Created by papu bhattacharya on 10/11/16.
 */
public class DataHolder {

    public int maxWeight;
    public int weight;
    public ArrayList<Item> items;
    public int profit;
    /**
     * Constructor of Knapsack creates a knapsack
     * @param maxWeight, the maximum weight that can be placed in the knapsack
     */
    public DataHolder(int maxWeight)
    {
        this.maxWeight = maxWeight;
        this.items=new ArrayList<Item>();
        this.profit = 0;
    }
    public DataHolder(int maxWeight, ArrayList<Item> i)
    {
        this.maxWeight = maxWeight;
        this.items = i;
        this.profit = 0;
    }
    /**
     * setProfit sets the profit of the knapsack
     * @param profit, an int determining the profit.
     */
    public void setProfit(int profit) {
        this.profit = profit;
    }
    /**
     * setProfit sets the weight of the knapsack
     * @paramprofit, an int determining the weight.
     */
    public void setWeight(int w) {
        this.weight = w;
    }
    /**
     * CalculateWrofit determines the total profit of the items in the knapsack and stores
     * it as the profit of the knapsack.
     */
    public void calculateProfit() {
        int counter = 0;
        for(Item i: items)
            counter+=i.profit;
        this.profit = counter;
    }
    /**
     * CalculateWeight determines the total weight of the items in the knapsack and stores
     * it as the weight of the knapsack.
     */
    public void calculateWeight() {
        int counter = 0;
        for(Item i: items)
            counter+=i.weight;
        this.weight = counter;
    }

}
