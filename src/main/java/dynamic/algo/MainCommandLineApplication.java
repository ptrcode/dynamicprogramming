/*
test exams code - copyright free
  */

/**
 * Created by papu bhattacharya on 10/11/16.
 */

package dynamic.algo;

import dynamic.algo.data.DataHolder;
import dynamic.algo.service.OptimalCandidateSelection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainCommandLineApplication implements CommandLineRunner {

	// this is command line spring application can execute an
	// injected bean service. Also passing @Value to inject
	// command line args ('--name=whatever') or application properties

    //calling the algo through this stub
	@Autowired
	private OptimalCandidateSelection optimalCandidateSelection;
    //Main run method
	@Override
	public void run(String... args) {
		DataHolder output =optimalCandidateSelection.processData();
		if (args.length > 0 && args[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public  void getDataPath(String... args){
		System.out.println(this.optimalCandidateSelection.getDataPath());
		if (args.length > 0 && args[0].equals("exitcode")) {
			throw new ExitException();
		}
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainCommandLineApplication.class, args);
	}

}
