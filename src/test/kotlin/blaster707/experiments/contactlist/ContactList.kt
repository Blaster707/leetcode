package blaster707.experiments.contactlist

import org.junit.jupiter.api.Test

class ContactList() {

    fun contactListCreator() {
        val contactList = arrayListOf<ContactEntry>()
        
    }
    fun main(){
        var contactEntryX = contactEntryBuilder()

        println("${contactEntryX.person}")
        println("${contactEntryX.phoneNumber}")
        println(contactEntryX.addressStringAll(contactEntryX.address))
    }
}