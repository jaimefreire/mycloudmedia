package mycloudmedia

class CCFormatTagLib {
    static defaultEncodeAs = 'html'

    def formatCC = { attrs, body ->
        String number = attrs.number
        out << body()
        out << "XXXX XXXX XXXX "
        out << attrs.number[attrs.number.length() - 4, attrs.number.length() - 3, attrs.number.length() - 2, attrs.number.length() - 1]
    }
}