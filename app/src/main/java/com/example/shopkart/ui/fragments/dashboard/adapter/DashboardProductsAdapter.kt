package com.example.shopkart.ui.fragments.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkart.data.model.Product
import com.example.shopkart.databinding.LayoutDashboardItemBinding
import com.example.shopkart.ui.fragments.product.adapter.ProductDiffCallback

/**
 * Created by Dhruv Limbachiya on 29-10-2021.
 */
class DashboardProductsAdapter : ListAdapter<Product, DashboardProductsAdapter.DashboardViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val product = getItem(position) // current product.
        holder.bind(product)
    }


    class DashboardViewHolder(val binding : LayoutDashboardItemBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Bind views with product data.
         */
        fun bind(product: Product?) {
            product?.let {
                binding.product = it // assigns product in binding product variable.
            }
        }

        companion object {

            fun from(parent: ViewGroup) : DashboardViewHolder {
                return DashboardViewHolder(
                    LayoutDashboardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                )
            }

        }
    }

}
