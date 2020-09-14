package com.example.lbapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lbapplication.CommitItemViewModel
import com.example.lbapplication.databinding.ItemCommitBinding
import javax.inject.Inject


class CommitListAdapter @Inject constructor() : RecyclerView.Adapter<ViewHolder>() {

    private var commitItemViewModelList = mutableListOf<CommitItemViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCommitBinding = ItemCommitBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemCommitBinding)
    }

    override fun getItemCount() = commitItemViewModelList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(commitItemViewModelList[position])
    }

    fun setData(commitItemViewModels: MutableList<CommitItemViewModel>) {
        commitItemViewModelList = commitItemViewModels
        notifyDataSetChanged()
    }
}

class ViewHolder(private val binding: ItemCommitBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.executePendingBindings()
    }

    fun bind(itemViewModel: CommitItemViewModel) {
        binding.itemViewModel = itemViewModel
        binding.executePendingBindings()
    }
}
