package blaster707.experiments.contactlist

import org.junit.jupiter.api.Test

    fun main(){
        var contactEntryX = contactEntryBuilder()

        println("${contactEntryX.person.firstName}, ${contactEntryX.person.lastName}")
        println("${contactEntryX.phoneNumber.phoneNumberLabelString} \n${contactEntryX.phoneNumber.number}")
        println(contactEntryX.addressStringAll(contactEntryX.address))
    }