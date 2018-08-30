package com.kathy.mentoring.tests;

import com.kathy.mentoring.Properties.Properties;
import com.kathy.mentoring.Reader.ReaderSingleton;
import com.kathy.mentoring.creators.ModelCreateCreator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class Gist {

    private String accessToken = ReaderSingleton.getInstance().getValue(Properties.ACCESS_TOKEN.getKey());


    @BeforeTest

    public void initTest() {
        RestAssured.baseURI = ReaderSingleton.getInstance().getValue(Properties.GIT_URI.getKey());
    }


    @Test
    public void checkStatusCodeAfterCreatingGist() {


        Response response = RestAssured.given()
                .request()
                .header(
                        ReaderSingleton.getInstance().getValue(Properties.HEADER_NAME_AUTHORIZATION.getKey()),
            ReaderSingleton.getInstance().getValue(Properties.HEADER_VALUE_BEARER.getKey())+ " "+
                        accessToken)
                .body(new ModelCreateCreator().createJson())
                .post();

        System.out.println(accessToken);

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void checkStatusCodeAfterGistStarring(){

        Response response = RestAssured.given()
                .request()
                .header(
                        ReaderSingleton.getInstance().getValue(Properties.HEADER_NAME_AUTHORIZATION.getKey()),
                        ReaderSingleton.getInstance().getValue(Properties.HEADER_VALUE_BEARER.getKey()+
                        accessToken))

                .contentType(ReaderSingleton.getInstance().getValue(Properties.CONTENT_TYPE_JSON.getKey()))
                .put(ReaderSingleton.getInstance().getValue(Properties.GIST_ID_STAR_PUT.getKey()));

        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void checkStatusCodeAfterGistRemoval(){

        Response response = RestAssured.given()
                .request()
                .header(
                        ReaderSingleton.getInstance().getValue(Properties.HEADER_NAME_AUTHORIZATION.getKey()),
                        ReaderSingleton.getInstance().getValue(Properties.HEADER_VALUE_BEARER.getKey()+
                        accessToken))

                .contentType(ReaderSingleton.getInstance().getValue(Properties.CONTENT_TYPE_JSON.getKey()))
                .delete(ReaderSingleton.getInstance().getValue(Properties.GIST_ID_STAR_DELETE.getKey()));

        Assert.assertEquals(response.getStatusCode(), 204);
    }


    @Test
    public void checkStatusCodeAfterGistPatching() {


        Response response = RestAssured.given()
                .request()
                .header(
                        ReaderSingleton.getInstance().getValue(Properties.HEADER_NAME_AUTHORIZATION.getKey()),
                        ReaderSingleton.getInstance().getValue(Properties.HEADER_VALUE_BEARER.getKey())+
                        accessToken)

                .body(new ModelCreateCreator().createJson())
                .patch(ReaderSingleton.getInstance().getValue(Properties.GIST_ID_PATCH.getKey()));

        System.out.println(new ModelCreateCreator().createJson());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
