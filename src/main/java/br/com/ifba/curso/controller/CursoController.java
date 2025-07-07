package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoService;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;

public class CursoController implements CursoIController {
    
    // O Controller conversa com o Service
    private final CursoIService cursoService = new CursoService();

    @Override
    public Curso saveCurso(Curso curso) {
        return this.cursoService.saveCurso(curso);
    }

    @Override
    public Curso updateCurso(Curso curso) {
        return this.cursoService.updateCurso(curso);
    }

    @Override
    public void deleteCurso(Curso curso) {
        this.cursoService.deleteCurso(curso);
    }

    @Override
    public List<Curso> findAllCursos() {
        return this.cursoService.findAllCursos();
    }
}