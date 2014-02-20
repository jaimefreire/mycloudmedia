package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(CastInfoController)
@Mock(CastInfo)
class CastInfoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/castInfo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.castInfoInstanceList.size() == 0
        assert model.castInfoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.castInfoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.castInfoInstance != null
        assert view == '/castInfo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/castInfo/show/1'
        assert controller.flash.message != null
        assert CastInfo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/castInfo/list'

        populateValidParams(params)
        def castInfo = new CastInfo(params)

        assert castInfo.save() != null

        params.id = castInfo.id

        def model = controller.show()

        assert model.castInfoInstance == castInfo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/castInfo/list'

        populateValidParams(params)
        def castInfo = new CastInfo(params)

        assert castInfo.save() != null

        params.id = castInfo.id

        def model = controller.edit()

        assert model.castInfoInstance == castInfo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/castInfo/list'

        response.reset()

        populateValidParams(params)
        def castInfo = new CastInfo(params)

        assert castInfo.save() != null

        // test invalid parameters in update
        params.id = castInfo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/castInfo/edit"
        assert model.castInfoInstance != null

        castInfo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/castInfo/show/$castInfo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        castInfo.clearErrors()

        populateValidParams(params)
        params.id = castInfo.id
        params.version = -1
        controller.update()

        assert view == "/castInfo/edit"
        assert model.castInfoInstance != null
        assert model.castInfoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/castInfo/list'

        response.reset()

        populateValidParams(params)
        def castInfo = new CastInfo(params)

        assert castInfo.save() != null
        assert CastInfo.count() == 1

        params.id = castInfo.id

        controller.delete()

        assert CastInfo.count() == 0
        assert CastInfo.get(castInfo.id) == null
        assert response.redirectedUrl == '/castInfo/list'
    }
}
