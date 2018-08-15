package no.greenall.picosws.stepdefs;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import no.greenall.picosws.pages.WorkPage;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class GetSteps {


    private static final String baseUri = "https://localhost/";
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final Random random = new SecureRandom();

    private int randomResourceId;
    private int status;

    @Given("^I know that a resource does not exist$")
    public void iKnowThatDoesNotExist() throws Throwable {
        // We create nothing, so it does not exist
        randomResourceId = random.nextInt();
    }

    @When("^I navigate to the non-existent resource$")
    public void iNavigateToTheNonExistentResource() throws Throwable {

        try (WorkPage workPage = new WorkPage(Integer.toString(randomResourceId))) {
            workPage.getJsonLd();
        }
    }

    @Then("^I see that I get a (\\d+) status$")
    public void iSeeThatIGetAStatus(int expectedStatus) throws Throwable {
        assertEquals(expectedStatus, status);
    }
}
