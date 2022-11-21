package blaster707.experiments.contactlist

data class ContactEntry (
    val person: Person,
    val address: Address,
    val phoneNumber: PhoneNumber,
    ){

    val firstName = person.firstName
    val lastName = person.lastName
    fun addressStringAll(address: Address): String {
        return "${address.addressLabelString} \n${address.addressNumber} ${address.streetName} \n${address.city}, ${address.state} ${address.zipCode}"
    }


}

fun contactEntryBuilder(): ContactEntry {

    val contactPerson = PersonBuilder().getPersonInput()
    val address: Address = Address().addressBuilder()
    val phoneNumber: PhoneNumber = PhoneNumber().phoneNumberBuilder()

    return ContactEntry(contactPerson, address, phoneNumber)

}

class PhoneNumber {

    var number: Long? = null
    var locationLabel: LocationLabel = LocationLabel.Other

    val phoneNumberLabelString: String = "${this.locationLabel} Phone Number"

    fun phoneNumberBuilder(): PhoneNumber{
        val phoneNumber = PhoneNumber()
        println("Please type in the phone number you would like to add.")
        phoneNumber.number = Builder().numberBuilder()
        println("Please set a label for this phone number.")
        phoneNumber.locationLabel = Builder().locationLabelBuilder()

        return phoneNumber
    }

}

class Address {
    var addressNumber: String? = null
    var streetName: String? = null
    var city: String? = null
    var state: String? = null
    var zipCode: Int? = null
    var locationLabel: LocationLabel = LocationLabel.Other

    val addressLabelString: String = "${this.locationLabel} Address"

    fun addressBuilder(): Address {
        val address = Address()
        println("Please set a label for this address.")
        address.locationLabel = Builder().locationLabelBuilder()
        println("What is the house number for this address?")
        address.addressNumber = readln()
        println("What is the street name for this address?")
        address.streetName = readln()
        println("What is the city for this address?")
        address.city = readln()
        println("What is the state for this address?")
        address.state = readln()
        println("What is the zipcode for this address?")
        address.zipCode = Builder().numberBuilder().toInt()

        return address
    }
}

enum class LocationLabel(labelString: String) {
    Home("Home"),
    Mobile("Mobile"),
    Work("Work"),
    Other("Other");

}

class Builder {
    fun locationLabelBuilder(): LocationLabel {
        println(" 1: Home \n 2: Mobile \n 3: Work \n 4: Other")
        print ("Label Number: ")
        val labelInput = readln()
        if (labelInput != "1" && labelInput != "2" && labelInput != "3" && labelInput != "4") println("Invalid entry. Setting to \"Other\" by default.")
        return when(labelInput) {
            "1" -> LocationLabel.Home
            "2" -> LocationLabel.Mobile
            "3" -> LocationLabel.Work
            else -> LocationLabel.Other
        }
    }

    fun numberBuilder(): Long {
        println("Enter only digits - do not enter any symbols, letters, dashes or spaces.")
        val numberInput = readln()
        return if (numberInput.all { char -> char.isDigit() }) {
            numberInput.toLong()
        } else {
            println("Invalid entry.  Would you like to try again?")
            print("Y/N: ")
            when (readln()) {
                "Y", "y" -> numberBuilder()
                else -> {println("Setting this value to 0 by default."); 0
                }
            }
        }
    }
}