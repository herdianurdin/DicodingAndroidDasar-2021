package com.herdaynote.devstore.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.herdaynote.devstore.R
import com.herdaynote.devstore.data.Product

class ProductAdapter(private val listProduct: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Product)
    }


    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImage: ImageView = itemView.findViewById(R.id.product_image)
        var productName: TextView = itemView.findViewById(R.id.product_name)
        var productDescription: TextView = itemView.findViewById(R.id.product_description)
        var productDetail: Button = itemView.findViewById(R.id.product_detail)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val product = listProduct[position]

        Glide.with(holder.itemView.context)
            .load(product.image)
            .apply(RequestOptions().override(120, 120))
            .into(holder.productImage)
        holder.productName.text = product.name
        holder.productDescription.text = product.description

        holder.productDetail.setOnClickListener { onItemClickCallback.onItemClicked(listProduct[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }
}