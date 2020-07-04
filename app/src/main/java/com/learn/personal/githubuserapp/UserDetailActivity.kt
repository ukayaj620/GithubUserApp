package com.learn.personal.githubuserapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.learn.personal.githubuserapp.databinding.ActivityUserDetailBinding
import com.learn.personal.githubuserapp.model.UserModel


class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val DATA = "this_is_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityUserDetailBinding>(
            this,
            R.layout.activity_user_detail
        )

        val user = intent.getParcelableExtra(DATA) as UserModel
        supportActionBar!!.title = "GitHub User"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.name.text = user.name
        binding.username.text = user.username
        binding.avatar.setImageResource(resources.getIdentifier(user.avatar, "drawable", packageName))
        binding.company.text = user.company
        binding.location.text = user.location
        binding.repository.text = user.repository
        binding.followers.text = user.follower
        binding.following.text = user.following
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}