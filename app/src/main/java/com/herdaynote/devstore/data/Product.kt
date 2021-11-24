package com.herdaynote.devstore.data

data class Product(
    var name: String = "",
    var type: String = "",
    var price: Double = 0.00,
    var description: String = "",
    var operatingSystem: String = "",
    var processor: String = "",
    var graphics: String = "",
    var display: String = "",
    var memory: String = "",
    var storage: String = "",
    var image: Int = 0
)
