package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
// A importação da BusinessException foi removida.

public class CursoService implements CursoIService {
    
    // Constantes para as mensagens de erro
    private static final String NOME_OBRIGATORIO = "O campo 'Nome' é obrigatório.";
    private static final String CURSO_NULL = "O objeto Curso não pode ser nulo.";

    private final CursoIDao cursoDao = new CursoDao();

    @Override
    public Curso saveCurso(Curso curso) {
        if (curso == null) {
            // ALTERAÇÃO: Usando a exceção padrão do Java
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            // ALTERAÇÃO: Usando a exceção padrão do Java
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }
        return this.cursoDao.save(curso);
    }

    @Override
    public Curso updateCurso(Curso curso) {
        if (curso == null) {
            // ALTERAÇÃO: Usando a exceção padrão do Java
            throw new IllegalArgumentException(CURSO_NULL);
        }
        if (curso.getId() == null) {
            // ALTERAÇÃO: Usando a exceção padrão do Java
            throw new IllegalArgumentException("Curso não existente. O ID é obrigatório para atualização.");
        }
         if (curso.getNome() == null || curso.getNome().isBlank()) {
            // ALTERAÇÃO: Usando a exceção padrão do Java
            throw new IllegalArgumentException(NOME_OBRIGATORIO);
        }
        return this.cursoDao.save(curso);
    }

    @Override
    public void deleteCurso(Curso curso) {
        if (curso == null) {
            // ALTERAÇÃO: Usando a exceção padrão do Java
            throw new IllegalArgumentException(CURSO_NULL);
        }
        this.cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findAllCursos() {
        return this.cursoDao.findAll();
    }
}