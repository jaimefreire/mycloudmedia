package mycloudmedia

import org.springframework.dao.DataIntegrityViolationException

class ReviewsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [reviewsInstanceList: Reviews.list(params), reviewsInstanceTotal: Reviews.count()]
    }

    def create() {
        [reviewsInstance: new Reviews(params)]
    }

    def save() {
        def reviewsInstance = new Reviews(params)
        if (!reviewsInstance.save(flush: true)) {
            render(view: "create", model: [reviewsInstance: reviewsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'reviews.label', default: 'Reviews'), reviewsInstance.id])
        redirect(action: "show", id: reviewsInstance.id)
    }

    def show(Long id) {
        def reviewsInstance = Reviews.get(id)
        if (!reviewsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reviews.label', default: 'Reviews'), id])
            redirect(action: "list")
            return
        }

        [reviewsInstance: reviewsInstance]
    }

    def edit(Long id) {
        def reviewsInstance = Reviews.get(id)
        if (!reviewsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reviews.label', default: 'Reviews'), id])
            redirect(action: "list")
            return
        }

        [reviewsInstance: reviewsInstance]
    }

    def update(Long id, Long version) {
        def reviewsInstance = Reviews.get(id)
        if (!reviewsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reviews.label', default: 'Reviews'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (reviewsInstance.version > version) {
                reviewsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reviews.label', default: 'Reviews')] as Object[],
                          "Another user has updated this Reviews while you were editing")
                render(view: "edit", model: [reviewsInstance: reviewsInstance])
                return
            }
        }

        reviewsInstance.properties = params

        if (!reviewsInstance.save(flush: true)) {
            render(view: "edit", model: [reviewsInstance: reviewsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'reviews.label', default: 'Reviews'), reviewsInstance.id])
        redirect(action: "show", id: reviewsInstance.id)
    }

    def delete(Long id) {
        def reviewsInstance = Reviews.get(id)
        if (!reviewsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reviews.label', default: 'Reviews'), id])
            redirect(action: "list")
            return
        }

        try {
            reviewsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'reviews.label', default: 'Reviews'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reviews.label', default: 'Reviews'), id])
            redirect(action: "show", id: id)
        }
    }
}
