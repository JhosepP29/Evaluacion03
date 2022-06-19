package com.tecsup.evaluacion03.vistas.book

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.evaluacion03.model.Libro
import kotlinx.coroutines.launch

class BookViewModel (application: Application): AndroidViewModel(application) {
    private val repository = BookRepository(application)
    // Listado
    val books = repository.getBooks()

    // Registro
    fun saveBook(libro: Libro){
        viewModelScope.launch{
            repository.insertBookWithCoroutines(libro)
        }
    }

    // Actualizar
    fun updateBook(libro: Libro){
        viewModelScope.launch {
            repository.updateBookWithCoroutines(libro)
        }
    }
}