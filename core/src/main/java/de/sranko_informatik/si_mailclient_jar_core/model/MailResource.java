package de.sranko_informatik.si_mailclient_jar_core.model;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;

import java.util.Base64;

public class MailResource {
    private String type;
    private String name;
    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public InputStreamSource getInputStreamResource(){
        byte[] decodedBytes = Base64.getDecoder().decode(this.getData());
        InputStreamSource cimageSource =new ByteArrayResource(decodedBytes);

        return cimageSource;
    }
}
