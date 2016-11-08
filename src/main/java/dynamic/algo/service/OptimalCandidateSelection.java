/*
 */

package dynamic.algo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OptimalCandidateSelection {

	@Value("${data:data\\data.txt}")
	private String dataPath;

	public String getDataPath() {
		return "Hello " + this.dataPath;
	}
	public String processData() {
		return "Hello " + this.dataPath;
	}
}
