package com.example.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment

class Add_contact:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v=inflater.inflate(R.layout.add_fragment,null)
        val add=v.findViewById<Button>(R.id.button3)
        val cancel=v.findViewById<Button>(R.id.button4)
        val name=v.findViewById<EditText>(R.id.editTextTextPersonName)
        val phone=v.findViewById<EditText>(R.id.editTextPhone)
        name.doAfterTextChanged {
            if(name.text.isEmpty())
                add.isEnabled=false
            if(phone.text.isNotEmpty())
                add.isEnabled=true
        }
        phone.doAfterTextChanged {
            if(phone.text.isEmpty())
                add.isEnabled=false
            else if(name.text.isNotEmpty())
                add.isEnabled=true
        }
        add.setOnClickListener {
            val map: HashMap<String, String> = HashMap()
            map["Name"] = name.text.toString()
            map["Tel"]=phone.text.toString()
            arrayList.add(map)
            val list=activity?.findViewById<ListView>(R.id.list)
            val adapter = SimpleAdapter(activity,arrayList,R.layout.contacts, arrayOf("Name", "Tel"),intArrayOf(R.id.textView,R.id.textView2))
            list?.adapter=adapter
            activity!!.supportFragmentManager.beginTransaction().remove(this).commit()
            activity!!.supportFragmentManager.popBackStack()
            activity!!.findViewById<ViewGroup>(R.id.constlayout).visibility=View.VISIBLE
        }
        cancel.setOnClickListener{
            activity!!.supportFragmentManager.beginTransaction().remove(this).commit()
            activity!!.supportFragmentManager.popBackStack()
            activity!!.findViewById<ViewGroup>(R.id.constlayout).visibility=View.VISIBLE
        }
        return v
    }
}