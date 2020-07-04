package com.learn.personal.githubuserapp.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.personal.githubuserapp.R
import com.learn.personal.githubuserapp.UserDetailActivity
import com.learn.personal.githubuserapp.databinding.ListItemUsersBinding
import com.learn.personal.githubuserapp.model.UserModel

class UserHolder (
    private val binding: ListItemUsersBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun bind (userData: UserModel) {
        binding.username.text = userData.name
        binding.userFollowers.text = "Followers: " + userData.follower
        binding.avatar.setImageResource(context.resources.getIdentifier(userData.avatar, "drawable", context.packageName))
        binding.container.setOnClickListener {
            val intent = Intent(itemView.context, UserDetailActivity::class.java)
            intent.putExtra(UserDetailActivity.DATA, userData)
            itemView.context.startActivity(intent)
        }
    }
}

class UserAdapter (
    private val dataSet: List<UserModel>,
    private val context: Context
) : RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemUsersBinding>(
            inflater,
            R.layout.list_item_users,
            parent,
            false
        )
        return UserHolder(binding, context)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) = holder.bind(dataSet[position])

}