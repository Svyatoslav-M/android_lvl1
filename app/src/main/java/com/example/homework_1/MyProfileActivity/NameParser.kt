package com.example.homework_1.MyProfileActivity

/**
 * Name and surname parser class.
 */
class NameParser {

    /**
     * Method for parsing name and surname from email.
     * name and surname will be parse form email type: name.surname@...
     *
     * @param email email with name and surname.
     * @return String which contains name and surname.
     */
    fun parseNameSurname(email: String): String {
        var name = ""
        var surname = ""
        var changer = false

        for (ch in email) {
            if (ch == '@') {
                break
            }
            if (ch == '.') {
                changer = true
                continue
            }
            if (!changer) {
                name += ch
            } else {
                surname += ch
            }
        }
        if (surname == "") {
            return name
        }
        return "${name.capitalize()} ${surname.capitalize()}"
    }
}