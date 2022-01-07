package com.shopinglist.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.shopinglist.databinding.DeleteDialogBinding
import com.shopinglist.databinding.NewListDialogBinding

object DeleteDialog {
    fun showDialog(context: Context, listener: Listener){
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = DeleteDialogBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
        binding.apply {
            bDelete.setOnClickListener {
                listener.onClick()
                dialog?.dismiss()
            }
            bCancel.setOnClickListener {
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
        fun onClick()
    }
}