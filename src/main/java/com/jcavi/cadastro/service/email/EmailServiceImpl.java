package com.jcavi.cadastro.service.email;

import com.jcavi.cadastro.entity.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class EmailServiceImpl implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void confirmacaoEmailPedido(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = simpleMailMessage(pedido);
        enviarEmail(simpleMailMessage);
    }

    private SimpleMailMessage simpleMailMessage(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(pedido.getUsuario().getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("Pedido confirmado - código: " + pedido.getId());
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText(pedido.toString());
        return simpleMailMessage;
    }

}
