package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(PersonInfoController)
@Mock(PersonInfo)
class PersonInfoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/personInfo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.personInfoInstanceList.size() == 0
        assert model.personInfoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.personInfoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.personInfoInstance != null
        assert view == '/personInfo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/personInfo/show/1'
        assert controller.flash.message != null
        assert PersonInfo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/personInfo/list'

        populateValidParams(params)
        def personInfo = new PersonInfo(params)

        assert personInfo.save() != null

        params.id = personInfo.id

        def model = controller.show()

        assert model.personInfoInstance == personInfo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/personInfo/list'

        populateValidParams(params)
        def personInfo = new PersonInfo(params)

        assert personInfo.save() != null

        params.id = personInfo.id

        def model = controller.edit()

        assert model.personInfoInstance == personInfo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/personInfo/list'

        response.reset()

        populateValidParams(params)
        def personInfo = new PersonInfo(params)

        assert personInfo.save() != null

        // test invalid parameters in update
        params.id = personInfo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/personInfo/edit"
        assert model.personInfoInstance != null

        personInfo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/personInfo/show/$personInfo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        personInfo.clearErrors()

        populateValidParams(params)
        params.id = personInfo.id
        params.version = -1
        controller.update()

        assert view == "/personInfo/edit"
        assert model.personInfoInstance != null
        assert model.personInfoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/personInfo/list'

        response.reset()

        populateValidParams(params)
        def personInfo = new PersonInfo(params)

        assert personInfo.save() != null
        assert PersonInfo.count() == 1

        params.id = personInfo.id

        controller.delete()

        assert PersonInfo.count() == 0
        assert PersonInfo.get(personInfo.id) == null
        assert response.redirectedUrl == '/personInfo/list'
    }
}
