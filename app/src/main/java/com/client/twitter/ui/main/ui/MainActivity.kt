package com.client.twitter.ui.main.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.client.twitter.R
import com.client.twitter.data.model.Datum
import com.client.twitter.di.component.ActivityComponent
import com.client.twitter.ui.base.BaseActivity
import com.client.twitter.ui.main.adapter.TweetsAdapter
import com.client.twitter.ui.main.viewmodel.MainViewModel
import com.client.twitter.utils.common.Resource
import com.client.twitter.utils.common.Status
import com.client.twitter.utils.display.ItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>(), View.OnClickListener {

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun provideLayoutId(): Int = R.layout.activity_main

    private var listToFilter : List<Datum> = ArrayList()

    private var tweetsAdapter : TweetsAdapter? = null

    override fun setupView(savedInstanceState: Bundle?) {
       val fetchTweets =  viewModel.getTweets()
        observeTweetsAndDraw(fetchTweets)
        addTextChangeListener()
        btnSearch.setOnClickListener(this)
    }

    private fun addTextChangeListener() {
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0?.isNotEmpty()!!) {
                   setVisibility(toShowRecycler = false)
                } else {
                    setVisibility(toShowRecycler = true)
                    tweetsAdapter?.getFilteredList(listToFilter)
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun observeTweetsAndDraw(fetchTweets: LiveData<Resource<LiveData<List<Datum>>>>) {
     fetchTweets.observe(this, {
         when (it.status) {
             Status.LOADING -> {
                progressBar.visibility = View.VISIBLE
             }
             Status.SUCCESS -> {
                 progressBar.visibility = View.GONE
                 setTweetsRecycler(it?.data)
             }
             Status.ERROR -> {
                 progressBar.visibility = View.GONE
             }
         }
     })
    }

    private fun setTweetsRecycler(tweetList: LiveData<List<Datum>>?) {
        tweetList?.observe(this, {
            tweetsAdapter = TweetsAdapter(it)
            rvTweets.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = tweetsAdapter
                addItemDecoration(ItemDecorator(this@MainActivity))
                listToFilter = it
            }
        })

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnSearch -> {
                filterTweets()
            }
        }
    }

    private fun filterTweets() {
        progressBar.visibility = View.VISIBLE
        setVisibility(true)
        tweetsAdapter?.let {
            val searchText = etSearch.text.toString()
            val filteredLists = filter(searchText)
            if(filteredLists.isEmpty()){
                setVisibility(true)
                it.getFilteredList(listToFilter)
                Toast.makeText(this, "Sorry! What you just searched went out in air!! Missing", Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
            else
            it.getFilteredList(filteredLists)
            progressBar.visibility = View.GONE
        }
    }

    private fun setVisibility(toShowRecycler : Boolean) {
        if(toShowRecycler){
            clRecycler.visibility = View.VISIBLE
            clSearchLayout.visibility = View.GONE
        }
        else
        {
            clRecycler.visibility = View.GONE
            clSearchLayout.visibility = View.VISIBLE
        }
    }

    private fun filter(text: String): ArrayList<Datum> {
        val filteredList: ArrayList<Datum> = ArrayList()
        for(list in listToFilter){
            if(list.name?.toLowerCase()?.contains(text)!! || list.text?.toLowerCase()?.contains(text)!! || list.handle?.toLowerCase()?.contains(text)!!){
                filteredList.add(list)
            }
        }
        return filteredList
    }

}