package de.sranko_informatik.si_mailclient_jar_core.service;

import de.sranko_informatik.si_mailclient_jar_core.model.Mail;
import de.sranko_informatik.si_mailclient_jar_core.model.MailResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendMailServiceImpl implements SendMailService{

    private final JavaMailSender javaMailSender;

    public SendMailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Mail mail) throws MessagingException {

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(mail.getRecipients());
        helper.setCc(mail.getRecipientsCC());
        helper.setBcc(mail.getRecipientsBCC());
        helper.setFrom(mail.getFrom());
        helper.setSubject(mail.getSubject());
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
    }

}
