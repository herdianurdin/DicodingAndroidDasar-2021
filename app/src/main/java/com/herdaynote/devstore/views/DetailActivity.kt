package com.herdaynote.devstore.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.herdaynote.devstore.R

class DetailActivity : AppCompatActivity() {
    private lateinit var productImage: ImageView
    private lateinit var productName: TextView
    private lateinit var productPrice: TextView
    private lateinit var productType: TextView
    private lateinit var productDescription: TextView
    private lateinit var productOperatingSystem: TextView
    private lateinit var productProcessor: TextView
    private lateinit var productGraphics: TextView
    private lateinit var productDisplay: TextView
    private lateinit var productMemory: TextView
    private lateinit var productStorage: TextView

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_OPERATING_SYSTEM = "extra_operating_system"
        const val EXTRA_PROCESSOR = "extra_processor"
        const val EXTRA_GRAPHICS = "extra_graphics"
        const val EXTRA_DISPLAY = "extra_display"
        const val EXTRA_MEMORY = "extra_memory"
        const val EXTRA_STORAGE = "extra_storage"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Product"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        productImage = findViewById(R.id.image)
        productName = findViewById(R.id.name)
        productPrice = findViewById(R.id.price)
        productDescription = findViewById(R.id.description)
        productType = findViewById(R.id.type)
        productOperatingSystem = findViewById(R.id.operating_system)
        productProcessor = findViewById(R.id.processor)
        productGraphics = findViewById(R.id.graphics)
        productDisplay = findViewById(R.id.display)
        productMemory = findViewById(R.id.memory)
        productStorage = findViewById(R.id.storage)

        val image = intent.getIntExtra(EXTRA_IMAGE, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val price = intent.getDoubleExtra(EXTRA_PRICE, 0.00)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val type = intent.getStringExtra(EXTRA_TYPE)
        val operatingSystem = intent.getStringExtra(EXTRA_OPERATING_SYSTEM)
        val processor = intent.getStringExtra(EXTRA_PROCESSOR)
        val graphics = intent.getStringExtra(EXTRA_GRAPHICS)
        val display = intent.getStringExtra(EXTRA_DISPLAY)
        val memory = intent.getStringExtra(EXTRA_MEMORY)
        val storage = intent.getStringExtra(EXTRA_STORAGE)

        productImage.setImageResource(image)
        productName.text = name
        productPrice.text = "$$price"
        productDescription.text = description
        productType.text = type
        productOperatingSystem.text = operatingSystem
        productProcessor.text = processor
        productGraphics.text = graphics
        productDisplay.text = display
        productMemory.text = memory
        productStorage.text = storage
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}