package com.kathy.mentoring.Properties;

public enum Properties {
    GIT_URI("gitURI"),
    TYPICODE_URI("typiCodeURI"),
    HEADER_NAME_AUTHORIZATION("headerNameAuthorization"),
    HEADER_VALUE_BEARER("headerValueBearer"),
    CONTENT_TYPE_JSON("contentTypeJson"),
    GIST_ID_STAR_PUT("gistIdStarPut"),
    GIST_ID_STAR_DELETE("gistIdStarDelete"),
    GIST_ID_PATCH("gistIdPatch"),
    ACCESS_TOKEN("accessToken"),
    USERS_TYPICODE_PATH("usersTypicodePath"),
    EXPECTED_RESPONSE_HEADER("expectedResponseHeader"),
    HEADER_CONTENT_TYPE("headerContentType");

    private String key;

    Properties(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
