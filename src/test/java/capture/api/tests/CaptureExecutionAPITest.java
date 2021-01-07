package capture.api.tests;

import capture.api.dto.executions.CreateExecution;
import capture.api.dto.screenshots.CreateScreenshot;
import capture.api.service.executions.ExecutionService;
import capture.api.service.screenshots.ScreenshotService;
import com.frameworkium.core.api.tests.BaseAPITest;
import org.openqa.selenium.NotFoundException;
import org.testng.annotations.*;

import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

/** Tests for the Capture execution API. */
@Ignore("Currently there is no capture instance to test against")
public class CaptureExecutionAPITest extends BaseAPITest {

    private CreateExecution createExMessage;
    private String executionID;

    /**
     * Using {@link BeforeClass} to ensure anything like:
     * https://github.com/cbeust/testng/issues/1660
     * gets caught before we release.
     * This, with threads, is a common pattern.
     */
    @BeforeClass
    public void create_execution() {
        createExMessage = CreateExecution.newCreateInstance();
        executionID = new ExecutionService()
                .createExecution(createExMessage)
                .executionID;
    }

    //@Test
    public void execution_appears_in_results() {
        var latestExecutions = new ExecutionService().getExecutions(1, 10);

        assertThat(latestExecutions.total)
                .isAtLeast(latestExecutions.results.size());

        var filteredExecutions =
                latestExecutions.results.stream()
                        .filter(ex -> executionID.equals(ex.executionID))
                        .collect(Collectors.toList());

        // ensure only one with our expected ID
        assertThat(filteredExecutions).hasSize(1);

        var response = filteredExecutions.get(0);
        assertThat(response.createdFrom(createExMessage)).isTrue();
    }

    //@Test
    public void new_execution_has_status_new_and_last_updated_equals_created() {
        String id = new ExecutionService()
                .createExecution(createExMessage)
                .executionID;
        var response = new ExecutionService()
                .getExecutions(1, 20)
                .results.stream()
                .filter(ex -> id.equals(ex.executionID))
                .findFirst().orElseThrow(NotFoundException::new);
        assertThat(response.currentStatus).isEqualTo("new");
        assertThat(response.lastUpdated).isEqualTo(response.created);
    }

    //@Test
    public void can_add_then_view_screenshot() {
        var createScreenshot = CreateScreenshot.newInstance(executionID);
        new ScreenshotService().createScreenshot(createScreenshot);

        var returnedScreenshot =
                new ExecutionService().getExecution(executionID).screenshots.get(0);
        assertThat(returnedScreenshot.command).isEqualTo(createScreenshot.command);
        assertThat(returnedScreenshot.imageURL).endsWith(".png");
    }
}
