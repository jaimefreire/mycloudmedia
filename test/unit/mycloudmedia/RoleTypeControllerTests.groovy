package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(RoleTypeController)
@Mock(RoleType)
class RoleTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/roleType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.roleTypeInstanceList.size() == 0
        assert model.roleTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.roleTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.roleTypeInstance != null
        assert view == '/roleType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/roleType/show/1'
        assert controller.flash.message != null
        assert RoleType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/roleType/list'

        populateValidParams(params)
        def roleType = new RoleType(params)

        assert roleType.save() != null

        params.id = roleType.id

        def model = controller.show()

        assert model.roleTypeInstance == roleType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/roleType/list'

        populateValidParams(params)
        def roleType = new RoleType(params)

        assert roleType.save() != null

        params.id = roleType.id

        def model = controller.edit()

        assert model.roleTypeInstance == roleType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/roleType/list'

        response.reset()

        populateValidParams(params)
        def roleType = new RoleType(params)

        assert roleType.save() != null

        // test invalid parameters in update
        params.id = roleType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/roleType/edit"
        assert model.roleTypeInstance != null

        roleType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/roleType/show/$roleType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        roleType.clearErrors()

        populateValidParams(params)
        params.id = roleType.id
        params.version = -1
        controller.update()

        assert view == "/roleType/edit"
        assert model.roleTypeInstance != null
        assert model.roleTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/roleType/list'

        response.reset()

        populateValidParams(params)
        def roleType = new RoleType(params)

        assert roleType.save() != null
        assert RoleType.count() == 1

        params.id = roleType.id

        controller.delete()

        assert RoleType.count() == 0
        assert RoleType.get(roleType.id) == null
        assert response.redirectedUrl == '/roleType/list'
    }
}
