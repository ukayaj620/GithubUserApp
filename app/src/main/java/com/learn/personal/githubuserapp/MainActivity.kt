package com.learn.personal.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learn.personal.githubuserapp.databinding.ActivityMainBinding
import com.learn.personal.githubuserapp.model.UserModel
import com.learn.personal.githubuserapp.recyclerview.adapter.UserAdapter
import com.learn.personal.githubuserapp.utils.getJsonDataFromAsset
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var userDataSet: ArrayList<UserModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_GitMe)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        supportActionBar!!.title = "GitHub"

        getUserDataViaJson()

        val adapter = UserAdapter(userDataSet, applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
    }

    private fun getUserDataViaJson () {
        val jsonFileString = getJsonDataFromAsset(applicationContext, "githubuser.json")

        val jsonFileObject: JSONObject = JSONObject(jsonFileString)

        val arrayListUserType = object : TypeToken<ArrayList<UserModel>>() {}.type
        userDataSet = Gson().fromJson(jsonFileObject.getJSONArray("users").toString(), arrayListUserType)

        userDataSet.forEachIndexed { index, user -> Log.i("data", "> Item $index:\n$user") }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}