package ao.bugsolutions.backend.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.bugsolutions.backend.entity.TransacaoReport;
import ao.bugsolutions.backend.service.TransacaoService;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {

    private final TransacaoService service;
    
    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:9090"})
    List<TransacaoReport> listAll(){
        return service.listTotaisTransacoesPorNomeDaLoja();
    }
}
