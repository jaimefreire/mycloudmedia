package grails.plugin.databasesession



import org.junit.*
import grails.test.mixin.*

@TestFor(PersistentSessionController)
@Mock(PersistentSession)
class PersistentSessionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/persistentSession/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.persistentSessionInstanceList.size() == 0
        assert model.persistentSessionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.persistentSessionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.persistentSessionInstance != null
        assert view == '/persistentSession/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/persistentSession/show/1'
        assert controller.flash.message != null
        assert PersistentSession.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSession/list'

        populateValidParams(params)
        def persistentSession = new PersistentSession(params)

        assert persistentSession.save() != null

        params.id = persistentSession.id

        def model = controller.show()

        assert model.persistentSessionInstance == persistentSession
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSession/list'

        populateValidParams(params)
        def persistentSession = new PersistentSession(params)

        assert persistentSession.save() != null

        params.id = persistentSession.id

        def model = controller.edit()

        assert model.persistentSessionInstance == persistentSession
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSession/list'

        response.reset()

        populateValidParams(params)
        def persistentSession = new PersistentSession(params)

        assert persistentSession.save() != null

        // test invalid parameters in update
        params.id = persistentSession.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/persistentSession/edit"
        assert model.persistentSessionInstance != null

        persistentSession.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/persistentSession/show/$persistentSession.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        persistentSession.clearErrors()

        populateValidParams(params)
        params.id = persistentSession.id
        params.version = -1
        controller.update()

        assert view == "/persistentSession/edit"
        assert model.persistentSessionInstance != null
        assert model.persistentSessionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/persistentSession/list'

        response.reset()

        populateValidParams(params)
        def persistentSession = new PersistentSession(params)

        assert persistentSession.save() != null
        assert PersistentSession.count() == 1

        params.id = persistentSession.id

        controller.delete()

        assert PersistentSession.count() == 0
        assert PersistentSession.get(persistentSession.id) == null
        assert response.redirectedUrl == '/persistentSession/list'
    }
}
