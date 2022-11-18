package blaster707.experiments.contactlist

data class ContactEntry (
    val person: Person,
    val mobileNumber: Int?,
    val homeNumber: Int?,
    val streetAddress: String?,
    val city: String?,
    val state: String?,
    val zipCode: Int?
        )