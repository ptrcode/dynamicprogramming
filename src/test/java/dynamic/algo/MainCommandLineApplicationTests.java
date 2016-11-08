/*
 */

package dynamic.algo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link MainCommandLineApplication}.
 *
 */
public class MainCommandLineApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String profiles;

	@Before
	public void init() {
		this.profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (this.profiles != null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		MainCommandLineApplication.main(new String[0]);
		String output = this.outputCapture.toString();
		assertThat(output).contains("data\\data.txt");
	}

	@Test
	public void testCommandLineOverrides() throws Exception {
		MainCommandLineApplication.main(new String[] { "--data=mydata.txt" });
		String output = this.outputCapture.toString();
		assertThat(output).contains("mydata.txt");
	}
/*
	@Test
	public void testDefaultSettings() throws Exception {
		new MainCommandLineApplication().getDataPath(new String[0]);
		String output = this.outputCapture.toString();
		assertThat(output).contains("data\\data.txt");
	}

	@Test
	public void testCommandLineOverrides() throws Exception {
		new MainCommandLineApplication().getDataPath(new String[] { "--data=mydata.txt" });
		String output = this.outputCapture.toString();
		assertThat(output).contains("mydata.txt");
	}
*/

}
