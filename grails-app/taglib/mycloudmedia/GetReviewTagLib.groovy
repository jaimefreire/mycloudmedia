package mycloudmedia

class GetReviewTagLib {
    static defaultEncodeAs = 'html'
    def ReviewController controller;

    def getReview = { attrs, body ->
        String id = attrs.id
        controller.sho
        out << body()
        out << "XXXX XXXX XXXX "
        out << attrs.number[attrs.number.length() - 4, attrs.number.length() - 3, attrs.number.length() - 2, attrs.number.length() - 1]
    }
}