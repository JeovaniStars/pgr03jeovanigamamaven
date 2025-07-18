package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j; 

@Service
@RequiredArgsConstructor
@Slf4j 
public class CursoService implements CursoIService {

    private static final String NOME_OBRIGATORIO = "O campo 'Nome' é obrigatório.";
    private static final String CURSO_NULL = "O objeto Curso não pode ser nulo.";
    private static final String ID_OBRIGATORIO_UPDATE = "Curso não existente. O ID é obrigatório para atualização.";

   private final CursoRepository cursoRepository;

    @Override
    @Transactional
    public Curso saveCurso(Curso curso) {
        log.info("[CursoService] Iniciando salvamento de curso...");
        if (curso == null) {
            log.error(CURSO_NULL);
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            log.error(NOME_OBRIGATORIO);
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }
        
        log.info("[CursoService] Curso salvo com sucesso.");
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public Curso updateCurso(Curso curso) {
        log.info("[CursoService] Iniciando atualização de curso com ID: {}", curso.getId());
        if (curso == null) {
            log.error(CURSO_NULL);
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getId() == null) {
            log.error(ID_OBRIGATORIO_UPDATE);
            throw new IllegalArgumentException(ID_OBRIGATORIO_UPDATE);
        }
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            log.error(NOME_OBRIGATORIO);
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }
        
        log.info("[CursoService] Curso atualizado com sucesso.");
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void deleteCurso(Curso curso) {
        log.info("[CursoService] Iniciando exclusão de curso com ID: {}", curso.getId());
        if (curso == null) {
            log.error(CURSO_NULL);
            throw new IllegalArgumentException(CURSO_NULL);
        }
        cursoRepository.delete(curso);
        log.info("[CursoService] Curso excluído com sucesso.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAllCursos() {
        log.info("[CursoService] Buscando todos os cursos...");
        return cursoRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Curso> findByNome(String nome) {
        log.warn("[CursoService] A busca por nome ainda não foi implementada.");
        throw new UnsupportedOperationException("Método de busca por nome não implementado no repositório.");
    }
}