package mycloudmedia



import org.junit.*
import grails.test.mixin.*

@TestFor(GenresController)
@Mock(Genres)
class GenresControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/genres/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.genresInstanceList.size() == 0
        assert model.genresInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.genresInstance != null
    }

    void testSave() {
        controller.save()

        assert model.genresInstance != null
        assert view == '/genres/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/genres/show/1'
        assert controller.flash.message != null
        assert Genres.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/genres/list'

        populateValidParams(params)
        def genres = new Genres(params)

        assert genres.save() != null

        params.id = genres.id

        def model = controller.show()

        assert model.genresInstance == genres
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/genres/list'

        populateValidParams(params)
        def genres = new Genres(params)

        assert genres.save() != null

        params.id = genres.id

        def model = controller.edit()

        assert model.genresInstance == genres
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/genres/list'

        response.reset()

        populateValidParams(params)
        def genres = new Genres(params)

        assert genres.save() != null

        // test invalid parameters in update
        params.id = genres.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/genres/edit"
        assert model.genresInstance != null

        genres.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/genres/show/$genres.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        genres.clearErrors()

        populateValidParams(params)
        params.id = genres.id
        params.version = -1
        controller.update()

        assert view == "/genres/edit"
        assert model.genresInstance != null
        assert model.genresInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/genres/list'

        response.reset()

        populateValidParams(params)
        def genres = new Genres(params)

        assert genres.save() != null
        assert Genres.count() == 1

        params.id = genres.id

        controller.delete()

        assert Genres.count() == 0
        assert Genres.get(genres.id) == null
        assert response.redirectedUrl == '/genres/list'
    }
}
