package com.example.bcsnassignment.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsnassignment.R
import com.example.bcsnassignment.model.BinanceAPIItem
import com.example.bcsnassignment.model.BinanceInterface
import com.example.bcsnassignment.viewmodel.BCSNRecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val baseURL = "https://www.binance.com/api/v3/ticker/"

class SpotFragment : Fragment() {
    private val page: Int = 1
    private val limit: Int = 10
    var myAdapter: BCSNRecyclerAdapter? = null
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spot2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewSpot = view.findViewById<RecyclerView>(R.id.recyclerViewSpot)

        recyclerViewSpot.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(myAdapter?.contextBCSN)
        recyclerViewSpot.layoutManager = linearLayoutManager
        getMyData(view, page, limit)
    }


    private fun getMyData(view: View, page: Int, limit: Int) = runBlocking {
        val nestedScroll = view.findViewById<NestedScrollView>(R.id.nestedScrollView)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        launch(Dispatchers.IO) {
            Log.d("Current thread is: ", Thread.currentThread().name)
            val retrofitBuilder =
                Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseURL)
                    .build().create(BinanceInterface::class.java)

            //next variable is to get the data from the retrofit builder object that is above.
            val retrofitData = retrofitBuilder.getData()

            retrofitData.enqueue(object : Callback<List<BinanceAPIItem>?> {
                override fun onResponse(
                    call: Call<List<BinanceAPIItem>?>,
                    response: Response<List<BinanceAPIItem>?>
                ) {
                    val responseBody = response.body()!!
                   // progressBar.visibility.run { View.GONE }
                    myAdapter = BCSNRecyclerAdapter(context!!, responseBody)
                    myAdapter?.notifyDataSetChanged()
                    val recyclerViewSpot = view.findViewById<RecyclerView>(R.id.recyclerViewSpot)
                    recyclerViewSpot.adapter = myAdapter
                }

                override fun onFailure(call: Call<List<BinanceAPIItem>?>, t: Throwable) {
                    Log.d("MainActivity", "onFailure: " + t.message)
                }
            })
        }
    }

}