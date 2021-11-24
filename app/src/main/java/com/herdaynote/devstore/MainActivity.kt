package com.herdaynote.devstore

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.herdaynote.devstore.data.Product
import com.herdaynote.devstore.data.ProductsData
import com.herdaynote.devstore.views.AboutActivity
import com.herdaynote.devstore.views.DetailActivity
import com.herdaynote.devstore.views.ProductAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvProducts: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProducts = findViewById(R.id.rv_products)
        rvProducts.setHasFixedSize(true)

        list.addAll(ProductsData.listData)

        showRecycler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)

        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMenu: Int) {
        when(selectedMenu) {
            R.id.profile -> {
                val activityAbout = Intent(this@MainActivity, AboutActivity::class.java)

                startActivity(activityAbout)
            }
        }
    }

    private fun showRecycler() {
        val productAdapter = ProductAdapter(list)

        rvProducts.layoutManager = LinearLayoutManager(this)
        rvProducts.adapter = productAdapter

        productAdapter.setOnItemClickCallback(object : ProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {
                val detailProduct = Intent(this@MainActivity, DetailActivity::class.java)

                detailProduct.putExtra(DetailActivity.EXTRA_NAME, data.name)
                detailProduct.putExtra(DetailActivity.EXTRA_STORAGE, data.storage)
                detailProduct.putExtra(DetailActivity.EXTRA_MEMORY, data.memory)
                detailProduct.putExtra(DetailActivity.EXTRA_DISPLAY, data.display)
                detailProduct.putExtra(DetailActivity.EXTRA_GRAPHICS, data.graphics)
                detailProduct.putExtra(DetailActivity.EXTRA_PROCESSOR, data.processor)
                detailProduct.putExtra(DetailActivity.EXTRA_OPERATING_SYSTEM, data.operatingSystem)
                detailProduct.putExtra(DetailActivity.EXTRA_DESCRIPTION, data.description)
                detailProduct.putExtra(DetailActivity.EXTRA_IMAGE, data.image)
                detailProduct.putExtra(DetailActivity.EXTRA_TYPE, data.type)
                detailProduct.putExtra(DetailActivity.EXTRA_PRICE, data.price)

                startActivity(detailProduct)
            }
        })
    }
}