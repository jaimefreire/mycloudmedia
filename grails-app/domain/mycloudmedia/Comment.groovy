package mycloudmedia

class Comment {

    List comments
    static belongsTo = Review
    static hasMany = [comments: Comment]
    String author
    String texto
    Date fecha
    boolean denunciado

    static constraints = {
        texto(maxSize: 999999)
        author(size: 3..30)
    }
}
