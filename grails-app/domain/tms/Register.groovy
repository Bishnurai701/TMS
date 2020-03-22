package tms

class Register {
    String name
    Date dateOfBirth
    String gender
    String address;
    String city
    String state
    static constraints = {
        city(inList:["ktm","pokhara"])
        gender(inList: ["Male","Female"])
        state(inList: ["1","2","3","4","5","6","7"])

    }
}
