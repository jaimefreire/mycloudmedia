package mycloudmedia

import org.springframework.dao.DataIntegrityViolationException

class ProfessionsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [professionsInstanceList: Professions.list(params), professionsInstanceTotal: Professions.count()]
    }

    def create() {
        [professionsInstance: new Professions(params)]
    }

    def save() {
        def professionsInstance = new Professions(params)
        if (!professionsInstance.save(flush: true)) {
            render(view: "create", model: [professionsInstance: professionsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'professions.label', default: 'Professions'), professionsInstance.id])
        redirect(action: "show", id: professionsInstance.id)
    }

    def show(Long id) {
        def professionsInstance = Professions.get(id)
        if (!professionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professions.label', default: 'Professions'), id])
            redirect(action: "list")
            return
        }

        [professionsInstance: professionsInstance]
    }

    def edit(Long id) {
        def professionsInstance = Professions.get(id)
        if (!professionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professions.label', default: 'Professions'), id])
            redirect(action: "list")
            return
        }

        [professionsInstance: professionsInstance]
    }

    def update(Long id, Long version) {
        def professionsInstance = Professions.get(id)
        if (!professionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professions.label', default: 'Professions'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (professionsInstance.version > version) {
                professionsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'professions.label', default: 'Professions')] as Object[],
                          "Another user has updated this Professions while you were editing")
                render(view: "edit", model: [professionsInstance: professionsInstance])
                return
            }
        }

        professionsInstance.properties = params

        if (!professionsInstance.save(flush: true)) {
            render(view: "edit", model: [professionsInstance: professionsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'professions.label', default: 'Professions'), professionsInstance.id])
        redirect(action: "show", id: professionsInstance.id)
    }

    def delete(Long id) {
        def professionsInstance = Professions.get(id)
        if (!professionsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'professions.label', default: 'Professions'), id])
            redirect(action: "list")
            return
        }

        try {
            professionsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'professions.label', default: 'Professions'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'professions.label', default: 'Professions'), id])
            redirect(action: "show", id: id)
        }
    }
}
