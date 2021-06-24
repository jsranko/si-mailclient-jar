package de.sranko_informatik.si_mailclient_jar_core.service;

import de.sranko_informatik.si_mailclient_jar_core.model.Mail;
import de.sranko_informatik.si_mailclient_jar_core.model.MailResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailServiceImpl implements SendMailService{

    Logger logger = LoggerFactory.getLogger(SendMailServiceImpl.class);

    private final JavaMailSender javaMailSender;

    public SendMailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Mail mail) throws MessagingException {

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        if (mail.getRecipients() != null) {
            helper.setTo(mail.getRecipients());
        }
        if (mail.getRecipientsCC() != null) {
            helper.setCc(mail.getRecipientsCC());
        }
        if (mail.getRecipientsBCC() != null) {
            helper.setBcc(mail.getRecipientsBCC());
        }
        if (mail.getFrom() != null) {
            helper.setFrom(mail.getFrom());
        }
        if (mail.getSubject() != null) {
            helper.setSubject(mail.getSubject());
        }
        if (mail.isHTML()){
            helper.setText(mail.getMessage().getText(), true);
        } else {
            helper.setText(mail.getMessage().getText());
        }

        // Add mail resources
        if (mail.getMessage().getResources() != null) {
            for (MailResource res : mail.getMessage().getResources()) {

                helper.addInline(res.getName(), res.getInputStreamResource(), res.getType());
            }
        }

        // Add mail attachments
        if (mail.getAttachments() != null) {
            for (MailResource res : mail.getAttachments()) {

                helper.addAttachment(res.getName(), res.getInputStreamResource(), res.getType());
            }
        }

        javaMailSender.send(msg);
        logger.debug("Email successful send. ".concat(mail.toString()));
    }

}
