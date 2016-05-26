package br.com.rob.ana.sempre

class Aula {

    String nome
    String video
    Curso curso
    Boolean baixado
    String nomeVideo

    static belongsTo = [curso: Curso]

    static constraints = {
        video maxSize: 1000
    }
}
