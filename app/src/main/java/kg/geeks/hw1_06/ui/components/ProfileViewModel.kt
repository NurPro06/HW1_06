package kg.geeks.hw1_06.ui.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    var name by mutableStateOf("Muratzhanov Nurbol")
    var phone by mutableStateOf("+996508081889")
    var birthDate by mutableStateOf("15.06.2006")
    var city by mutableStateOf("Бишкек")
}