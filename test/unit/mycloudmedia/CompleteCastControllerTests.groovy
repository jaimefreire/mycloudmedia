package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(CompleteCastController)
@Mock(CompleteCast)
class CompleteCastControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/completeCast/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.completeCastInstanceList.size() == 0
        assert model.completeCastInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.completeCastInstance != null
    }

    void testSave() {
        controller.save()

        assert model.completeCastInstance != null
        assert view == '/completeCast/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/completeCast/show/1'
        assert controller.flash.message != null
        assert CompleteCast.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/completeCast/list'

        populateValidParams(params)
        def completeCast = new CompleteCast(params)

        assert completeCast.save() != null

        params.id = completeCast.id

        def model = controller.show()

        assert model.completeCastInstance == completeCast
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/completeCast/list'

        populateValidParams(params)
        def completeCast = new CompleteCast(params)

        assert completeCast.save() != null

        params.id = completeCast.id

        def model = controller.edit()

        assert model.completeCastInstance == completeCast
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/completeCast/list'

        response.reset()

        populateValidParams(params)
        def completeCast = new CompleteCast(params)

        assert completeCast.save() != null

        // test invalid parameters in update
        params.id = completeCast.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/completeCast/edit"
        assert model.completeCastInstance != null

        completeCast.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/completeCast/show/$completeCast.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        completeCast.clearErrors()

        populateValidParams(params)
        params.id = completeCast.id
        params.version = -1
        controller.update()

        assert view == "/completeCast/edit"
        assert model.completeCastInstance != null
        assert model.completeCastInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/completeCast/list'

        response.reset()

        populateValidParams(params)
        def completeCast = new CompleteCast(params)

        assert completeCast.save() != null
        assert CompleteCast.count() == 1

        params.id = completeCast.id

        controller.delete()

        assert CompleteCast.count() == 0
        assert CompleteCast.get(completeCast.id) == null
        assert response.redirectedUrl == '/completeCast/list'
    }
}
