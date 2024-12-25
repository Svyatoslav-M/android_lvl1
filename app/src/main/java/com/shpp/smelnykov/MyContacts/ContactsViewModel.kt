package com.shpp.smelnykov.MyContacts

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContactsViewModel : ViewModel() {

    private val _userList by lazy {
        MutableStateFlow<List<ContactModel>>(emptyList())
    }
    val userList: StateFlow<List<ContactModel>> by lazy {
        _userList
    }

    fun loadContacts() {
        val contactsList = listOf(
            ContactModel("Person 1", "Programmer", "https://i.pinimg.com/236x/56/ea/08/56ea0873a72aa2906acc04d2eada7e73.jpg"),
            ContactModel("Person 2", "Builder", "https://i.pinimg.com/236x/e2/51/58/e25158840ecb962f4619f7c979ee5c96.jpg"),
            ContactModel("Person 3", "HR", "https://lolla.top/uploads/posts/2023-12/1703380834_lolla-top-p-avatarki-sigma-instagram-2.jpg"),
            ContactModel("Person 4", "Mechanic", "https://cs15.pikabu.ru/post_img/2024/06/23/1/1719093912119162280.jpg"),
            ContactModel("Person 5", "Smith", "https://i.pinimg.com/236x/61/b4/ea/61b4ea7edf7913d9de83a92d16b875a5.jpg"),
        )
        _userList.value = contactsList
    }
}