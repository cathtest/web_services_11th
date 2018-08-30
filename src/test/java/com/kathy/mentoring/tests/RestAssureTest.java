package com.kathy.mentoring.tests;

import com.kathy.mentoring.Properties.Properties;
import com.kathy.mentoring.Reader.ReaderSingleton;
import com.kathy.mentoring.model.user.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class RestAssureTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = ReaderSingleton.getInstance().getValue(Properties.TYPICODE_URI.getKey());
    }

    @Test
    public void checkUsersStatusCode() {
        Response response = RestAssured.when()
                .get(ReaderSingleton.getInstance().getValue(Properties.USERS_TYPICODE_PATH.getKey()))
                .andReturn();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkUsersResponseHeader() {
        Response response = RestAssured.when()
                .get(ReaderSingleton.getInstance().getValue(Properties.USERS_TYPICODE_PATH.getKey()))
                .andReturn();

        String rpContentTypeHeader = response.getHeader(ReaderSingleton.getInstance().getValue(Properties.HEADER_CONTENT_TYPE.getKey()));
        Assert.assertEquals(rpContentTypeHeader, ReaderSingleton.getInstance().getValue(Properties.EXPECTED_RESPONSE_HEADER.getKey()));
    }

    @Test
    public void checkUsersResponseBody() {
        Response response = RestAssured.when()
                .get(ReaderSingleton.getInstance().getValue(Properties.USERS_TYPICODE_PATH.getKey()))

                .andReturn();
        ResponseBody<?> responseBody = response.getBody();
        User[] posts = responseBody.as(User[].class);
        Assert.assertEquals(posts.length, 10);
    }
}
