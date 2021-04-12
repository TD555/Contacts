package com.example.contacts

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

var deleted=false
var oppened=false
var arrayList: ArrayList<HashMap<String, String>> = ArrayList()
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView=findViewById<ListView>(R.id.list)
        var map: HashMap<String, String> = HashMap()
        if(!oppened) {
            map["Name"] = "Arman"
            map["Tel"] = "099053645"
            arrayList.add(map)
            map = HashMap()
            map["Name"] = "Suren"
            map["Tel"] = "077459825"
            arrayList.add(map)
            map = HashMap()
            map["Name"] = "Karine"
            map["Tel"] = "095781265"
            arrayList.add(map)
            map = HashMap()
            map["Name"] = "Marine"
            map["Tel"] = "094251287"
            arrayList.add(map)
            oppened=true
        }
        val adapter = SimpleAdapter(this,arrayList,R.layout.contacts, arrayOf("Name", "Tel"),intArrayOf(R.id.textView,R.id.textView2))
        listView.adapter=adapter
        listView.onItemClickListener=AdapterView.OnItemClickListener { _, _, _, _ ->

        }
        listView.onItemLongClickListener= AdapterView.OnItemLongClickListener{ _, _, position, _->
            val dialog:DialogFragment=Remove_contact()
            dialog.show(supportFragmentManager,"dialog")
            val arg =Bundle()
            arg.putInt("index",position)
            dialog.arguments=arg
            true}
        listView.onItemClickListener=AdapterView.OnItemClickListener { _, _, position, _->
            val dialog:DialogFragment=Contacts_info()
            dialog.show(supportFragmentManager,"dialog")
            val arg =Bundle()
            arg.putInt("index",position)
            dialog.arguments=arg
        }
        val add=findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        add.setOnClickListener{
            val ftrans=supportFragmentManager.beginTransaction()
            val fragment=Add_contact()
            ftrans.add(R.id.layout,fragment).commit()
            ftrans.addToBackStack(null)
            findViewById<ViewGroup>(R.id.constlayout).visibility=View.INVISIBLE
        }
    }

    override fun onBackPressed() {
        findViewById<ViewGroup>(R.id.constlayout).visibility=View.VISIBLE
        super.onBackPressed()
    }
}