package com.jcavi.cadastro.service.email;

import com.jcavi.cadastro.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void confirmacaoEmailPedido(Pedido pedido);
    void enviarEmail(SimpleMailMessage simpleMailMessage);

}
