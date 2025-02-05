package kg.geeks.hw1_06.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kg.geeks.hw1_06.R
import java.lang.reflect.Modifier

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = ProfileViewModel()) {
    var showDialog by remember { mutableStateOf(false) }
    var editingField by remember { mutableStateOf("") }
    var editingValue by remember { mutableStateOf("") }

    val context = LocalContext.current

    if (showDialog) {
        EditDialog(
            title = "Редактировать $editingField",
            value = editingValue,
            onValueChange = { editingValue = it },
            onDismiss = { showDialog = false },
            onSave = {
                when (editingField) {
                    "Имя" -> viewModel.name = editingValue
                    "Телефон" -> viewModel.phone = editingValue
                    "Дата рождения" -> viewModel.birthDate = editingValue
                    "Город" -> viewModel.city = editingValue
                }
                showDialog = false
                Toast.makeText(context, "$editingField обновлено!", Toast.LENGTH_SHORT).show()
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage(painterResource(R.drawable.image))

        Spacer(modifier = Modifier.height(16.dp))

        ProfileInfoItem("Имя", viewModel.name) {
            editingField = "Имя"
            editingValue = viewModel.name
            showDialog = true
        }

        ProfileInfoItem("Дата рождения", viewModel.birthDate) {
            editingField = "Дата рождения"
            editingValue = viewModel.birthDate
            showDialog = true
        }

        ProfileInfoItem("Город", viewModel.city) {
            editingField = "Город"
            editingValue = viewModel.city
            showDialog = true
        }


        ProfileInfoItem("Телефон", viewModel.phone) {
            editingField = "Телефон"
            editingValue = viewModel.phone
            showDialog = true
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button (
            onClick = { Toast.makeText(context, "Выход из профиля", Toast.LENGTH_SHORT).show() },
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text("Выйти", color = Color.White)
        }
    }
}