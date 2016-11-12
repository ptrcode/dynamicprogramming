package dynamic.algo.data;

/**
 * Created by papu bhattacharya on 10/11/16.
 */
/**
 * This class contains the implementation for the object of type item.  The item contains the information
 * about each item in a Knapsack (the number, satisfaction, and time of that item)
 *
 */
public class Item implements Comparable<Item>
{

    public int number;
    public int satisfaction;
    public int time;
    /**
     * Constructor for an Item
     * @param number defining the item number in the knapsack
     * @param satisfaction defining the satisfaction of the item in the knapsack
     * @param time defining the time of the item in the knapsack
     */
    public Item(int number, int satisfaction, int time)
    {
        this.number=number;
        this.satisfaction =satisfaction;
        this.time =time;
    }
    @Override
    /**
     * Implemented method from interface comparable.  Allows for a list of items
     * to be sorted by the ratio of their satisfaction to their time.
     * @param Item i defining the item to be compared to.
     * @return int	1 if (this) is > item i
     * 			   -1 if (this) is < item i
     * 				0 if (this) is = item i
     */
    public int compareTo(Item i) {
        float ratio = (float)this.satisfaction /this.time;
        float secondRatio = (float)i.satisfaction /i.time;
        if(ratio > secondRatio) {
            return -1;
        }
        else if(ratio < secondRatio) {
            return 1;
        }
        return 0;

    }
    public String toString()
    {
        return "Item: " + this.number + " satisfaction: " + this.satisfaction + " Time: " + this.time+ "\n";
    }

}
