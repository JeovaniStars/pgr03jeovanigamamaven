package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository; // Importamos o repositório do Spring Data
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service 
public class CursoService implements CursoIService {

    private static final String NOME_OBRIGATORIO = "O campo 'Nome' é obrigatório.";
    private static final String CURSO_NULL = "O objeto Curso não pode ser nulo.";
    private static final String ID_OBRIGATORIO_UPDATE = "Curso não existente. O ID é obrigatório para atualização.";

    @Autowired 
    private CursoRepository cursoRepository;

    @Override
    @Transactional 
    public Curso saveCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }

        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public Curso updateCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getId() == null) {
            throw new IllegalArgumentException(ID_OBRIGATORIO_UPDATE);
        }
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }
        
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void deleteCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException(CURSO_NULL);
        }
        cursoRepository.delete(curso);
    }

    @Override
    @Transactional(readOnly = true) 
    public List<Curso> findAllCursos() {
        return cursoRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Curso> findByNome(String nome) {
        throw new UnsupportedOperationException("Método de busca por nome não implementado no repositório.");
    }
}