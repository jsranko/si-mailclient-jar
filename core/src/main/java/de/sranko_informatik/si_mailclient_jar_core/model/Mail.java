package de.sranko_informatik.si_mailclient_jar_core.model;

import java.util.List;

public class Mail {
    private String from;
    private String subject;
    private String[] recipients;
    private String[] recipientsCC;
    private String[] recipientsBCC;
    private MailResource[] attachments;
    private Message message;

    public Mail() {
    }

    public Mail(String subject, String[]  recipients, Message message) {
        this.subject = subject;
        this.recipients = recipients;
        this.message = message;
    }

    public Mail(String from, String subject, String[]  recipients, String[]  recipientsCC, String[] recipientsBCC, MailResource[] attachments, Message message) {
        this.from = from;
        this.subject = subject;
        this.recipients = recipients;
        this.recipientsCC = recipientsCC;
        this.recipientsBCC = recipientsBCC;
        this.attachments = attachments;
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public String[]  getRecipients() {
        return recipients;
    }

    public Message getMessage() {
        return message;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setRecipients(String[]  recipients) {
        this.recipients = recipients;
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

    public String[]  getRecipientsCC() {
        return recipientsCC;
    }

    public void setRecipientsCC(String[]  recipientsCC) {
        this.recipientsCC = recipientsCC;
    }

    public String[]  getRecipientsBCC() {
        return recipientsBCC;
    }

    public void setRecipientsBCC(String[]  recipientsBCC) {
        this.recipientsBCC = recipientsBCC;
    }

    @Override
    public String toString() {

        return String.format("From: %s, Subject: %s, Recipient: %s, Attachments: %s, Message: %s",
                this.getFrom(),
                this.getSubject(),
                this.getRecipients(),
                this.getAttachments().length,
                this.getMessage());
    }
}
