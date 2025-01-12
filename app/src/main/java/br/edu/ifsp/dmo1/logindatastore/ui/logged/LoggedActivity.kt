package br.edu.ifsp.dmo1.logindatastore.ui.logged

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.logindatastore.databinding.ActivityLoggedBinding

class LoggedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoggedBinding
    private lateinit var viewModel: LoggedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoggedViewModel::class.java)
        binding.textMessage.setText("Bem-Vindo")

        setupObservers()
        setupListeners()
    }

    private fun setupListeners() {
        viewModel.loggedOut.observe(this, Observer {
            Toast.makeText(
                this,
                "Logout realizado com sucesso.",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        })
    }

    private fun setupObservers() {
        binding.buttonLogout.setOnClickListener {
            handleLogout()
        }
    }

    private fun handleLogout() {
        viewModel.logout()
    }

}