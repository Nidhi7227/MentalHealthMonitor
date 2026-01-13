package com.example.mentalhealthmonitor.ui.screens

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

@Composable
fun PhoneAuthScreen(
    onLoginSuccess: () -> Unit
) {
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()

    var phoneNumber by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var verificationId by remember { mutableStateOf<String?>(null) }
    var isOtpSent by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Login with Phone", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        if (!isOtpSent) {
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number (+91)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true
            )

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    if (phoneNumber.length != 10) {
                        Toast.makeText(context, "Enter valid 10-digit number", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    isLoading = true

                    val options = PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+91$phoneNumber")
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(context as Activity)
                        .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                                auth.signInWithCredential(credential)
                                    .addOnCompleteListener { task ->
                                        isLoading = false
                                        if (task.isSuccessful) {
                                            Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                                            onLoginSuccess()
                                        } else {
                                            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                            }

                            override fun onVerificationFailed(e: FirebaseException) {
                                isLoading = false
                                Toast.makeText(context, "Verification Failed: ${e.message}", Toast.LENGTH_LONG).show()
                                e.printStackTrace()
                            }

                            override fun onCodeSent(
                                id: String,
                                token: PhoneAuthProvider.ForceResendingToken
                            ) {
                                verificationId = id
                                isOtpSent = true
                                isLoading = false
                                Toast.makeText(context, "OTP Sent!", Toast.LENGTH_SHORT).show()
                            }
                        })
                        .build()

                    PhoneAuthProvider.verifyPhoneNumber(options)
                },
                enabled = !isLoading
            ) {
                Text(if (isLoading) "Sending..." else "Send OTP")
            }

        } else {
            OutlinedTextField(
                value = otp,
                onValueChange = { otp = it },
                label = { Text("Enter OTP") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    if (otp.length != 6 || verificationId == null) {
                        Toast.makeText(context, "Enter 6-digit OTP", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    val credential = PhoneAuthProvider.getCredential(verificationId!!, otp)
                    isLoading = true

                    auth.signInWithCredential(credential)
                        .addOnCompleteListener { task ->
                            isLoading = false
                            if (task.isSuccessful) {
                                Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                                onLoginSuccess()
                            } else {
                                Toast.makeText(context, "Invalid OTP", Toast.LENGTH_SHORT).show()
                            }
                        }
                },
                enabled = !isLoading
            ) {
                Text(if (isLoading) "Verifying..." else "Verify OTP")
            }
        }
    }
}
