package no.greenall.picosws.pages;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.util.Objects;

public class WorkPage extends BasePage {

    private static final String baseUrl = "http://localhost:8080/work/";
    private static final JacksonFactory JSON_FACTORY = new JacksonFactory();
    private String pageId;

    public WorkPage(String pageId) {
        this.pageId = pageId;
    }

    @Override
    public HttpResponse getJsonLd() throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept("application/ld+json");

        return httpRequestFactory.buildGetRequest(getUrl()).setHeaders(httpHeaders).execute();
    }

    private GenericUrl getUrl() {
        if (Objects.isNull(pageId)) {
            throw new RuntimeException("WorkPage pageId is null and should be set");
        }

        return new GenericUrl(baseUrl + pageId);
    }

    @Override
    public HttpResponse getMarc() throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept("application/marc");
        return httpRequestFactory.buildGetRequest(getUrl()).setHeaders(httpHeaders).execute();
    }

    @Override
    public HttpResponse post(JsonHttpContent jsonHttpContent) throws IOException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType("application/json");
        return httpRequestFactory.buildPostRequest(getUrl(), jsonHttpContent).setHeaders(httpHeaders).execute();
    }

    @Override
    public HttpResponse put(JsonHttpContent jsonHttpContent) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType("application/json");
        return httpRequestFactory.buildPutRequest(getUrl(), jsonHttpContent).setHeaders(httpHeaders).execute();
    }
}
