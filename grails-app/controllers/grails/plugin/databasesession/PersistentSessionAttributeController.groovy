package grails.plugin.databasesession

import org.springframework.dao.DataIntegrityViolationException

class PersistentSessionAttributeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [persistentSessionAttributeInstanceList: PersistentSessionAttribute.list(params), persistentSessionAttributeInstanceTotal: PersistentSessionAttribute.count()]
    }

    def create() {
        [persistentSessionAttributeInstance: new PersistentSessionAttribute(params)]
    }

    def save() {
        def persistentSessionAttributeInstance = new PersistentSessionAttribute(params)
        if (!persistentSessionAttributeInstance.save(flush: true)) {
            render(view: "create", model: [persistentSessionAttributeInstance: persistentSessionAttributeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), persistentSessionAttributeInstance.id])
        redirect(action: "show", id: persistentSessionAttributeInstance.id)
    }

    def show(Long id) {
        def persistentSessionAttributeInstance = PersistentSessionAttribute.get(id)
        if (!persistentSessionAttributeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), id])
            redirect(action: "list")
            return
        }

        [persistentSessionAttributeInstance: persistentSessionAttributeInstance]
    }

    def edit(Long id) {
        def persistentSessionAttributeInstance = PersistentSessionAttribute.get(id)
        if (!persistentSessionAttributeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), id])
            redirect(action: "list")
            return
        }

        [persistentSessionAttributeInstance: persistentSessionAttributeInstance]
    }

    def update(Long id, Long version) {
        def persistentSessionAttributeInstance = PersistentSessionAttribute.get(id)
        if (!persistentSessionAttributeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (persistentSessionAttributeInstance.version > version) {
                persistentSessionAttributeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute')] as Object[],
                          "Another user has updated this PersistentSessionAttribute while you were editing")
                render(view: "edit", model: [persistentSessionAttributeInstance: persistentSessionAttributeInstance])
                return
            }
        }

        persistentSessionAttributeInstance.properties = params

        if (!persistentSessionAttributeInstance.save(flush: true)) {
            render(view: "edit", model: [persistentSessionAttributeInstance: persistentSessionAttributeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), persistentSessionAttributeInstance.id])
        redirect(action: "show", id: persistentSessionAttributeInstance.id)
    }

    def delete(Long id) {
        def persistentSessionAttributeInstance = PersistentSessionAttribute.get(id)
        if (!persistentSessionAttributeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), id])
            redirect(action: "list")
            return
        }

        try {
            persistentSessionAttributeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'persistentSessionAttribute.label', default: 'PersistentSessionAttribute'), id])
            redirect(action: "show", id: id)
        }
    }
}
