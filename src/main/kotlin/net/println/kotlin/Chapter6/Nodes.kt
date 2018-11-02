package net.println.kotlin.Chapter6

import net.println.kotlin.getName

/**
 * html 方法 ， 创建一个html Tag, 返回tag 的作用域
 */
fun html(block:Tag.() -> Unit):Tag{
    return Tag("html").apply(block)
}

class StringNode(val name:String):Node{
    override fun render() = name
//    override fun render(): String {
//        return name
//    }

}

class Head:Tag("Head")

class Body : Tag("body") {
    //property 属性代理
    var id by MapDelegate(properties)
    //广州用`` 转换
    var `class` by MapDelegate(properties)
}

fun Tag.head(block:Head.() -> Unit){
    this@head + Head().apply(block)
}

fun Tag.body(block:Body.() -> Unit){
    //tag 运算符重载 +
    this + Body().apply(block)
//    this.children.add( Body().apply(block)) //this = html tag
//    this@body.children.add(Body().apply(block)) // this@body = html tag
}