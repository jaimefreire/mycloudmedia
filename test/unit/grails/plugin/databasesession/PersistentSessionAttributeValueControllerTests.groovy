package grails.plugin.databasesession



import org.junit.*
import grails.test.mixin.*

@TestFor(PersistentSessionAttributeValueController)
@Mock(PersistentSessionAttributeValue)
class PersistentSessionAttributeValueControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/persistentSessionAttributeValue/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.persistentSessionAttributeValueInstanceList.size() == 0
        assert model.persistentSessionAttributeValueInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.persistentSessionAttributeValueInstance != null
    }

    void testSave() {
        controller.save()

        assert model.persistentSessionAttributeValueInstance != null
        assert view == '/persistentSessionAttributeValue/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/persistentSessionAttributeValue/show/1'
        assert controller.flash.message != null
        assert PersistentSessionAttributeValue.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttributeValue/list'

        populateValidParams(params)
        def persistentSessionAttributeValue = new PersistentSessionAttributeValue(params)

        assert persistentSessionAttributeValue.save() != null

        params.id = persistentSessionAttributeValue.id

        def model = controller.show()

        assert model.persistentSessionAttributeValueInstance == persistentSessionAttributeValue
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttributeValue/list'

        populateValidParams(params)
        def persistentSessionAttributeValue = new PersistentSessionAttributeValue(params)

        assert persistentSessionAttributeValue.save() != null

        params.id = persistentSessionAttributeValue.id

        def model = controller.edit()

        assert model.persistentSessionAttributeValueInstance == persistentSessionAttributeValue
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttributeValue/list'

        response.reset()

        populateValidParams(params)
        def persistentSessionAttributeValue = new PersistentSessionAttributeValue(params)

        assert persistentSessionAttributeValue.save() != null

        // test invalid parameters in update
        params.id = persistentSessionAttributeValue.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/persistentSessionAttributeValue/edit"
        assert model.persistentSessionAttributeValueInstance != null

        persistentSessionAttributeValue.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/persistentSessionAttributeValue/show/$persistentSessionAttributeValue.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        persistentSessionAttributeValue.clearErrors()

        populateValidParams(params)
        params.id = persistentSessionAttributeValue.id
        params.version = -1
        controller.update()

        assert view == "/persistentSessionAttributeValue/edit"
        assert model.persistentSessionAttributeValueInstance != null
        assert model.persistentSessionAttributeValueInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/persistentSessionAttributeValue/list'

        response.reset()

        populateValidParams(params)
        def persistentSessionAttributeValue = new PersistentSessionAttributeValue(params)

        assert persistentSessionAttributeValue.save() != null
        assert PersistentSessionAttributeValue.count() == 1

        params.id = persistentSessionAttributeValue.id

        controller.delete()

        assert PersistentSessionAttributeValue.count() == 0
        assert PersistentSessionAttributeValue.get(persistentSessionAttributeValue.id) == null
        assert response.redirectedUrl == '/persistentSessionAttributeValue/list'
    }
}
