package mycloudmedia

class Person {
    String name

    String toString() { name }

    static hasMany = [medias: Media]

    static mapping = {
        cache true
    }
}