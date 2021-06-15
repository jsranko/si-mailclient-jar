package de.sranko_informatik.si_mailclient_jar_gui;

import de.sranko_informatik.si_mailclient_jar_core.model.Mail;
import de.sranko_informatik.si_mailclient_jar_core.service.SendMailService;
import de.sranko_informatik.si_mailclient_jar_core.service.SendMailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/v1/mail/")
public class EmailController {

    Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    JavaMailSenderImpl mailServer;

    @RequestMapping(value = "/send")
    public String sendEmail(@RequestBody Mail mail) {

        logger.debug(String.format("Mail wird versendet: %s,", mail.toString()));
        logger.debug(String.format("Server %s:%s, User: %s:%s wird verwendet.",
                mailServer.getHost(),
                mailServer.getPort(),
                mailServer.getUsername(),
                mailServer.getPassword()
        ));

        SendMailService service = new SendMailServiceImpl(mailServer);

        try {
            service.sendMail(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Email send error";
        }

        return "Email sent successfully";
    }

}
