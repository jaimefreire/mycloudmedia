package mycloudmedia

class Subscription {

    {

    }

    def Usuario user
    static belongsTo = [Usuario]
    String type


    static constraints = {
        type(blank: false, inList: ['flat-week', 'flat-month', 'one', 'five', 'inactiva'])

    }

    Subscription(String myType) {
        type = myType
    }
}
