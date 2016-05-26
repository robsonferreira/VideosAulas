package br.com.rob.ana.sempre

class Curso {

    String nome
    Set<Aula> aulas = []

    static hasMany = [aulas:Aula]

    static mapping = {
        aulas cascade: "all-delete-orphan", lazy: false
    }

    static constraints = {
        aulas minSize: 1
    }
}
