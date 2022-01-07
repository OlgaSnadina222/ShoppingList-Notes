package com.shopinglist.activities

import android.app.Application
import com.shopinglist.db.MainDataBase

class MainApp: Application() {
    val database by lazy { MainDataBase.getDataBase(this) }
}
