package grails.plugin.databasesession



import org.junit.*
import grails.test.mixin.*

@TestFor(PersistentSessionAttributeController)
@Mock(PersistentSessionAttribute)
class PersistentSessionAttributeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/persistentSessionAttribute/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.persistentSessionAttributeInstanceList.size() == 0
        assert model.persistentSessionAttributeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.persistentSessionAttributeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.persistentSessionAttributeInstance != null
        assert view == '/persistentSessionAttribute/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/persistentSessionAttribute/show/1'
        assert controller.flash.message != null
        assert PersistentSessionAttribute.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttribute/list'

        populateValidParams(params)
        def persistentSessionAttribute = new PersistentSessionAttribute(params)

        assert persistentSessionAttribute.save() != null

        params.id = persistentSessionAttribute.id

        def model = controller.show()

        assert model.persistentSessionAttributeInstance == persistentSessionAttribute
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttribute/list'

        populateValidParams(params)
        def persistentSessionAttribute = new PersistentSessionAttribute(params)

        assert persistentSessionAttribute.save() != null

        params.id = persistentSessionAttribute.id

        def model = controller.edit()

        assert model.persistentSessionAttributeInstance == persistentSessionAttribute
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttribute/list'

        response.reset()

        populateValidParams(params)
        def persistentSessionAttribute = new PersistentSessionAttribute(params)

        assert persistentSessionAttribute.save() != null

        // test invalid parameters in update
        params.id = persistentSessionAttribute.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/persistentSessionAttribute/edit"
        assert model.persistentSessionAttributeInstance != null

        persistentSessionAttribute.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/persistentSessionAttribute/show/$persistentSessionAttribute.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        persistentSessionAttribute.clearErrors()

        populateValidParams(params)
        params.id = persistentSessionAttribute.id
        params.version = -1
        controller.update()

        assert view == "/persistentSessionAttribute/edit"
        assert model.persistentSessionAttributeInstance != null
        assert model.persistentSessionAttributeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttribute/list'

        response.reset()

        populateValidParams(params)
        def persistentSessionAttribute = new PersistentSessionAttribute(params)

        assert persistentSessionAttribute.save() != null
        assert PersistentSessionAttribute.count() == 1

        params.id = persistentSessionAttribute.id

        controller.delete()

        assert PersistentSessionAttribute.count() == 0
        assert PersistentSessionAttribute.get(persistentSessionAttribute.id) == null
        assert response.redirectedUrl == '/persistentSessionAttribute/list'
    }
}
