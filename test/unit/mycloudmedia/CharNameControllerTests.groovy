package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(CharNameController)
@Mock(CharName)
class CharNameControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/charName/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.charNameInstanceList.size() == 0
        assert model.charNameInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.charNameInstance != null
    }

    void testSave() {
        controller.save()

        assert model.charNameInstance != null
        assert view == '/charName/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/charName/show/1'
        assert controller.flash.message != null
        assert CharName.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/charName/list'

        populateValidParams(params)
        def charName = new CharName(params)

        assert charName.save() != null

        params.id = charName.id

        def model = controller.show()

        assert model.charNameInstance == charName
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/charName/list'

        populateValidParams(params)
        def charName = new CharName(params)

        assert charName.save() != null

        params.id = charName.id

        def model = controller.edit()

        assert model.charNameInstance == charName
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/charName/list'

        response.reset()

        populateValidParams(params)
        def charName = new CharName(params)

        assert charName.save() != null

        // test invalid parameters in update
        params.id = charName.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/charName/edit"
        assert model.charNameInstance != null

        charName.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/charName/show/$charName.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        charName.clearErrors()

        populateValidParams(params)
        params.id = charName.id
        params.version = -1
        controller.update()

        assert view == "/charName/edit"
        assert model.charNameInstance != null
        assert model.charNameInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/charName/list'

        response.reset()

        populateValidParams(params)
        def charName = new CharName(params)

        assert charName.save() != null
        assert CharName.count() == 1

        params.id = charName.id

        controller.delete()

        assert CharName.count() == 0
        assert CharName.get(charName.id) == null
        assert response.redirectedUrl == '/charName/list'
    }
}
