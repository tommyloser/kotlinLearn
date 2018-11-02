package net.println.kotlin.Chapter6

import java.lang.StringBuilder

open class Tag(val name:String):Node{

    val children = ArrayList<Node>()

    val properties = HashMap<String, String>()

    operator fun String.invoke(value: String) {
        //id("html id") , id，-> property k , htmlid -> value
        properties[this] = value
    }

    operator fun String.invoke(block:Tag.() -> Unit){
        //添加该Tag 到 children
//        val tag = Tag(this)
//        children.add(tag)
//        tag.apply(block)
//        return tag
        this@Tag.children.add(Tag(this@invoke).apply(block))
//        this@invoke = string
    }

    /**
     * this @ 方法名， 对调用该方法， this 就是谁
     * this 默认就是@方法名
     * this @Tag
     */

    operator fun String.unaryPlus() {
        children.add(StringNode(this))
    }

    operator fun plus(node: Node) {
        children.add(node)
    }

    //<html is= "htmlid" style= ""><head></head></html>
    override fun render(): String {
        return StringBuilder()
                .append("<")
                .append(name)
                .let { //属性
                    stringBuilder ->
                    if (!this.properties.isEmpty()) {
                        stringBuilder.append(" ")
                        this.properties.forEach{
                            stringBuilder.append(it.key)
                                    .append("=\"")
                                    .append(it.value)
                                    .append("\" ")
                        }

                    }
                    stringBuilder
                }
                .append(">")
                .let {//子节点
                    stringBuilder ->
                    //遍历子节点， 调用子节点的render 方法， 再遍历连接子节点的string
                    children.map(Node::render).map(stringBuilder::append)
                    stringBuilder
                }
                .append("</$name>")
                .toString()
    }

}