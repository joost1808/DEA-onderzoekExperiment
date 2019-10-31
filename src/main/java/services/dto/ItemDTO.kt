package services.dto

class ItemDTO () {
    var id: Int = 0
    var name: String = ""
    var category: Array<String> = emptyArray()
    var title: String = ""

    constructor(id: Int, name: String, category: Array<String>, title: String) : this() {
        this.id = id
        this.name = name
        this.category = category
        this.title = title
    }
}