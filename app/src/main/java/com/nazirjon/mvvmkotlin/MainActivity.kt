package com.nazirjon.mvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.nazirjon.mvvmkotlin.model.User
import com.nazirjon.mvvmkotlin.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// Create the model with initial data
        val user = User()
        user.age = 20
        user.female = false
        user.firstName = "Jon"
        user.lastName = "Keep"
        user.imageUrl = "URL"
        user.tagline = "When is young"

        /// Create the view model
        val userViewModel = UserViewModel(user)

        /// Data-Binding
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        binding.setVariable(BR.user, userViewModel)
    }
}