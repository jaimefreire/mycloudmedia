package database
class Media {
    String title

    String toString() { title }

    static belongsTo = [author: Author]

    static mapping = {
        cache true
    }
}