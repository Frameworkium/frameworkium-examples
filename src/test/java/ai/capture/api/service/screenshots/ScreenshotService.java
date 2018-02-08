package ai.capture.api.service.screenshots;

import ai.capture.api.constant.CaptureEndpoint;
import ai.capture.api.dto.screenshots.CreateScreenshot;
import ai.capture.api.service.BaseCaptureService;
import org.apache.http.HttpStatus;

/** Encapsulates the Capture ExecutionResponse service */
public class ScreenshotService extends BaseCaptureService {

    public void createScreenshot(CreateScreenshot createMessage) {

        getRequestSpec()
                .when()
                .body(createMessage)
                .post(CaptureEndpoint.SCREENSHOT.getUrl())
                .then()
                .assertThat().statusCode(HttpStatus.SC_CREATED);
    }

}
