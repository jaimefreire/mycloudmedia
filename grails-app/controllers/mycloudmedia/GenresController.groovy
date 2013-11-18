package mycloudmedia

import org.springframework.dao.DataIntegrityViolationException

class GenresController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [genresInstanceList: Genres.list(params), genresInstanceTotal: Genres.count()]
    }

    def create() {
        [genresInstance: new Genres(params)]
    }

    def save() {
        def genresInstance = new Genres(params)
        if (!genresInstance.save(flush: true)) {
            render(view: "create", model: [genresInstance: genresInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'genres.label', default: 'Genres'), genresInstance.id])
        redirect(action: "show", id: genresInstance.id)
    }

    def show(Long id) {
        def genresInstance = Genres.get(id)
        if (!genresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'genres.label', default: 'Genres'), id])
            redirect(action: "list")
            return
        }

        [genresInstance: genresInstance]
    }

    def edit(Long id) {
        def genresInstance = Genres.get(id)
        if (!genresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'genres.label', default: 'Genres'), id])
            redirect(action: "list")
            return
        }

        [genresInstance: genresInstance]
    }

    def update(Long id, Long version) {
        def genresInstance = Genres.get(id)
        if (!genresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'genres.label', default: 'Genres'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (genresInstance.version > version) {
                genresInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'genres.label', default: 'Genres')] as Object[],
                          "Another user has updated this Genres while you were editing")
                render(view: "edit", model: [genresInstance: genresInstance])
                return
            }
        }

        genresInstance.properties = params

        if (!genresInstance.save(flush: true)) {
            render(view: "edit", model: [genresInstance: genresInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'genres.label', default: 'Genres'), genresInstance.id])
        redirect(action: "show", id: genresInstance.id)
    }

    def delete(Long id) {
        def genresInstance = Genres.get(id)
        if (!genresInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'genres.label', default: 'Genres'), id])
            redirect(action: "list")
            return
        }

        try {
            genresInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'genres.label', default: 'Genres'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'genres.label', default: 'Genres'), id])
            redirect(action: "show", id: id)
        }
    }
}
