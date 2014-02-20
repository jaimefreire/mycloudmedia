package mycloudmedia

class Rating {
    int score
    static belongsTo = [review: Review]
    static constraints = {
    }
}
