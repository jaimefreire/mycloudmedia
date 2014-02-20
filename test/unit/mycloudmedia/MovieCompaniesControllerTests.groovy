package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(MovieCompaniesController)
@Mock(MovieCompanies)
class MovieCompaniesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/movieCompanies/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.movieCompaniesInstanceList.size() == 0
        assert model.movieCompaniesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.movieCompaniesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.movieCompaniesInstance != null
        assert view == '/movieCompanies/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/movieCompanies/show/1'
        assert controller.flash.message != null
        assert MovieCompanies.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/movieCompanies/list'

        populateValidParams(params)
        def movieCompanies = new MovieCompanies(params)

        assert movieCompanies.save() != null

        params.id = movieCompanies.id

        def model = controller.show()

        assert model.movieCompaniesInstance == movieCompanies
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/movieCompanies/list'

        populateValidParams(params)
        def movieCompanies = new MovieCompanies(params)

        assert movieCompanies.save() != null

        params.id = movieCompanies.id

        def model = controller.edit()

        assert model.movieCompaniesInstance == movieCompanies
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/movieCompanies/list'

        response.reset()

        populateValidParams(params)
        def movieCompanies = new MovieCompanies(params)

        assert movieCompanies.save() != null

        // test invalid parameters in update
        params.id = movieCompanies.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/movieCompanies/edit"
        assert model.movieCompaniesInstance != null

        movieCompanies.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/movieCompanies/show/$movieCompanies.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        movieCompanies.clearErrors()

        populateValidParams(params)
        params.id = movieCompanies.id
        params.version = -1
        controller.update()

        assert view == "/movieCompanies/edit"
        assert model.movieCompaniesInstance != null
        assert model.movieCompaniesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/movieCompanies/list'

        response.reset()

        populateValidParams(params)
        def movieCompanies = new MovieCompanies(params)

        assert movieCompanies.save() != null
        assert MovieCompanies.count() == 1

        params.id = movieCompanies.id

        controller.delete()

        assert MovieCompanies.count() == 0
        assert MovieCompanies.get(movieCompanies.id) == null
        assert response.redirectedUrl == '/movieCompanies/list'
    }
}
