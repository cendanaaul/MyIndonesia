package com.example.myindonesia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvIndo: RecyclerView
    private val list = ArrayList<Indo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvIndo = findViewById(R.id.rv_indonesia)
        rvIndo.setHasFixedSize(true)

        list.addAll(getListIndo())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun getListIndo(): ArrayList<Indo> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataCost = resources.getStringArray(R.array.data_cost)  // Ambil data biaya
        val dataAccommodation = resources.getStringArray(R.array.data_accommodation)  // Ambil data akomodasi
        val dataFood = resources.getStringArray(R.array.data_food)  // Ambil data makanan

        val listIndo = ArrayList<Indo>()

        for (i in dataName.indices) {
            val indo = Indo(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataCost[i],  // Tambahkan biaya sesuai urutan
                dataAccommodation[i],  // Tambahkan akomodasi sesuai urutan
                dataFood[i]  // Tambahkan makanan sesuai urutan
            )
            listIndo.add(indo)
        }

        dataPhoto.recycle()  // Jangan lupa untuk recycle TypedArray
        return listIndo
    }


    private fun showRecyclerList() {
        rvIndo.layoutManager = LinearLayoutManager(this)
        val listIndoAdapter = ListIndoAdapter(list)
        rvIndo.adapter = listIndoAdapter
    }
}