package no.greenall.picosws.pages;

import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;

import java.io.IOException;

public abstract class BasePage implements AutoCloseable {
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    static final HttpRequestFactory httpRequestFactory = HTTP_TRANSPORT.createRequestFactory();

    protected BasePage() {
    }

    public abstract HttpResponse getJsonLd() throws IOException;
    public abstract HttpResponse getMarc() throws IOException;
    public abstract HttpResponse post(JsonHttpContent jsonHttpContent) throws IOException;
    public abstract HttpResponse put(JsonHttpContent jsonHttpContent) throws IOException;

    void close() {

    }

}
