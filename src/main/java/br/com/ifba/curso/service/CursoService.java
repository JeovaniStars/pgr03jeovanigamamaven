package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
/**
 *
 * @author Bruno
 */
public class CursoService implements CursoIService {
    
    private static final String NOME_OBRIGATORIO = "O campo 'Nome' é obrigatório.";
    private static final String CURSO_NULL = "O objeto Curso não pode ser nulo.";

    private final CursoIDao cursoDao = new CursoDao();

    @Override
    public Curso saveCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }
        return this.cursoDao.save(curso);
    }

    @Override
    public Curso updateCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getId() == null) {
            throw new IllegalArgumentException("Curso não existente. O ID é obrigatório para atualização.");
        }
         if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }
        return this.cursoDao.save(curso);
    }

    @Override
    public void deleteCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException(CURSO_NULL);
        }
        this.cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findAllCursos() {
        return this.cursoDao.findAll();
    }
    
    @Override
    public List<Curso> findByNome(String nome) {
        return this.cursoDao.findByNome(nome);
}
}