package br.edu.ifsp.dmo1.logindatastore.ui.logged

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.logindatastore.data.DataStoreRepository
import kotlinx.coroutines.launch

class LoggedViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    private val _loggedOut = MutableLiveData<Boolean>()
    val loggedOut: LiveData<Boolean> = _loggedOut

    fun logout() {
        viewModelScope.launch {
            repository.logout()
            _loggedOut.value = true
        }
    }
}