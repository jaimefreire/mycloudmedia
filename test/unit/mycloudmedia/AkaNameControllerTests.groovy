package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(AkaNameController)
@Mock(AkaName)
class AkaNameControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/akaName/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.akaNameInstanceList.size() == 0
        assert model.akaNameInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.akaNameInstance != null
    }

    void testSave() {
        controller.save()

        assert model.akaNameInstance != null
        assert view == '/akaName/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/akaName/show/1'
        assert controller.flash.message != null
        assert AkaName.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/akaName/list'

        populateValidParams(params)
        def akaName = new AkaName(params)

        assert akaName.save() != null

        params.id = akaName.id

        def model = controller.show()

        assert model.akaNameInstance == akaName
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/akaName/list'

        populateValidParams(params)
        def akaName = new AkaName(params)

        assert akaName.save() != null

        params.id = akaName.id

        def model = controller.edit()

        assert model.akaNameInstance == akaName
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/akaName/list'

        response.reset()

        populateValidParams(params)
        def akaName = new AkaName(params)

        assert akaName.save() != null

        // test invalid parameters in update
        params.id = akaName.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/akaName/edit"
        assert model.akaNameInstance != null

        akaName.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/akaName/show/$akaName.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        akaName.clearErrors()

        populateValidParams(params)
        params.id = akaName.id
        params.version = -1
        controller.update()

        assert view == "/akaName/edit"
        assert model.akaNameInstance != null
        assert model.akaNameInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/akaName/list'

        response.reset()

        populateValidParams(params)
        def akaName = new AkaName(params)

        assert akaName.save() != null
        assert AkaName.count() == 1

        params.id = akaName.id

        controller.delete()

        assert AkaName.count() == 0
        assert AkaName.get(akaName.id) == null
        assert response.redirectedUrl == '/akaName/list'
    }
}
