package com.tech.onlinematka

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tech.onlinematka.ui.AdminPanelActivity

class LoginActivity : AppCompatActivity() {
    var btn_user_login: Button? = null
    var valid = true
    var et_username: EditText? = null
    var et_password: EditText? = null
    var txt_register: TextView? = null
    private lateinit var firestore: FirebaseFirestore
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        firebaseAuth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        btn_user_login?.setOnClickListener {

            checkField(et_username!!)
            checkField(et_password!!)

            var username = et_username?.text.toString()
            var password = et_password?.text.toString()

            if (valid) {
                firebaseAuth.signInWithEmailAndPassword(username, password)
                    .addOnSuccessListener {
                        checkUserAccessLevel(it.user?.uid)
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "failed to login  ${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }
            }


            var intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
        }

        txt_register?.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkUserAccessLevel(uid: String?) {
        var documentReference = firestore.collection("users").document(uid!!)
        documentReference.get().addOnSuccessListener {

            if (it.getString("isAdmin") != null) {
                //means user is an Admin
                Toast.makeText(this, "logged in successfully :Admin", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, AdminPanelActivity::class.java)
                startActivity(intent)
            }

            if (it.getString("isUser") != null) {
                //means user is an user
                Toast.makeText(this, "logged in successfully :user", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
            }
        }.addOnFailureListener {
            Toast.makeText(this, "unable to read the data", Toast.LENGTH_SHORT).show()
        }

    }

    private fun init() {
        btn_user_login = findViewById(R.id.button_user_login)
        et_username = findViewById(R.id.editTextTextEmailAddress)
        et_password = findViewById(R.id.editTextTextPassword)
        txt_register = findViewById(R.id.text_register)
    }


    override fun onStart() {
        super.onStart()
        if (FirebaseAuth.getInstance().currentUser != null) {

            var documentReference = FirebaseFirestore.getInstance().collection("users")
                .document(FirebaseAuth.getInstance().currentUser!!.uid)
            documentReference.get().addOnSuccessListener {
                if (it.getString("isAdmin") != null) {

                    var intent = Intent(this, AdminPanelActivity::class.java)
                    startActivity(intent)
                }
                if (it.getString("isUser") != null) {

                    var intent = Intent(this, HomeScreenActivity::class.java)
                    startActivity(intent)
                }

            }.addOnFailureListener {
                Toast.makeText(this, "failed to read data", Toast.LENGTH_SHORT).show()
                FirebaseAuth.getInstance().signOut()
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }


            Toast.makeText(this, "user is already logged in", Toast.LENGTH_SHORT).show()


            var intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
        }
    }

    fun checkField(textField: EditText): Boolean {
        if (textField.text.toString().isEmpty()) {
            textField.error = "Error"
            valid = false
        } else {
            valid = true
        }
        return valid
    }
}