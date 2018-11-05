package net.println.kotlin.Chapter7.ui

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import javax.swing.*

class MainWindow: JFrame() {
    private lateinit var button:JButton
    private lateinit var image: JLabel

    /**
     * 这不是构造方法， 构造方法没有fun 关键字
     */
    fun init() {
        button = JButton("点我获取腾讯网logo")
        image = JLabel()
        image.size = Dimension(132, 43)

        contentPane.add(button, BorderLayout.NORTH)
        contentPane.add(image, BorderLayout.CENTER)

    }

    fun onButtonClick(listener: (ActionEvent) -> Unit) {
        button.addActionListener(listener)
    }

    fun setLogo(logoData: ByteArray) {
        image.icon = ImageIcon(logoData)
    }
}