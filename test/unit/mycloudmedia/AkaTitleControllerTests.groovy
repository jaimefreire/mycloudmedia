package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(AkaTitleController)
@Mock(AkaTitle)
class AkaTitleControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/akaTitle/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.akaTitleInstanceList.size() == 0
        assert model.akaTitleInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.akaTitleInstance != null
    }

    void testSave() {
        controller.save()

        assert model.akaTitleInstance != null
        assert view == '/akaTitle/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/akaTitle/show/1'
        assert controller.flash.message != null
        assert AkaTitle.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/akaTitle/list'

        populateValidParams(params)
        def akaTitle = new AkaTitle(params)

        assert akaTitle.save() != null

        params.id = akaTitle.id

        def model = controller.show()

        assert model.akaTitleInstance == akaTitle
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/akaTitle/list'

        populateValidParams(params)
        def akaTitle = new AkaTitle(params)

        assert akaTitle.save() != null

        params.id = akaTitle.id

        def model = controller.edit()

        assert model.akaTitleInstance == akaTitle
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/akaTitle/list'

        response.reset()

        populateValidParams(params)
        def akaTitle = new AkaTitle(params)

        assert akaTitle.save() != null

        // test invalid parameters in update
        params.id = akaTitle.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/akaTitle/edit"
        assert model.akaTitleInstance != null

        akaTitle.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/akaTitle/show/$akaTitle.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        akaTitle.clearErrors()

        populateValidParams(params)
        params.id = akaTitle.id
        params.version = -1
        controller.update()

        assert view == "/akaTitle/edit"
        assert model.akaTitleInstance != null
        assert model.akaTitleInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/akaTitle/list'

        response.reset()

        populateValidParams(params)
        def akaTitle = new AkaTitle(params)

        assert akaTitle.save() != null
        assert AkaTitle.count() == 1

        params.id = akaTitle.id

        controller.delete()

        assert AkaTitle.count() == 0
        assert AkaTitle.get(akaTitle.id) == null
        assert response.redirectedUrl == '/akaTitle/list'
    }
}
