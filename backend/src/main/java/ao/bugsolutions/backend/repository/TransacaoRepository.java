package ao.bugsolutions.backend.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ao.bugsolutions.backend.entity.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
    List<Transacao> findAllByOrderByNomeDaLojaAscIdDesc();
}
