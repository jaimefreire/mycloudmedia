package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(MovieInfoIdxController)
@Mock(MovieInfoIdx)
class MovieInfoIdxControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/movieInfoIdx/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.movieInfoIdxInstanceList.size() == 0
        assert model.movieInfoIdxInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.movieInfoIdxInstance != null
    }

    void testSave() {
        controller.save()

        assert model.movieInfoIdxInstance != null
        assert view == '/movieInfoIdx/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/movieInfoIdx/show/1'
        assert controller.flash.message != null
        assert MovieInfoIdx.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/movieInfoIdx/list'

        populateValidParams(params)
        def movieInfoIdx = new MovieInfoIdx(params)

        assert movieInfoIdx.save() != null

        params.id = movieInfoIdx.id

        def model = controller.show()

        assert model.movieInfoIdxInstance == movieInfoIdx
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/movieInfoIdx/list'

        populateValidParams(params)
        def movieInfoIdx = new MovieInfoIdx(params)

        assert movieInfoIdx.save() != null

        params.id = movieInfoIdx.id

        def model = controller.edit()

        assert model.movieInfoIdxInstance == movieInfoIdx
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/movieInfoIdx/list'

        response.reset()

        populateValidParams(params)
        def movieInfoIdx = new MovieInfoIdx(params)

        assert movieInfoIdx.save() != null

        // test invalid parameters in update
        params.id = movieInfoIdx.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/movieInfoIdx/edit"
        assert model.movieInfoIdxInstance != null

        movieInfoIdx.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/movieInfoIdx/show/$movieInfoIdx.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        movieInfoIdx.clearErrors()

        populateValidParams(params)
        params.id = movieInfoIdx.id
        params.version = -1
        controller.update()

        assert view == "/movieInfoIdx/edit"
        assert model.movieInfoIdxInstance != null
        assert model.movieInfoIdxInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/movieInfoIdx/list'

        response.reset()

        populateValidParams(params)
        def movieInfoIdx = new MovieInfoIdx(params)

        assert movieInfoIdx.save() != null
        assert MovieInfoIdx.count() == 1

        params.id = movieInfoIdx.id

        controller.delete()

        assert MovieInfoIdx.count() == 0
        assert MovieInfoIdx.get(movieInfoIdx.id) == null
        assert response.redirectedUrl == '/movieInfoIdx/list'
    }
}
