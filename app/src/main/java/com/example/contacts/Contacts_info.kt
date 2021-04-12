package com.example.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import java.util.*

class Contacts_info:DialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.show()
        val lp= WindowManager.LayoutParams()
        lp.width= WindowManager.LayoutParams.WRAP_CONTENT
        lp.height= WindowManager.LayoutParams.MATCH_PARENT
        dialog?.window?.attributes=lp
        val v=inflater.inflate(R.layout.info_fragment,null)
        val name=v.findViewById<TextView>(R.id.textView11)
        val phone=v.findViewById<TextView>(R.id.textView12)
        val type=v.findViewById<TextView>(R.id.textView13)
        val date=v.findViewById<TextView>(R.id.textView14)
        val ok=v.findViewById<Button>(R.id.button5)
        val index=arguments!!.getInt("index")
        name.text= arrayList[index]["Name"]
        phone.text= arrayList[index]["Tel"]
        if(phone.text.startsWith("010"))
            type.text="Landline"
        else if(phone.text.contains('#')||phone.text.contains('*'))
            type.text="Code"
        else type.text="Mobile"
        date.text=Calendar.getInstance().time.toString()
        ok.setOnClickListener{
            dialog!!.dismiss()
        }
        return v
    }
}