/*
 */

package dynamic.algo;

import dynamic.algo.data.DataHolder;
import dynamic.algo.service.OptimalCandidateSelection;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@link MainCommandLineApplication}.
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
        } else {
            System.clearProperty("spring.profiles.active");
        }
    }
    //
    @Test
    public void shouldExecuteAppWithoutException() throws Exception {
        assertThat(SpringApplication
                .exit(SpringApplication.run(MainCommandLineApplication.class))).isEqualTo(0);
    }

    @Test
    public void testDefaultSettings() throws Exception {
        MainCommandLineApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        System.out.println(output);
    }

    @Test
    public void testCommandLineOverrides() throws Exception {
        MainCommandLineApplication.main(new String[]{"--data=./data/data.txt"});
        String output = this.outputCapture.toString();
        System.out.println(output);
    }
    @Test
    public void testOutPutContent() throws Exception {
        OptimalCandidateSelection service = new OptimalCandidateSelection();
        service.setDataPath("./data/data.txt");
        DataHolder output = service.processData();
        //test , if the total time never exceeds 10000
        assertTrue(output.getTimeSlice() <= output.maxTime);
        //test if the output items size is greater than and less than eqaul to 100
        assertTrue(output.items.size() > 0);
        assertTrue(output.items.size() <= 100);
        System.out.println(output);
    }
    @Test
    public void testOutPutContentNotNull() throws Exception {
        OptimalCandidateSelection service = new OptimalCandidateSelection();
        service.setDataPath("./data/data.txt");
        assertNotNull("Returned object isn't null", service.processData());
        //test , if the output is not null
    }
}
