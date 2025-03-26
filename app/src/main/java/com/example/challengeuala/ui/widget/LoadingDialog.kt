package com.example.challengeuala.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun LoadingDialog(onDismiss: () -> Unit) {
    LoadingDialogContent (onDismiss)
}

@Composable
private fun LoadingDialogContent(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el indicador y el texto
                Text(text = "Cargando ciudades...", fontWeight = FontWeight.Bold)
                Text(text = "Por favor, espere", fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
private fun LoadingDialogPreview(){
    LoadingDialog({})
}