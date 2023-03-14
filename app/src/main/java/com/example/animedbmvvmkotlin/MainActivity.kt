package com.example.animedbmvvmkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animedbmvvmkotlin.adapter.AnimeListAdapter
import com.example.animedbmvvmkotlin.databinding.ActivityMainBinding
import com.example.animedbmvvmkotlin.model.Data
import com.example.animedbmvvmkotlin.repository.AnimeRepository
import com.example.animedbmvvmkotlin.service.AnimeDbApiDataService
import com.example.animedbmvvmkotlin.service.AnimeDbRetrofitInstance
import com.example.animedbmvvmkotlin.viewmodel.AnimeMainActivityViewModel
import com.example.animedbmvvmkotlin.viewmodel.AnimeMainActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: AnimeMainActivityViewModel

    private var animeListRecycler: RecyclerView? = null
    private var animeListAdapter: AnimeListAdapter? = null
    private var ArrayList:List<Data>?=null
    private val animeRepository: AnimeRepository? = null

    private var  activityMainBinding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        val animeService=AnimeDbRetrofitInstance.getInstance().create(AnimeDbApiDataService::class.java)
        val repository=AnimeRepository(animeService)

        animeListRecycler = activityMainBinding!!.animeRc
        animeListAdapter =AnimeListAdapter()

        viewModel= ViewModelProvider(this,AnimeMainActivityViewModelFactory(repository)).get(AnimeMainActivityViewModel::class.java)
        viewModel.animeLive.observe(this,{
            animeListAdapter?.setAnimeList(it.data)
            //showOnRecyclerView();
            activityMainBinding!!.animeRc.adapter=animeListAdapter
            activityMainBinding!!.animeRc.layoutManager = LinearLayoutManager(this)
            activityMainBinding!!.animeRc.setHasFixedSize(true)
        })
    }

    private fun showOnRecyclerView() {
        animeListRecycler = activityMainBinding!!.animeRc
        animeListAdapter =AnimeListAdapter()
        activityMainBinding!!.animeRc.adapter=animeListAdapter
        activityMainBinding!!.animeRc.layoutManager = LinearLayoutManager(this)
        activityMainBinding!!.animeRc.setHasFixedSize(true)

    }
}