package blaster707.experiments.contactlist

data class ContactEntry (
    val person: Person,
    val streetAddress: String?,
    val city: String?,
    val state: String?,
    val zipCode: Int?){

    val firstName = person.firstName
    val lastName = person.lastName


}

interface PhoneNumber{
    fun numberType(numberTypeInput: String): String
}

class MobileNumber(val number: Long): PhoneNumber {
    val numberType = "Mobile"
}

data class HomeNumber(val number: Long): PhoneNumber {
    val numberType = "Home"
}

data class WorkNumber(val number: Long): PhoneNumber {
    val numberType = "Work"
}

data class OtherNumber(val number: Long): PhoneNumber {
    val numberType = "Other"
}