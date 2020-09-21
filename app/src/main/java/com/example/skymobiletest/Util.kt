package com.example.skymobiletest

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class ArrayEmptyException(var msg: String? =  "ArrayEmptyException") : RuntimeException()

inline fun AppCompatActivity.transact(action: FragmentTransaction.() -> Unit) {
    supportFragmentManager.beginTransaction().apply {
        action()
    }
        .addToBackStack(null)
        .commit()
}