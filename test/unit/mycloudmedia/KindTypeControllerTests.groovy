package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(KindTypeController)
@Mock(KindType)
class KindTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/kindType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.kindTypeInstanceList.size() == 0
        assert model.kindTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.kindTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.kindTypeInstance != null
        assert view == '/kindType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/kindType/show/1'
        assert controller.flash.message != null
        assert KindType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/kindType/list'

        populateValidParams(params)
        def kindType = new KindType(params)

        assert kindType.save() != null

        params.id = kindType.id

        def model = controller.show()

        assert model.kindTypeInstance == kindType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/kindType/list'

        populateValidParams(params)
        def kindType = new KindType(params)

        assert kindType.save() != null

        params.id = kindType.id

        def model = controller.edit()

        assert model.kindTypeInstance == kindType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/kindType/list'

        response.reset()

        populateValidParams(params)
        def kindType = new KindType(params)

        assert kindType.save() != null

        // test invalid parameters in update
        params.id = kindType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/kindType/edit"
        assert model.kindTypeInstance != null

        kindType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/kindType/show/$kindType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        kindType.clearErrors()

        populateValidParams(params)
        params.id = kindType.id
        params.version = -1
        controller.update()

        assert view == "/kindType/edit"
        assert model.kindTypeInstance != null
        assert model.kindTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/kindType/list'

        response.reset()

        populateValidParams(params)
        def kindType = new KindType(params)

        assert kindType.save() != null
        assert KindType.count() == 1

        params.id = kindType.id

        controller.delete()

        assert KindType.count() == 0
        assert KindType.get(kindType.id) == null
        assert response.redirectedUrl == '/kindType/list'
    }
}
