package com.learn.personal.githubuserapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.personal.githubuserapp.databinding.ActivityMainBinding
import com.learn.personal.githubuserapp.model.UserModel
import com.learn.personal.githubuserapp.recyclerview.adapter.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var userDataSet: ArrayList<UserModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_GitMe)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        getUserData()

        val adapter = UserAdapter(userDataSet)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
    }

    fun getUserData () {

        val name: Array<String> = resources.getStringArray(R.array.name)
        val username: Array<String> = resources.getStringArray(R.array.username)
        val followers: Array<String> = resources.getStringArray(R.array.followers)
        val following: Array<String> = resources.getStringArray(R.array.following)
        val location: Array<String> = resources.getStringArray(R.array.location)
        val repository: Array<String> = resources.getStringArray(R.array.repository)
        val company: Array<String> = resources.getStringArray(R.array.company)
        val avatar: TypedArray = resources.obtainTypedArray(R.array.avatar)

        val users = arrayListOf<UserModel>()

        for (position in name.indices) {
            val user = UserModel(
                username[position],
                name[position],
                avatar.getResourceId(position, -1),
                company[position],
                location[position],
                repository[position],
                "Followers: " + followers[position],
                "Following: " + following[position]
            )
            users.add(user)
        }

        userDataSet = users
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}