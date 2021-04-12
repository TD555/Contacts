package com.example.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.content.DialogInterface
import android.view.WindowManager
import android.widget.SimpleAdapter
import androidx.fragment.app.DialogFragment

class Remove_contact:DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.show()
        val lp=WindowManager.LayoutParams()
        lp.width=WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG
        lp.height=WindowManager.LayoutParams.WRAP_CONTENT
        dialog?.window?.attributes=lp
        val v=inflater.inflate(R.layout.remove_fragment,null)
        v.findViewById<Button>(R.id.button).setOnClickListener {
            deleted=true
            dialog?.dismiss()
        }
        v.findViewById<Button>(R.id.button2).setOnClickListener {
            dialog?.dismiss()
        }
        return v
    }

    override fun onDismiss(dialog: DialogInterface) {
        if(deleted)
        {
            val listView=activity?.findViewById<ListView>(R.id.list)
            val adapter = SimpleAdapter(context,arrayList,R.layout.contacts, arrayOf("Name", "Tel"),intArrayOf(R.id.textView,R.id.textView2))
            arrayList.removeAt(arguments!!.getInt("index"))
            adapter.notifyDataSetChanged()
            listView?.adapter=adapter
            deleted=false;
        }
        super.onDismiss(dialog)
    }
}