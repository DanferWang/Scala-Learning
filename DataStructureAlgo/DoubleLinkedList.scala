package Danfer.DataStructureAlgo

import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

object DoubleLinkedList {
  def main(args: Array[String]): Unit = {
    var h1 = new DoubleNode(1, "Wang Haochen1", "Danfer1")
    var h2 = new DoubleNode(2, "Wang Haochen2", "Danfer2")
    var h3 = new DoubleNode(3, "Wang Haochen3", "Danfer3")
    var h4 = new DoubleNode(4, "Wang Haochen4", "Danfer4")
    //创建一个单向链表
    var doubleList = new DoubleList
    doubleList.add(h1)
    doubleList.add(h2)
    doubleList.add(h3)
    doubleList.add(h4)
    doubleList.list()
    println("end testing of adding")

    var h5 = new DoubleNode(3, "Shi Kexin", "Timovt")
    doubleList.update(h5)
    doubleList.delete(4)
    doubleList.list()
    println("end testing of operation")

    while (true) {
      println("choose one operation:")
      println("list：查看链表信息\nadd：添加结点\nupdate：更新节点信息\ndelete：删除结点\nexit:退出\n")
      var input = " "
      input = StdIn.readLine()
      input match {
        case "list" => {
          doubleList.list()
        }
        case "add" => {
          println("输入结点信息：")
          println("no:")
          var hNo = StdIn.readInt()
          println("name:")
          var hName = StdIn.readLine()
          println("nickname:")
          var hNickname = StdIn.readLine()
          var hDoubleNode = new DoubleNode(hNo, hName, hNickname)
          doubleList.add(hDoubleNode)
        }
        case "update" => {
          println("输入更新结点信息：")
          println("no:")
          var hNo = StdIn.readInt()
          println("name:")
          var hName = StdIn.readLine()
          println("nickname:")
          var hNickname = StdIn.readLine()
          var hDoubleNode = new DoubleNode(hNo, hName, hNickname)
          doubleList.update(hDoubleNode)
        }
        case "delete" => {
          println("输入删除的结点序号：")
          var hNo = StdIn.readInt()
          doubleList.delete(hNo)
        }
        case "exit" => {
          System.exit(0)
        }
      }
    }
  }

}

class DoubleList {
  var head = new DoubleNode(0, " ", " ")

  //添加结点
  def add(hDoubleNode: DoubleNode): Unit = {
    //head不能动，因此需要一个临时结点，遍历一下
    var temp = head
    //找到链表最后
    breakable {
      while (true) {
        if (temp.next == null) { //已经到最后
          break()
        }
        //如果没有到最后
        temp = temp.next
      }
    }
    //temp指到最后，加入新结点b
    temp.next = hDoubleNode
    hDoubleNode.pre = temp
  }

  //删除节点
  def delete(hNo: Int): Unit = {
    if (head.next == null) { //链表为空
      println("链表为空")
      return
    }
    var temp = head.next
    var flag = false //flag标记是否索引到
    breakable {
      while (true) {
        if (temp == null) { //链表结尾
          println("没有找到该结点，删除失败")
          break()
        }
        if (temp.no == hNo) { //找到no
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) { //修改链表结构
      temp.pre.next = temp.next
      if (temp.next != null) {
        temp.next.pre = temp.pre
      }
    }
  }

  //更新结点，以编号为索引
  def update(newNode: DoubleNode): Unit = {
    if (head.next == null) { //若链表为空，则退出
      println("链表为空")
      return
    }
    //先找到结点
    var temp = head.next
    var flag = false
    breakable {
      while (true) {
        if (temp == null) { //链表结尾
          println("没有找到该结点，更新失败")
          break()
        }
        if (temp.no == newNode.no) { //找到
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      temp.name = newNode.name
      temp.nickname = newNode.nickname
    }
  }

  //遍历单向链表
  def list(): Unit = {
    //判断链表是否为空
    if (head.next == null) {
      println("链表为空")
      return
    }
    //head不能动，引入临时变量
    var temp = head.next
    breakable {
      while (true) {
        //判断是否到最后
        if (temp == null) {
          break()
        }
        printf("结点信息：no=%d name=%s nickname=%s\n", temp.no, temp.name, temp.nickname)
        temp = temp.next
      }
    }
  }

}

class DoubleNode(hNo: Int, hName: String, hNickname: String) {
  var no: Int = hNo
  var name: String = hName
  var nickname: String = hNickname
  var next: DoubleNode = null
  var pre: DoubleNode = null
}
