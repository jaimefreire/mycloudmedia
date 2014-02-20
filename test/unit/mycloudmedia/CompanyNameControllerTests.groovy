package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(CompanyNameController)
@Mock(CompanyName)
class CompanyNameControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/companyName/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.companyNameInstanceList.size() == 0
        assert model.companyNameInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.companyNameInstance != null
    }

    void testSave() {
        controller.save()

        assert model.companyNameInstance != null
        assert view == '/companyName/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/companyName/show/1'
        assert controller.flash.message != null
        assert CompanyName.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/companyName/list'

        populateValidParams(params)
        def companyName = new CompanyName(params)

        assert companyName.save() != null

        params.id = companyName.id

        def model = controller.show()

        assert model.companyNameInstance == companyName
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/companyName/list'

        populateValidParams(params)
        def companyName = new CompanyName(params)

        assert companyName.save() != null

        params.id = companyName.id

        def model = controller.edit()

        assert model.companyNameInstance == companyName
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/companyName/list'

        response.reset()

        populateValidParams(params)
        def companyName = new CompanyName(params)

        assert companyName.save() != null

        // test invalid parameters in update
        params.id = companyName.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/companyName/edit"
        assert model.companyNameInstance != null

        companyName.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/companyName/show/$companyName.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        companyName.clearErrors()

        populateValidParams(params)
        params.id = companyName.id
        params.version = -1
        controller.update()

        assert view == "/companyName/edit"
        assert model.companyNameInstance != null
        assert model.companyNameInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/companyName/list'

        response.reset()

        populateValidParams(params)
        def companyName = new CompanyName(params)

        assert companyName.save() != null
        assert CompanyName.count() == 1

        params.id = companyName.id

        controller.delete()

        assert CompanyName.count() == 0
        assert CompanyName.get(companyName.id) == null
        assert response.redirectedUrl == '/companyName/list'
    }
}
