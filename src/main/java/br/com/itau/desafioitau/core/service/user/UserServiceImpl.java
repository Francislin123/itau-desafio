package br.com.itau.desafioitau.core.service.user;

import br.com.itau.desafioitau.core.exceptions.UserException;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;

/**
 * Created by Francislin Dos Reis on 10/05/19.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender mailSender;

    public static final String API_KEY = "12eb9da5";
    public static final String API_SECRET = "HtPYfKw7BdoPMfRn";
    private String msg = "Ola, somos muito felizes! ";
    private String msgEmail = "<p>Ola, somos muito felizes!</p> ";

    @Override
    public void sendEmail(List<String> emails) {

        for (String email : emails) {

            try {
                MimeMessage mail = mailSender.createMimeMessage();

                MimeMessageHelper helper = new MimeMessageHelper(mail);
                helper.setTo(email);
                helper.setSubject("E-mail inadimplente Itau Teste");
                helper.setText(msgEmail, true);
                mailSender.send(mail);
            } catch (Exception e) {
                throw new UserException("Error trying to send email", e);
            }
        }
    }

    @Override
    public void sendMessageForCell(List<String> cells) {

        for (String sms : cells) {
            AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
            NexmoClient client = new NexmoClient(auth);
            TextMessage message = new TextMessage("5511995476108", sms, msg);
            SmsSubmissionResult[] responses = new SmsSubmissionResult[0];
            try {
                responses = client.getSmsClient().submitMessage(message);
            } catch (IOException e) {
                throw new UserException("Error trying to send sms", e);
            } catch (NexmoClientException nxe) {
                throw new UserException("Error trying to send sms", nxe);
            }
            for (SmsSubmissionResult response : responses) {
                System.out.println(response);
            }
        }
    }
}
