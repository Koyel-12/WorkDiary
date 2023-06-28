package com.example.workdiary

class CRUDOperationModel(var itemName: String, var imageId: Int) {

    @JvmName("getItemName1")
    fun getItemName(): String {
        return itemName
    }

    @JvmName("setItemName1")
    fun setItemName(itemName: String) {
        // Update the class property with the provided value
        this.itemName = itemName
    }

    @JvmName("getImageId1")
    fun getImageId(): Int {
        return imageId
    }

    @JvmName("setImageId1")
    fun setImageId(imageId: Int) {
        // Update the class property with the provided value
        this.imageId = imageId
    }
}
