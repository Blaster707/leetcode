package blaster707.experiments.contactlist

    fun main(){
        val contactEntryX = contactEntryBuilder()

        println("${contactEntryX.person.firstName}, ${contactEntryX.person.lastName}")
        for (phoneNumber in contactEntryX.phoneNumberList) {
            println(phoneNumber.phoneNumberLabelString())
            println("${phoneNumber.number}\n")
        }
        println(contactEntryX.addressStringAll(contactEntryX.addressList))
    }

open class ContactList(array: Array<ContactEntry>) {

}