package com.nazirjon.mvvmkotlin.viewmodel

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.nazirjon.mvvmkotlin.model.User
import java.util.Observable
import java.util.Observer
import java.util.Locale


class UserViewModel(private val user: User) : Observer, BaseObservable() {

    /// Register it self as the observer of Model
    init {
        user.addObserver(this)
    }

    /// Notify the UI when change event emitting from Model is received.
    override fun update(p0: Observable?, p1: Any?) {
    }

    val name: String
        @Bindable get() {
            return user.firstName + " " + user.lastName
        }

    val age: String
        @Bindable get() {
            return if (user.age <= 0) return ""
            else String.format(Locale.ENGLISH, "%d years old", user.age)
        }

    val gender: String
        @Bindable get() {
            return if (user.female) return "Female" else "Male"
        }

    val imageUrl: String
        @Bindable get() {
            return user.imageUrl
        }

    val tagline: String
        @Bindable get() {
            return "Tagline: " + user.tagline
        }

    fun onButtonClick(view: View) {
        this.user.age = 35
        this.user.imageUrl = "URL"
        this.user.tagline = "Now he has grown up..."
    }

}