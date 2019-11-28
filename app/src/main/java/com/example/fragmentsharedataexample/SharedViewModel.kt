package com.example.fragmentsharedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product : LiveData<Product>
        get() = _product

    fun updateProduct(id: Int){
        _product.value = products.find {id == it.id }
    }
}