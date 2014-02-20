package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(MovieKeywordController)
@Mock(MovieKeyword)
class MovieKeywordControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/movieKeyword/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.movieKeywordInstanceList.size() == 0
        assert model.movieKeywordInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.movieKeywordInstance != null
    }

    void testSave() {
        controller.save()

        assert model.movieKeywordInstance != null
        assert view == '/movieKeyword/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/movieKeyword/show/1'
        assert controller.flash.message != null
        assert MovieKeyword.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/movieKeyword/list'

        populateValidParams(params)
        def movieKeyword = new MovieKeyword(params)

        assert movieKeyword.save() != null

        params.id = movieKeyword.id

        def model = controller.show()

        assert model.movieKeywordInstance == movieKeyword
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/movieKeyword/list'

        populateValidParams(params)
        def movieKeyword = new MovieKeyword(params)

        assert movieKeyword.save() != null

        params.id = movieKeyword.id

        def model = controller.edit()

        assert model.movieKeywordInstance == movieKeyword
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/movieKeyword/list'

        response.reset()

        populateValidParams(params)
        def movieKeyword = new MovieKeyword(params)

        assert movieKeyword.save() != null

        // test invalid parameters in update
        params.id = movieKeyword.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/movieKeyword/edit"
        assert model.movieKeywordInstance != null

        movieKeyword.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/movieKeyword/show/$movieKeyword.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        movieKeyword.clearErrors()

        populateValidParams(params)
        params.id = movieKeyword.id
        params.version = -1
        controller.update()

        assert view == "/movieKeyword/edit"
        assert model.movieKeywordInstance != null
        assert model.movieKeywordInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/movieKeyword/list'

        response.reset()

        populateValidParams(params)
        def movieKeyword = new MovieKeyword(params)

        assert movieKeyword.save() != null
        assert MovieKeyword.count() == 1

        params.id = movieKeyword.id

        controller.delete()

        assert MovieKeyword.count() == 0
        assert MovieKeyword.get(movieKeyword.id) == null
        assert response.redirectedUrl == '/movieKeyword/list'
    }
}
