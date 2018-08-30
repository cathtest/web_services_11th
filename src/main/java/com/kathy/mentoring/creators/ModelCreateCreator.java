package com.kathy.mentoring.creators;

import com.google.gson.Gson;
import com.kathy.mentoring.model.create.Create;
import com.kathy.mentoring.model.create.Files;
import com.kathy.mentoring.model.create.Name;

public class ModelCreateCreator {

    public String createJson(){

        Gson gson = new Gson();
        Files files = new Files();
        Create create = new Create();
        Name name = new Name();
        name.setContent("HelloWorld");
        files.setName(name);

        create.set_public(false);
        create.setDescription("WorldHello");
        create.setFiles(files);
        String json = gson.toJson(create);

        return json;
    }
}
