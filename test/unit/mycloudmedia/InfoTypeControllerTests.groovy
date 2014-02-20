package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(InfoTypeController)
@Mock(InfoType)
class InfoTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/infoType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.infoTypeInstanceList.size() == 0
        assert model.infoTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.infoTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.infoTypeInstance != null
        assert view == '/infoType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/infoType/show/1'
        assert controller.flash.message != null
        assert InfoType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/infoType/list'

        populateValidParams(params)
        def infoType = new InfoType(params)

        assert infoType.save() != null

        params.id = infoType.id

        def model = controller.show()

        assert model.infoTypeInstance == infoType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/infoType/list'

        populateValidParams(params)
        def infoType = new InfoType(params)

        assert infoType.save() != null

        params.id = infoType.id

        def model = controller.edit()

        assert model.infoTypeInstance == infoType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/infoType/list'

        response.reset()

        populateValidParams(params)
        def infoType = new InfoType(params)

        assert infoType.save() != null

        // test invalid parameters in update
        params.id = infoType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/infoType/edit"
        assert model.infoTypeInstance != null

        infoType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/infoType/show/$infoType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        infoType.clearErrors()

        populateValidParams(params)
        params.id = infoType.id
        params.version = -1
        controller.update()

        assert view == "/infoType/edit"
        assert model.infoTypeInstance != null
        assert model.infoTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/infoType/list'

        response.reset()

        populateValidParams(params)
        def infoType = new InfoType(params)

        assert infoType.save() != null
        assert InfoType.count() == 1

        params.id = infoType.id

        controller.delete()

        assert InfoType.count() == 0
        assert InfoType.get(infoType.id) == null
        assert response.redirectedUrl == '/infoType/list'
    }
}
