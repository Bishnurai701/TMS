package tms

import grails.gorm.services.Service

@Service(Register)
interface RegisterService {

    Register get(Serializable id)

    List<Register> list(Map args)

    Long count()

    void delete(Serializable id)

    Register save(Register register)

}