package com.example.semarangraya

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuAdapter

class MainActivity : AppCompatActivity() {
    var adapter: MenuAdapter?= null
    var menusList = ArrayList<Menu>()
    var gridView: GridView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menusList.add(Menu("Lawang Sewu", R.drawable.lawangsewu))
        menusList.add(Menu("Kota Lama", R.drawable.kotalama))
        menusList.add(Menu("Bandungan", R.drawable.bandungan))

        adapter = MenuAdapter(this,menusList)
        gridView = findViewById(R.id.grid_view)
        gridView?.adapter = adapter

    }

    class MenuAdapter : BaseAdapter{
        var menusList = ArrayList<Menu>()
        var context : Context?= null

        constructor(context: Context, menusList : ArrayList<Menu>) : super(){
            this.context = context
            this.menusList = menusList
        }

        override fun getCount(): Int {
            return  menusList.size
        }

        override fun getItem(position: Int): Any {
            return  menusList[position]
        }

        override fun getItemId(position: Int): Long {
            return  position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
           val menu = this.menusList[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var menuView = inflater.inflate(R.layout.menu, null)
            var imageview: ImageView?=null
            var textview: TextView?=null
            imageview = convertView?.findViewById(R.id.imgmenu)
            textview = convertView?.findViewById(R.id.textmenu)
            imageview?.setImageResource(menu.image!!)
            textview?.text = menu.name!!
            return menuView


        }


    }
}