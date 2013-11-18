package mycloudmedia



import org.junit.*
import grails.test.mixin.*

@TestFor(ReviewsController)
@Mock(Reviews)
class ReviewsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/reviews/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reviewsInstanceList.size() == 0
        assert model.reviewsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.reviewsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.reviewsInstance != null
        assert view == '/reviews/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/reviews/show/1'
        assert controller.flash.message != null
        assert Reviews.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/reviews/list'

        populateValidParams(params)
        def reviews = new Reviews(params)

        assert reviews.save() != null

        params.id = reviews.id

        def model = controller.show()

        assert model.reviewsInstance == reviews
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/reviews/list'

        populateValidParams(params)
        def reviews = new Reviews(params)

        assert reviews.save() != null

        params.id = reviews.id

        def model = controller.edit()

        assert model.reviewsInstance == reviews
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/reviews/list'

        response.reset()

        populateValidParams(params)
        def reviews = new Reviews(params)

        assert reviews.save() != null

        // test invalid parameters in update
        params.id = reviews.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/reviews/edit"
        assert model.reviewsInstance != null

        reviews.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/reviews/show/$reviews.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        reviews.clearErrors()

        populateValidParams(params)
        params.id = reviews.id
        params.version = -1
        controller.update()

        assert view == "/reviews/edit"
        assert model.reviewsInstance != null
        assert model.reviewsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/reviews/list'

        response.reset()

        populateValidParams(params)
        def reviews = new Reviews(params)

        assert reviews.save() != null
        assert Reviews.count() == 1

        params.id = reviews.id

        controller.delete()

        assert Reviews.count() == 0
        assert Reviews.get(reviews.id) == null
        assert response.redirectedUrl == '/reviews/list'
    }
}
