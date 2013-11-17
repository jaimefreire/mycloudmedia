package mycloudmedia

class Media {
    String title
    Date releaseDate
    String ISBN
    Person people
    Rating rating

    static hasMany = [people: Person]

    String toString() { title }

    static mapping = {
        cache true
    }
}