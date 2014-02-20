package mycloudmedia

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(LinkTypeController)
@Mock(LinkType)
class LinkTypeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/linkType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.linkTypeInstanceList.size() == 0
        assert model.linkTypeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.linkTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.linkTypeInstance != null
        assert view == '/linkType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/linkType/show/1'
        assert controller.flash.message != null
        assert LinkType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/linkType/list'

        populateValidParams(params)
        def linkType = new LinkType(params)

        assert linkType.save() != null

        params.id = linkType.id

        def model = controller.show()

        assert model.linkTypeInstance == linkType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/linkType/list'

        populateValidParams(params)
        def linkType = new LinkType(params)

        assert linkType.save() != null

        params.id = linkType.id

        def model = controller.edit()

        assert model.linkTypeInstance == linkType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/linkType/list'

        response.reset()

        populateValidParams(params)
        def linkType = new LinkType(params)

        assert linkType.save() != null

        // test invalid parameters in update
        params.id = linkType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/linkType/edit"
        assert model.linkTypeInstance != null

        linkType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/linkType/show/$linkType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        linkType.clearErrors()

        populateValidParams(params)
        params.id = linkType.id
        params.version = -1
        controller.update()

        assert view == "/linkType/edit"
        assert model.linkTypeInstance != null
        assert model.linkTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/linkType/list'

        response.reset()

        populateValidParams(params)
        def linkType = new LinkType(params)

        assert linkType.save() != null
        assert LinkType.count() == 1

        params.id = linkType.id

        controller.delete()

        assert LinkType.count() == 0
        assert LinkType.get(linkType.id) == null
        assert response.redirectedUrl == '/linkType/list'
    }
}
