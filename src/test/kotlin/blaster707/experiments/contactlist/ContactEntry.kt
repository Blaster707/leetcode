package blaster707.experiments.contactlist

data class ContactEntry (
    val person: Person,
    val addressList: List<Address> = mutableListOf(),
    val phoneNumberList: List<PhoneNumber> = mutableListOf()
    ){

    val firstName = person.firstName
    val lastName = person.lastName
    fun addressStringAll(addressList: List<Address>): String {
        var result = ""
        for (addressX in addressList) result = result.plus("${addressX.addressLabelString()} \n${addressX.addressNumber} ${addressX.streetName} \n${addressX.city}, ${addressX.state} ${addressX.zipCode}\n")
        return result
    }
}



fun contactEntryBuilder(): ContactEntry {

    val contactPerson = PersonBuilder().getPersonInput()
    val addressList = mutableListOf(Address().addressBuilder())
    val phoneNumberList = mutableListOf(PhoneNumber().phoneNumberBuilder())

    return ContactEntry(contactPerson, addressList, phoneNumberList)

}

class PhoneNumber {

    var number: Long? = null
    var locationLabel: LocationLabel = LocationLabel.Other

    fun phoneNumberLabelString(): String { return "${this.locationLabel} Phone Number" }

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

    fun addressLabelString(): String {return "${this.locationLabel} Address"}

    fun addressBuilder(): Address {
        val address = Address()
        println("You will now add an address for this contact entry.")
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