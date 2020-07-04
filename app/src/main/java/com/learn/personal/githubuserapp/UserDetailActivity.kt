package com.learn.personal.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
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
        binding.name.text = user.name
    }
}