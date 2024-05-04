package com.dicoding.wisata_banyumas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.wisata_banymuas.WisataBanyumas



class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<WisataBanyumas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes)
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }R.id.action_profil -> {
            val intent = Intent(this, Profil::class.java)
            startActivity(intent)
            return true
        }
            else -> return super.onOptionsItemSelected(item)
        }

        return super.onOptionsItemSelected(item)
    }

    private val getListHeroes: ArrayList<WisataBanyumas>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listWisataBanyumas = ArrayList<WisataBanyumas>()
            for (i in dataName.indices) {
                val hero = WisataBanyumas(dataName[i], dataDescription[i], dataPhoto[i])
                listWisataBanyumas.add(hero)
            }
            return listWisataBanyumas
        }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(list)
        rvHeroes.adapter = adapter

        adapter.setOnItemClickCallback(object : Adapter.OnItemClickCallback {
            override fun onItemClicked(data: WisataBanyumas) {

                val intent = Intent(this@MainActivity, DetailsWisata::class.java)
                intent.putExtra("xName",data.name)
                intent.putExtra("xPhoto",data.photo)
                intent.putExtra("xDescription",data.description)


                startActivity(intent)
            }
        })
    }

//    private fun showSelectedHero(hero: Hero) {
//
//
//        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
//    }
}