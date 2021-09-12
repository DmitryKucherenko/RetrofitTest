package com.bignerdranch.android.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.WorkerThread
import data.ApiDateImpl
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var button:Button
    private lateinit var editId:EditText
    private lateinit var editTitle: EditText
    private lateinit var list: TextView

     override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        editId = findViewById(R.id.idEdit)
        editTitle = findViewById(R.id.titleEdit)
        list = findViewById(R.id.textView)

         runBlocking {getList()}




    }


    suspend fun getList()=coroutineScope{
        launch {
            val s= ApiDateImpl.getBooks().joinToString()
println("s $s")
            list.text=s
            }
        }







    @WorkerThread
    fun postBook(book:String){

    }

}