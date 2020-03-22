package tms

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RegisterServiceSpec extends Specification {

    RegisterService registerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Register(...).save(flush: true, failOnError: true)
        //new Register(...).save(flush: true, failOnError: true)
        //Register register = new Register(...).save(flush: true, failOnError: true)
        //new Register(...).save(flush: true, failOnError: true)
        //new Register(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //register.id
    }

    void "test get"() {
        setupData()

        expect:
        registerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Register> registerList = registerService.list(max: 2, offset: 2)

        then:
        registerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        registerService.count() == 5
    }

    void "test delete"() {
        Long registerId = setupData()

        expect:
        registerService.count() == 5

        when:
        registerService.delete(registerId)
        sessionFactory.currentSession.flush()

        then:
        registerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Register register = new Register()
        registerService.save(register)

        then:
        register.id != null
    }
}
