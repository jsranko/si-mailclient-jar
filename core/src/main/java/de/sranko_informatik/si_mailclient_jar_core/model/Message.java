package de.sranko_informatik.si_mailclient_jar_core.model;

public class Message {
    private String text;
    private MailResource[] resources;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MailResource[] getResources() {
        return resources;
    }

    public void setResources(MailResource[] resources) {
        this.resources = resources;
    }
}
