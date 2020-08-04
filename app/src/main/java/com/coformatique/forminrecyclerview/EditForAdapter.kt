package com.coformatique.forminrecyclerview

import android.text.Editable
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coformatique.forminrecyclerview.EditTypes.mailEditText
import com.coformatique.forminrecyclerview.EditTypes.nameEditText
import com.coformatique.forminrecyclerview.EditTypes.passwordEditText
import com.coformatique.forminrecyclerview.EditTypes.passwordHint
import com.coformatique.forminrecyclerview.EditTypes.phoneEditTxt
import com.coformatique.forminrecyclerview.EditTypes.title
import kotlinx.android.synthetic.main.edit_text_item.view.*
import kotlinx.android.synthetic.main.password_hint.view.*
import kotlinx.android.synthetic.main.title_item.view.*


/**
 * Created by Shaza Hassan on 22-Jul-20.
 */
class EditForAdapter : RecyclerView.Adapter<EditForAdapter.ViewHolder>() {

    var data =  listOf<EditForm>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        val item = data[position]
        return when(item.type){
            nameEditText -> 1
            mailEditText -> 2
            passwordEditText -> 3
            passwordHint -> 4
            phoneEditTxt -> 5
            title -> 6
            else -> -1

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent,viewType)
    }
    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(item: EditForm) {
            when(item.type){
                title -> {
                    itemView.title_item.text = item.hint
                }
                nameEditText -> {
                    itemView.editTextItem.hint = item.hint
                    if (item.text.isNotEmpty()) {
                        itemView.editTextItem.setText(item.text)
                    }
                    itemView.editTextItem.addTextChangedListener(object : TextWatcher {

                        override fun afterTextChanged(s: Editable) {}

                        override fun beforeTextChanged(
                            s: CharSequence, start: Int,
                            count: Int, after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence, start: Int,
                            before: Int, count: Int
                        ) {
                            item.text = s.toString()
                        }
                    })
                }
                mailEditText -> {
                    itemView.editTextItem.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    itemView.editTextItem.hint = item.hint
                    if (item.text.isNotEmpty()) {
                        itemView.editTextItem.setText(item.text)
                    }
                    itemView.editTextItem.addTextChangedListener(object : TextWatcher {

                        override fun afterTextChanged(s: Editable) {}

                        override fun beforeTextChanged(
                            s: CharSequence, start: Int,
                            count: Int, after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence, start: Int,
                            before: Int, count: Int
                        ) {
                            item.text = s.toString()
                        }
                    })
                }
                phoneEditTxt -> {
                    itemView.editTextItem.inputType = InputType.TYPE_CLASS_PHONE
                    itemView.editTextItem.hint = item.hint
                    if (item.text.isNotEmpty()) {
                        itemView.editTextItem.setText(item.text)
                    }
                    itemView.editTextItem.addTextChangedListener(object : TextWatcher {

                        override fun afterTextChanged(s: Editable) {}

                        override fun beforeTextChanged(
                            s: CharSequence, start: Int,
                            count: Int, after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence, start: Int,
                            before: Int, count: Int
                        ) {
                            item.text = s.toString()
                        }
                    })
                }
                passwordEditText -> {
                    itemView.editTextItem.inputType =
                        TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                    itemView.editTextItem.hint = item.hint
                    if (item.text.isNotEmpty()) {
                        itemView.editTextItem.setText(item.text)
                    }
                    itemView.editTextItem.addTextChangedListener(object : TextWatcher {

                        override fun afterTextChanged(s: Editable) {}

                        override fun beforeTextChanged(
                            s: CharSequence, start: Int,
                            count: Int, after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence, start: Int,
                            before: Int, count: Int
                        ) {
                            item.text = s.toString()
                        }
                    })

                }
                passwordHint -> {
                    itemView.passwordHint.hint = item.hint
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup, viewType: Int): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = when (viewType) {
                    1, 2, 3, 5 -> layoutInflater.inflate(R.layout.edit_text_item, parent, false)
                    4 -> layoutInflater.inflate(R.layout.password_hint, parent, false)
                    6 -> layoutInflater.inflate(R.layout.title_item, parent, false)
                    else -> layoutInflater.inflate(R.layout.title_item, parent, false)
                }
                return ViewHolder(view)
            }
        }
    }

    /*private class MyCustomEditTextListener : TextWatcher {
        private var position = 0
        fun updatePosition(position: Int) {
            this.position = position
        }

        override fun beforeTextChanged(
            charSequence: CharSequence,
            i: Int,
            i2: Int,
            i3: Int
        ) {
            // no op
        }

        override fun onTextChanged(
            charSequence: CharSequence,
            i: Int,
            i2: Int,
            i3: Int
        ) {
            data.get(position) = charSequence.toString()
        }

        override fun afterTextChanged(editable: Editable) {
            // no op
        }
    }*/
}