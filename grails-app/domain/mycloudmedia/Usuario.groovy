package mycloudmedia

import java.text.SimpleDateFormat

class Usuario {
    static hasMany = [comentarios: Comment, ratings: Rating, reviews: Review]

    static hasOne = [subscripcion: Subscription]

    String email
    String password
    //Confirm the password
    String confirm
    Date fechaAlta
    String creditcard
    String cvv
    String birthDate
    int age

    //Static constructor
    {
        fechaAlta = new Date()
        subscripcion = new Subscription('inactiva')
        birthDate = Date.parse("dd/mm/yy", new Date(333367200046).getDateString());
    }


    static constraints = {
        age min: 18, max: 999
        email(blank: false, email: true)
        creditcard(creditCard: true)
        password blank: false, size: 5..15, matches: /[\S]+/, validator: { val, obj ->
            if (obj.password != obj.confirm) return 'user.password.dontmatch'
        }
    }

    //Code to be run before validation
    def beforeValidate() {
        this.age = computeAge(this.birthDate);
    }

    int computeAge(String birthDate) {
        return Calendar.getInstance().getTime().getYear() -
                new SimpleDateFormat("dd/MM/yy").parse(birthDate).getYear()
    }

}
