package com.kathy.mentoring.model.create;

public class Create {
    private String description;
    private Boolean _public;
    private Files files;


    public Create() {

    }

    public String getDescription() {
        return description;
    }

    public Boolean get_public() {
        return _public;
    }

    public Files getFiles() {
        return files;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void set_public(Boolean _public) {
        this._public = _public;
    }

    public void setFiles(Files files) {
        this.files = files;
    }
}
