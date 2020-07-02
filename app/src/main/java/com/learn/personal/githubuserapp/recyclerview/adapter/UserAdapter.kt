package com.learn.personal.githubuserapp.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.learn.personal.githubuserapp.R
import com.learn.personal.githubuserapp.databinding.ListItemUsersBinding
import com.learn.personal.githubuserapp.model.UserModel

class UserHolder (
    val binding: ListItemUsersBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind (userData: UserModel) {
        binding.username.text = userData.name
        binding.userFollowers.text = userData.follower
        binding.avatar.setImageResource(userData.avatar)

        binding.container.setOnClickListener {

        }
    }
}

class UserAdapter (
    private val dataSet: ArrayList<UserModel>
) : RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListItemUsersBinding>(
            inflater,
            R.layout.list_item_users,
            parent,
            false
        )
        return UserHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size


    override fun onBindViewHolder(holder: UserHolder, position: Int) = holder.bind(dataSet[position])

}