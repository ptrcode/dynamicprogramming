/*
 */

package dynamic.algo.service;

import dynamic.algo.data.DataHolder;
import dynamic.algo.data.Item;
import dynamic.algo.util.DataReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OptimalCandidateSelection {

    @Value("${data:./data/data.txt}")
    private String dataPath;

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public String getDataPath() {
        return "Hello " + this.dataPath;
    }

    public DataHolder processData() {
        DataReader data = new DataReader(dataPath);
        DataHolder dataHolder = data.readPoints();
        //Runs the Dynamic algo
        long startTime = System.nanoTime();
        System.out.println("\nDynamic Processing");
        int totalTime = 0;
        DynamicAlgo algo = new DynamicAlgo(dataHolder);
        DataHolder output = algo.makeKnapSack();
        System.out.print("Items in Outcome:\n");
        for (Item i : output.items) {
            System.out.print(i.toString());
            totalTime += i.time;
        }
        System.out.println("\nTotal Satisfaction: " + output.satisfaction);
        System.out.println("Total Time: " + totalTime);
        long endTime = System.nanoTime();
        System.out.println("Took " + (endTime - startTime) + " ns");
        return output;
    }
}
