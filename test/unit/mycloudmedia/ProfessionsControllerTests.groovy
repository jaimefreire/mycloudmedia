package mycloudmedia



import org.junit.*
import grails.test.mixin.*

@TestFor(ProfessionsController)
@Mock(Professions)
class ProfessionsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/professions/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.professionsInstanceList.size() == 0
        assert model.professionsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.professionsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.professionsInstance != null
        assert view == '/professions/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/professions/show/1'
        assert controller.flash.message != null
        assert Professions.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/professions/list'

        populateValidParams(params)
        def professions = new Professions(params)

        assert professions.save() != null

        params.id = professions.id

        def model = controller.show()

        assert model.professionsInstance == professions
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/professions/list'

        populateValidParams(params)
        def professions = new Professions(params)

        assert professions.save() != null

        params.id = professions.id

        def model = controller.edit()

        assert model.professionsInstance == professions
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/professions/list'

        response.reset()

        populateValidParams(params)
        def professions = new Professions(params)

        assert professions.save() != null

        // test invalid parameters in update
        params.id = professions.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/professions/edit"
        assert model.professionsInstance != null

        professions.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/professions/show/$professions.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        professions.clearErrors()

        populateValidParams(params)
        params.id = professions.id
        params.version = -1
        controller.update()

        assert view == "/professions/edit"
        assert model.professionsInstance != null
        assert model.professionsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/professions/list'

        response.reset()

        populateValidParams(params)
        def professions = new Professions(params)

        assert professions.save() != null
        assert Professions.count() == 1

        params.id = professions.id

        controller.delete()

        assert Professions.count() == 0
        assert Professions.get(professions.id) == null
        assert response.redirectedUrl == '/professions/list'
    }
}
