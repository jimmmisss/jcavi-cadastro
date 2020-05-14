package com.jcavi.cadastro.service;

import com.jcavi.cadastro.entity.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Date intante) {
        Calendar data = Calendar.getInstance();
        data.setTime(intante);
        data.add(Calendar.DAY_OF_MONTH, 15);
        pgto.setDataVencimento(data.getTime());
    }

}
