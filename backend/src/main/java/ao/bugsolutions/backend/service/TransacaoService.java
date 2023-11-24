package ao.bugsolutions.backend.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import ao.bugsolutions.backend.entity.TipoTransacao;
import ao.bugsolutions.backend.entity.Transacao;
import ao.bugsolutions.backend.entity.TransacaoReport;
import ao.bugsolutions.backend.repository.TransacaoRepository;

@Service
public class TransacaoService {

    private TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<TransacaoReport> listTotaisTransacoesPorNomeDaLoja() {

        var transacoes = repository.findAllByOrderByNomeDaLojaAscIdDesc();

        var reportMap = new LinkedHashMap<String, TransacaoReport>();

        transacoes.forEach(transacao ->{
            String nomeDaLoja = transacao.nomeDaLoja();
            var valor = transacao.valor(); 
            // var tipoTransacao = TipoTransacao.findByTipo(transacao.tipo());
            // BigDecimal valor = transacao.valor().multiply(
            //     tipoTransacao.getSinal()
            // );

            reportMap.compute(nomeDaLoja, (key, existingReport) ->{
                var report = (existingReport != null) ? existingReport 
                : new TransacaoReport(key, BigDecimal.ZERO, new ArrayList<>());
                return report.addTotal(valor).addTransacao(transacao);

            });
        });

        return new ArrayList<>(reportMap.values());
    }

}
