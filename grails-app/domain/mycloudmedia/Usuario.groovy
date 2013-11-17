package mycloudmedia

class Usuario {
    String nombre
    String apellidos
    String username
    String password
    String correo
    boolean activo
    Date fecha_nacimiento
    Subscription subscription


    static constraints = {
        nombre(blank:false,size:4..50)
        apellidos(blank:false,size:4..50)
        username(blank:false,unique: true,size:4..50)
        password(password:false,size:4..50)
        correo(blank: false, email: true, size: 4..50)
        fecha_nacimiento(blank: false, date: true)

    }


    String toString() { username }

    static hasMany = [medias: Media]

    static mapping = {
        cache true
    }
}