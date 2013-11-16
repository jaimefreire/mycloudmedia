package database
class Usuario {
    String name

    String toString() { name }

    static hasMany = [medias: Media]

    static mapping = {
        cache true
    }
}