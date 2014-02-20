package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(MovieLinkController)
@Mock(MovieLink)
class MovieLinkControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/movieLink/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.movieLinkInstanceList.size() == 0
        assert model.movieLinkInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.movieLinkInstance != null
    }

    void testSave() {
        controller.save()

        assert model.movieLinkInstance != null
        assert view == '/movieLink/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/movieLink/show/1'
        assert controller.flash.message != null
        assert MovieLink.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/movieLink/list'

        populateValidParams(params)
        def movieLink = new MovieLink(params)

        assert movieLink.save() != null

        params.id = movieLink.id

        def model = controller.show()

        assert model.movieLinkInstance == movieLink
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/movieLink/list'

        populateValidParams(params)
        def movieLink = new MovieLink(params)

        assert movieLink.save() != null

        params.id = movieLink.id

        def model = controller.edit()

        assert model.movieLinkInstance == movieLink
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/movieLink/list'

        response.reset()

        populateValidParams(params)
        def movieLink = new MovieLink(params)

        assert movieLink.save() != null

        // test invalid parameters in update
        params.id = movieLink.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/movieLink/edit"
        assert model.movieLinkInstance != null

        movieLink.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/movieLink/show/$movieLink.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        movieLink.clearErrors()

        populateValidParams(params)
        params.id = movieLink.id
        params.version = -1
        controller.update()

        assert view == "/movieLink/edit"
        assert model.movieLinkInstance != null
        assert model.movieLinkInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/movieLink/list'

        response.reset()

        populateValidParams(params)
        def movieLink = new MovieLink(params)

        assert movieLink.save() != null
        assert MovieLink.count() == 1

        params.id = movieLink.id

        controller.delete()

        assert MovieLink.count() == 0
        assert MovieLink.get(movieLink.id) == null
        assert response.redirectedUrl == '/movieLink/list'
    }
}
