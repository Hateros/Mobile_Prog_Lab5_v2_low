package com.example.mydialogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mydialogapp.ui.theme.MyDialogAppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDialogAppTheme {
                AgreementApp()
            }
        }
    }
}

@Composable
fun AgreementApp() {
    var showDialog by remember { mutableStateOf(false) }
    var agreementStatus by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Показать условия")
        }
        agreementStatus?.let { status ->
            Text(
                text = status
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
                agreementStatus = "Вы не согласились"
            },
            title = {
                Text("Условия соглашения")
            },
            text = {
                Text("Согласны ли вы с условиями?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        agreementStatus = "Вы согласились"
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        agreementStatus = "Вы не согласились"
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyDialogAppTheme {
        AgreementApp()
    }
}