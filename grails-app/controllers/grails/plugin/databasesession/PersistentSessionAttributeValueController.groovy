package grails.plugin.databasesession

import org.springframework.dao.DataIntegrityViolationException

class PersistentSessionAttributeValueController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [persistentSessionAttributeValueInstanceList: PersistentSessionAttributeValue.list(params), persistentSessionAttributeValueInstanceTotal: PersistentSessionAttributeValue.count()]
    }

    def create() {
        [persistentSessionAttributeValueInstance: new PersistentSessionAttributeValue(params)]
    }

    def save() {
        def persistentSessionAttributeValueInstance = new PersistentSessionAttributeValue(params)
        if (!persistentSessionAttributeValueInstance.save(flush: true)) {
            render(view: "create", model: [persistentSessionAttributeValueInstance: persistentSessionAttributeValueInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), persistentSessionAttributeValueInstance.id])
        redirect(action: "show", id: persistentSessionAttributeValueInstance.id)
    }

    def show(Long id) {
        def persistentSessionAttributeValueInstance = PersistentSessionAttributeValue.get(id)
        if (!persistentSessionAttributeValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), id])
            redirect(action: "list")
            return
        }

        [persistentSessionAttributeValueInstance: persistentSessionAttributeValueInstance]
    }

    def edit(Long id) {
        def persistentSessionAttributeValueInstance = PersistentSessionAttributeValue.get(id)
        if (!persistentSessionAttributeValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), id])
            redirect(action: "list")
            return
        }

        [persistentSessionAttributeValueInstance: persistentSessionAttributeValueInstance]
    }

    def update(Long id, Long version) {
        def persistentSessionAttributeValueInstance = PersistentSessionAttributeValue.get(id)
        if (!persistentSessionAttributeValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (persistentSessionAttributeValueInstance.version > version) {
                persistentSessionAttributeValueInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue')] as Object[],
                          "Another user has updated this PersistentSessionAttributeValue while you were editing")
                render(view: "edit", model: [persistentSessionAttributeValueInstance: persistentSessionAttributeValueInstance])
                return
            }
        }

        persistentSessionAttributeValueInstance.properties = params

        if (!persistentSessionAttributeValueInstance.save(flush: true)) {
            render(view: "edit", model: [persistentSessionAttributeValueInstance: persistentSessionAttributeValueInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), persistentSessionAttributeValueInstance.id])
        redirect(action: "show", id: persistentSessionAttributeValueInstance.id)
    }

    def delete(Long id) {
        def persistentSessionAttributeValueInstance = PersistentSessionAttributeValue.get(id)
        if (!persistentSessionAttributeValueInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), id])
            redirect(action: "list")
            return
        }

        try {
            persistentSessionAttributeValueInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'persistentSessionAttributeValue.label', default: 'PersistentSessionAttributeValue'), id])
            redirect(action: "show", id: id)
        }
    }
}
