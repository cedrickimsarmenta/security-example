package com.neo.securityx

import com.neo.security.CriminalStatus
import com.neo.security.Gender

class Criminal {
    String firstName
    String middleName
    String lastName
    String alias
    Date birthday
    BigDecimal reward
    Gender gender
    CriminalStatus status
    BigDecimal height
    BigDecimal weight

    static constraints = {
        firstName nullable: false
        middleName nullable: false
        lastName nullable: false
        alias nullable: true
        birthday nullable: true
        reward nullable: false
        gender nullable: false
        status nullable: false
        height nullable: true
        weight nullable: true
    }
}
