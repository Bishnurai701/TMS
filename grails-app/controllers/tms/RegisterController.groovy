package tms

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RegisterController {

    RegisterService registerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond registerService.list(params), model:[registerCount: registerService.count()]
    }

    def show(Long id) {
        respond registerService.get(id)
    }

    def create() {
        respond new Register(params)
    }

    def save(Register register) {
        if (register == null) {
            notFound()
            return
        }

        try {
            registerService.save(register)
        } catch (ValidationException e) {
            respond register.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'register.label', default: 'Register'), register.id])
                redirect register
            }
            '*' { respond register, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond registerService.get(id)
    }

    def update(Register register) {
        if (register == null) {
            notFound()
            return
        }

        try {
            registerService.save(register)
        } catch (ValidationException e) {
            respond register.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'register.label', default: 'Register'), register.id])
                redirect register
            }
            '*'{ respond register, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        registerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'register.label', default: 'Register'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'register.label', default: 'Register'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
