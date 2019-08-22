package Danfer.DataStructureAlgo

import scala.io.StdIn
import util.control.Breaks._

object SingleLinkedList {
  def main(args: Array[String]): Unit = {
    var h1 = new Node(1, "Wang Haochen1", "Danfer1")
    var h2 = new Node(2, "Wang Haochen2", "Danfer2")
    var h3 = new Node(3, "Wang Haochen3", "Danfer3")
    var h4 = new Node(4, "Wang Haochen4", "Danfer4")
    //创建一个单向链表
    var singleList = new SingleList
    //  singleList.add(h1)
    //  singleList.add(h4)
    //  singleList.add(h3)
    //  singleList.add(h2)
    singleList.addWithSort(h1)
    singleList.addWithSort(h4)
    singleList.addWithSort(h3)
    singleList.addWithSort(h2)

    var h5 = new Node(3, "Shi Kexin", "Timovt")

    singleList.update(h5)

    singleList.delete(4)

    singleList.list()

    while (true) {
      println("choose one operation:")
      println("list：查看链表信息\nadd：添加结点\nadds：顺序添加结点\nupdate：更新节点信息\ndelete：删除结点\nexit:退出\n")
      var input = " "
      input = StdIn.readLine()
      input match {
        case "list" => {
          singleList.list()
        }
        case "add" => {
          println("输入结点信息：")
          println("no:")
          var hNo = StdIn.readInt()
          println("name:")
          var hName = StdIn.readLine()
          println("nickname:")
          var hNickname = StdIn.readLine()
          var hNode = new Node(hNo, hName, hNickname)
          singleList.add(hNode)
        }
        case "adds" => {
          println("输入结点信息：")
          println("no:")
          var hNo = StdIn.readInt()
          println("name:")
          var hName = StdIn.readLine()
          println("nickname:")
          var hNickname = StdIn.readLine()
          var hNode = new Node(hNo, hName, hNickname)
          singleList.addWithSort(hNode)
        }
        case "update" => {
          println("输入更新结点信息：")
          println("no:")
          var hNo = StdIn.readInt()
          println("name:")
          var hName = StdIn.readLine()
          println("nickname:")
          var hNickname = StdIn.readLine()
          var hNode = new Node(hNo, hName, hNickname)
          singleList.update(hNode)
        }
        case "delete" => {
          println("输入删除的结点序号：")
          var hNo = StdIn.readInt()
          singleList.delete(hNo)
        }
        case "exit" => {
          System.exit(0)
        }
      }
    }
  }

}

//定义单向链表管理
class SingleList {
  //初始化一个head，head一般不会动
  val head = new Node(0, " ", " ")

  //添加
  // 1、直接添加到链表尾部
  def add(hNode: Node): Unit = {
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
    temp.next = hNode
  }

  //带排序的添加结点
  def addWithSort(hNode: Node): Unit = {
    //辅助结点，将添加结点add于temp后
    var temp = head
    var flag = false //默认该编号不存在
    breakable {
      while (true) {
        if (temp.next == null) { //已经到链表最后
          break()
        }
        if (temp.next.no > hNode.no) { //从小到大排，找到位置
          break()
        }
        else if (temp.next.no == hNode.no) { //结点存在
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      printf("插入的姓名编号%d已经存在，无法加入", hNode.no)
    }
    else {
      //加入结点，注意操作顺序
      hNode.next = temp.next
      temp.next = hNode
    }
  }

  //删除节点
  def delete(hNo: Int): Unit = {
    if (head.next == null) { //链表为空
      println("链表为空")
      return
    }
    var temp = head
    var flag = false //flag标记是否索引到
    breakable {
      while (true) {
        if (temp.next == null) { //链表结尾
          println("没有找到该结点，删除失败")
          break()
        }
        if (temp.next.no == hNo) { //找到no
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) { //修改链表结构
      temp.next = temp.next.next
    }
  }

  //更新结点，以编号为索引
  def update(newNode: Node): Unit = {
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

//创建结点
class Node(hNo: Int, hName: String, hNickname: String) {
  var no: Int = hNo
  var name: String = hName
  var nickname: String = hNickname
  var next: Node = null
}