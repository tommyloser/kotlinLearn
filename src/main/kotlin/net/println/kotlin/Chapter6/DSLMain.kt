package net.println.kotlin.Chapter6

fun main(args: Array<String>) {
    html{//html 方法 出入html tag 的作用域
         "id"("HtmlId")//String 的扩展方法
//        properties["id"] = "HtmlId"

        "head"{//tag 作用域的String 扩展方法
            "id"("headId")
        }
//        "body"{
        body{
            id = "bodyId"
            `class` = "bodyClass"
            "a"{
                "href"("https://www.baidu.com")
                +"百度" //文字内容
            }
        }
//        children.add(Tag("head"))
    }.render().let(::println)//let 传入一个T , 返回R , 即传入string, -> unit
}