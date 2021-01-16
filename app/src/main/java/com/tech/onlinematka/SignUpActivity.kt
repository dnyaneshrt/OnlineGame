package com.tech.onlinematka

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.tech.onlinematka.ui.AdminPanelActivity

class SignUpActivity : AppCompatActivity() {

    lateinit var btn_create_account: Button

    var et_username: EditText? = null
    var et_mobile_number: EditText? = null
    var et_pin: EditText? = null
    var et_password: EditText? = null
    var txt_login: TextView? = null
    var valid = true
    var checkBox_user: CheckBox? = null
    var checkBox_admin: CheckBox? = null


    private lateinit var firestore: FirebaseFirestore
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        init()
        firebaseAuth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()



        btn_create_account.setOnClickListener {
            checkField(et_username!!)
            checkField(et_mobile_number!!)
            checkField(et_pin!!)
            checkField(et_password!!)

            checkBox_admin?.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
                if (compoundButton.isChecked) {
                    checkBox_user?.isChecked = false
                }
            }
            checkBox_user?.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
                if (compoundButton.isChecked) {
                    checkBox_admin?.isChecked = false
                }
            }

            //check box validation
            if (!(checkBox_admin?.isChecked()!! || checkBox_user?.isChecked()!!)) {
                Toast.makeText(this, "please select type:", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            if (valid) {
                var username = et_username?.text.toString()
                var password = et_password?.text.toString()

                var mobile_number = et_mobile_number?.text.toString()
                var pin = et_pin?.text.toString()

                firebaseAuth.createUserWithEmailAndPassword(username, password)
                    .addOnSuccessListener {
                        var firebaseUser = firebaseAuth.currentUser
                        showToast("account created successfully")

                        var documentReference =
                            firestore.collection("users").document(firebaseUser!!.uid)

                        val userInfo = HashMap<String, Any>()
                        userInfo["usename"] = username
                        userInfo["password"] = password
                        userInfo["pin"] = pin
                        userInfo["mobile"] = mobile_number

                        if (checkBox_admin!!.isChecked) {
                            userInfo["isAdmin"] = "1"
                        }

                        if (checkBox_user!!.isChecked) {
                            userInfo["isUser"] = "1"
                        }


                        documentReference.set(userInfo).addOnSuccessListener {
                            showToast("data registered successfully")
                        }.addOnFailureListener {
                            showToast("unable to add data ${it.message}")
                        }
                        if (checkBox_admin!!.isChecked) {
                            var intent = Intent(this, AdminPanelActivity::class.java)
                            startActivity(intent)


                        }
                        if (checkBox_user!!.isChecked) {
                            var intent = Intent(this, HomeScreenActivity::class.java)
                            startActivity(intent)

                        }


                    }.addOnFailureListener {
                        showToast("unable to create an account  $username  $password: ${it.message}")
                    }


            }
        }
        txt_login?.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }


    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun init() {
        btn_create_account = findViewById(R.id.button_create_account)
        et_username = findViewById(R.id.et_username)
        et_mobile_number = findViewById(R.id.et_mobile_number)
        et_pin = findViewById(R.id.et_pin)
        et_password = findViewById(R.id.et_password)

        txt_login = findViewById(R.id.text_login_here)

        checkBox_admin = findViewById(R.id.check_Admin)
        checkBox_user = findViewById(R.id.check_user)
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