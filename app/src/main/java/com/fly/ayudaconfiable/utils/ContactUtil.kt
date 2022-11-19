package com.fly.ayudaconfiable.utils

import android.annotation.SuppressLint
import android.database.Cursor
import android.provider.ContactsContract
import com.fly.ayudaconfiable.MyApplication
import com.fly.ayudaconfiable.bean.ContactInfo

object ContactUtil {
    private  val contacts: ArrayList<ContactInfo> = ArrayList()
    @SuppressLint("Range")
    fun getContactInfoList():ArrayList<ContactInfo>{
        if(contacts.size>0) return contacts;
        try {
            val cursor: Cursor = MyApplication.application.contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)!!
            while (cursor.moveToNext()) {
                val temp = ContactInfo()
                temp.name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val time = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_LAST_UPDATED_TIMESTAMP))
                val toString = DateTool.getTimeFromLong(DateTool.FMT_DATE_TIME, time.toLong()).toString()
                temp.lastUpdateTime = toString
                temp.create_time = toString
                temp.mobile = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                contacts.add(temp)
            }
            cursor.close()
            return contacts
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return contacts
    }

    fun getContactGroup():ArrayList<String>{
        var contactGroup  = ArrayList<String>()
        try {
            val groupCursor: Cursor = MyApplication.application.contentResolver.query(
                ContactsContract.Groups.CONTENT_URI,
                null, null, null, null
            )!!
            while (groupCursor.moveToNext()) {
                contactGroup.add(groupCursor.getString(groupCursor.getColumnIndexOrThrow(ContactsContract.Groups.TITLE)))
            }
            groupCursor.close()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return contactGroup
    }
}