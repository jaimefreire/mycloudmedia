package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(CompCastTypeController)
@Mock(CompCastType)
class CompCastTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/compCastType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.compCastTypeInstanceList.size() == 0
        assert model.compCastTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.compCastTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.compCastTypeInstance != null
        assert view == '/compCastType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/compCastType/show/1'
        assert controller.flash.message != null
        assert CompCastType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/compCastType/list'

        populateValidParams(params)
        def compCastType = new CompCastType(params)

        assert compCastType.save() != null

        params.id = compCastType.id

        def model = controller.show()

        assert model.compCastTypeInstance == compCastType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/compCastType/list'

        populateValidParams(params)
        def compCastType = new CompCastType(params)

        assert compCastType.save() != null

        params.id = compCastType.id

        def model = controller.edit()

        assert model.compCastTypeInstance == compCastType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/compCastType/list'

        response.reset()

        populateValidParams(params)
        def compCastType = new CompCastType(params)

        assert compCastType.save() != null

        // test invalid parameters in update
        params.id = compCastType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/compCastType/edit"
        assert model.compCastTypeInstance != null

        compCastType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/compCastType/show/$compCastType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        compCastType.clearErrors()

        populateValidParams(params)
        params.id = compCastType.id
        params.version = -1
        controller.update()

        assert view == "/compCastType/edit"
        assert model.compCastTypeInstance != null
        assert model.compCastTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/compCastType/list'

        response.reset()

        populateValidParams(params)
        def compCastType = new CompCastType(params)

        assert compCastType.save() != null
        assert CompCastType.count() == 1

        params.id = compCastType.id

        controller.delete()

        assert CompCastType.count() == 0
        assert CompCastType.get(compCastType.id) == null
        assert response.redirectedUrl == '/compCastType/list'
    }
}
