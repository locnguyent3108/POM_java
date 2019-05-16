package util.ExtendReport;
import com.relevantcodes.extentreports.ExtentReports;
/*

In this class, we created an ExtentReports object and it can be reachable via getReporter() method.
Also, you need to set your ExtentReports report HTML file location.

 */
public class ExtendManager {
    private static ExtentReports extend;

    public synchronized static ExtentReports getReport() {
        if(extend == null) {
            String workingDir = System.getProperty("user.dir");
            extend = new ExtentReports(workingDir +"\\ExtentReport\\ExtentReportResult.html");
        }
        return extend;
    }
}
