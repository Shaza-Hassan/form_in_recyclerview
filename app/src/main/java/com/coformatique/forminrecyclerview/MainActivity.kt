package com.coformatique.forminrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var formsInEdit : MutableList<EditForm> = mutableListOf()
    private lateinit var adapter: EditForAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fieldsToEdit()
        adapter = EditForAdapter()
        adapter.data = formsInEdit
        recyclerView.adapter = adapter
    }

    private fun fieldsToEdit(){
        formsInEdit.add(EditForm(EditTypes.title,"Student data"))
        formsInEdit.add(EditForm(EditTypes.nameEditText,"First name"))
        formsInEdit.add(EditForm(EditTypes.nameEditText,"Last name"))
        formsInEdit.add(EditForm(EditTypes.phoneEditTxt,"Phone no"))
        formsInEdit.add(EditForm(EditTypes.mailEditText,"Email"))
        formsInEdit.add(EditForm(EditTypes.passwordEditText,"Password"))
        formsInEdit.add(EditForm(EditTypes.passwordHint,"Password hint"))
        formsInEdit.add(EditForm(EditTypes.passwordEditText,"Conform password"))
        formsInEdit.add(EditForm(EditTypes.nameEditText,"School name"))
        formsInEdit.add(EditForm(EditTypes.title,"Parent data"))
        formsInEdit.add(EditForm(EditTypes.nameEditText,"First name"))
        formsInEdit.add(EditForm(EditTypes.nameEditText,"Last name"))
        formsInEdit.add(EditForm(EditTypes.phoneEditTxt,"Phone no"))
        formsInEdit.add(EditForm(EditTypes.mailEditText,"Email"))
    }

}
