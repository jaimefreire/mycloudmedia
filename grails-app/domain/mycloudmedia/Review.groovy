package mycloudmedia

class Review {
    Long movieId
    List comments

    static hasMany = [comments: Comment]
    static constraints = {
    }
}
