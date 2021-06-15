package de.sranko_informatik.si_mailclient_jar_core.model;

public class Mail {
    private String from;
    private String subject;
    private String recipient;
    private MailResource[] attachments;
    private Message message;

    public Mail() {
    }

    public Mail(String subject, String recipient, Message message) {
        this.subject = subject;
        this.recipient = recipient;
        this.message = message;
    }

    public Mail(String from, String subject, String recipient, MailResource[] attachments, Message message) {
        this.from = from;
        this.subject = subject;
        this.recipient = recipient;
        this.attachments = attachments;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public Message getMessage() {
        return message;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isHTML() {
        return getMessage().getText().matches(".*\\<[^>]+>.*");
    }

    public MailResource[] getAttachments() {
        return attachments;
    }

    public void setAttachments(MailResource[] attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {

        return String.format("From: %s, Subject: %s, Recipient: %s, Attachments: %s, Message: %s",
                this.getFrom(),
                this.getSubject(),
                this.getRecipient(),
                this.getAttachments().length,
                this.getMessage());
    }
}
