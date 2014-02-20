package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(MovieInfoController)
@Mock(MovieInfo)
class MovieInfoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/movieInfo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.movieInfoInstanceList.size() == 0
        assert model.movieInfoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.movieInfoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.movieInfoInstance != null
        assert view == '/movieInfo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/movieInfo/show/1'
        assert controller.flash.message != null
        assert MovieInfo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/movieInfo/list'

        populateValidParams(params)
        def movieInfo = new MovieInfo(params)

        assert movieInfo.save() != null

        params.id = movieInfo.id

        def model = controller.show()

        assert model.movieInfoInstance == movieInfo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/movieInfo/list'

        populateValidParams(params)
        def movieInfo = new MovieInfo(params)

        assert movieInfo.save() != null

        params.id = movieInfo.id

        def model = controller.edit()

        assert model.movieInfoInstance == movieInfo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/movieInfo/list'

        response.reset()

        populateValidParams(params)
        def movieInfo = new MovieInfo(params)

        assert movieInfo.save() != null

        // test invalid parameters in update
        params.id = movieInfo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/movieInfo/edit"
        assert model.movieInfoInstance != null

        movieInfo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/movieInfo/show/$movieInfo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        movieInfo.clearErrors()

        populateValidParams(params)
        params.id = movieInfo.id
        params.version = -1
        controller.update()

        assert view == "/movieInfo/edit"
        assert model.movieInfoInstance != null
        assert model.movieInfoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/movieInfo/list'

        response.reset()

        populateValidParams(params)
        def movieInfo = new MovieInfo(params)

        assert movieInfo.save() != null
        assert MovieInfo.count() == 1

        params.id = movieInfo.id

        controller.delete()

        assert MovieInfo.count() == 0
        assert MovieInfo.get(movieInfo.id) == null
        assert response.redirectedUrl == '/movieInfo/list'
    }
}
