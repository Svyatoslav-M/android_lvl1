package com.shpp.smelnykov.MyContacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.shpp.smelnykov.R
import com.shpp.smelnykov.databinding.ActivityMyContactsBinding
import kotlinx.coroutines.launch

class MyContactsActivity : AppCompatActivity() {

    private val binding: ActivityMyContactsBinding by lazy {
        ActivityMyContactsBinding.inflate(layoutInflater)
    }

    private val userViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        installRV()
        loadDataToRV()
    }

    private fun installRV() {
        binding.recyclerViewContacts.layoutManager = LinearLayoutManager(this)

        val spacing = resources.getDimensionPixelSize(R.dimen.vertical_spacing_between_items)
        binding.recyclerViewContacts.addItemDecoration(SpacingItemDecoration(spacing))
    }

    private fun loadDataToRV() {
        lifecycleScope.launch {
            userViewModel.userList.collect { users ->
                binding.recyclerViewContacts.adapter = ContactsAdapter(users)
            }
        }

        userViewModel.loadContacts()
    }
}