package com.shopinglist.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.shopinglist.R
import com.shopinglist.databinding.NewListDialogBinding

object NewListDialog {
    fun showDialog(context: Context, listener: Listener, name: String){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = NewListDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {

            //для последующего редактирования устанавливаем название списка, а если в первый раз создаем будет пустота
            edNewListName.setText(name)

            //проверяем зашли для создания нового списка или редактируем исходный
            if (name.isNotEmpty()){
                bCreate.text = context.getString(R.string.update_list)
                tvTitle.text = context.getString(R.string.update_list_name)
            }
            bCreate.setOnClickListener {
                val listName = edNewListName.text.toString()
                if (listName.isNotEmpty()){
                    listener.onClick(listName)
                }
                dialog?.dismiss()
            }
        }
        dialog = builder.create()
        // чтобы убрать стандарстоное всплавающее окно диалога и заменить на собственное
        dialog.window?.setBackgroundDrawable(null)
        dialog.show()
    }

    //для записи в базу данных
    interface Listener{
        fun onClick(name: String)
    }
}