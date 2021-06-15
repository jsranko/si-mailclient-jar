package de.sranko_informatik.si_mailclient_jar_core.service;

import de.sranko_informatik.si_mailclient_jar_core.model.Mail;

import javax.mail.MessagingException;

public interface SendMailService {

    void sendMail(Mail mail) throws MessagingException;

}
