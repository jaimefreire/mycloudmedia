package grails.plugin.databasesession

import org.springframework.dao.DataIntegrityViolationException

class PersistentSessionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [persistentSessionInstanceList: PersistentSession.list(params), persistentSessionInstanceTotal: PersistentSession.count()]
    }

    def create() {
        [persistentSessionInstance: new PersistentSession(params)]
    }

    def save() {
        def persistentSessionInstance = new PersistentSession(params)
        if (!persistentSessionInstance.save(flush: true)) {
            render(view: "create", model: [persistentSessionInstance: persistentSessionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), persistentSessionInstance.id])
        redirect(action: "show", id: persistentSessionInstance.id)
    }

    def show(Long id) {
        def persistentSessionInstance = PersistentSession.get(id)
        if (!persistentSessionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), id])
            redirect(action: "list")
            return
        }

        [persistentSessionInstance: persistentSessionInstance]
    }

    def edit(Long id) {
        def persistentSessionInstance = PersistentSession.get(id)
        if (!persistentSessionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), id])
            redirect(action: "list")
            return
        }

        [persistentSessionInstance: persistentSessionInstance]
    }

    def update(Long id, Long version) {
        def persistentSessionInstance = PersistentSession.get(id)
        if (!persistentSessionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (persistentSessionInstance.version > version) {
                persistentSessionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'persistentSession.label', default: 'PersistentSession')] as Object[],
                          "Another user has updated this PersistentSession while you were editing")
                render(view: "edit", model: [persistentSessionInstance: persistentSessionInstance])
                return
            }
        }

        persistentSessionInstance.properties = params

        if (!persistentSessionInstance.save(flush: true)) {
            render(view: "edit", model: [persistentSessionInstance: persistentSessionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), persistentSessionInstance.id])
        redirect(action: "show", id: persistentSessionInstance.id)
    }

    def delete(Long id) {
        def persistentSessionInstance = PersistentSession.get(id)
        if (!persistentSessionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), id])
            redirect(action: "list")
            return
        }

        try {
            persistentSessionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'persistentSession.label', default: 'PersistentSession'), id])
            redirect(action: "show", id: id)
        }
    }
}
