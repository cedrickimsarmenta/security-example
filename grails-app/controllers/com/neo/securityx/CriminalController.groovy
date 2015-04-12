package com.neo.securityx



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CriminalController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Criminal.list(params), [status: OK]
    }

    @Transactional
    def save(Criminal criminalInstance) {
        if (criminalInstance == null) {
            render status: NOT_FOUND
            return
        }

        criminalInstance.validate()
        if (criminalInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        criminalInstance.save flush:true
        respond criminalInstance, [status: CREATED]
    }

    @Transactional
    def update(Criminal criminalInstance) {
        if (criminalInstance == null) {
            render status: NOT_FOUND
            return
        }

        criminalInstance.validate()
        if (criminalInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        criminalInstance.save flush:true
        respond criminalInstance, [status: OK]
    }

    @Transactional
    def delete(Criminal criminalInstance) {

        if (criminalInstance == null) {
            render status: NOT_FOUND
            return
        }

        criminalInstance.delete flush:true
        render status: NO_CONTENT
    }
}
