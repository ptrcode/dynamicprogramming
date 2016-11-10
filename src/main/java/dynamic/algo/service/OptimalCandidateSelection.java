/*
 */

package dynamic.algo.service;

import dynamic.algo.util.DataReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import dynamic.algo.data.DataHolder;
@Component
public class OptimalCandidateSelection {

	@Value("${data:data\\data.txt}")
	private String dataPath;

	public String getDataPath() {
		return "Hello " + this.dataPath;
	}
	public String processData() {
		DataReader data = new DataReader(dataPath);
		DataHolder dataHolder = data.readPoints();

		return "Hello " + this.dataPath;
	}
}
