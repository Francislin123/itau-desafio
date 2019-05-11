package br.com.itau.desafioitau.core.service;

import com.nexmo.client.NexmoClientException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Francislin Dos Reis on 10/05/19.
 */
public interface UserService {

    void sendEmail(List<String> emails);

    void sendMessageForCell(List<String> cells) throws IOException, NexmoClientException;
}
