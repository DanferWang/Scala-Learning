package Danfer.Search

import scala.io.StdIn
import util.control.Breaks._

object HashLinkedList {
  def main(args: Array[String]): Unit = {
    var hashTable = new HashTable(7)
    var key = " "
    while (true) {
      println("add：添加人员")
      println("list：显示人员")
      println("find：查询人员")
      println("exit：退出")

      key = StdIn.readLine()

      key match {
        case "add" => {
          println("请输入id：")
          var id = StdIn.readInt()
          println("请输入姓名：")
          var name = StdIn.readLine()
          var emp = new Emp(id, name)
          hashTable.add(emp)
        }
        case "list" => {
          hashTable.list()
        }
        case "find" => {
          println("请输入查找的id")
          var id = StdIn.readInt()
          hashTable.find(id)
        }
        case "exit" => {
          System.exit(0)
        }
      }
    }
  }
}

//创建对象类
class Emp(eId: Int, eName: String) {
  var id = eId
  var name = eName
  var next: Emp = null
}

//创建链表
class EmpLinkedList {
  var head: Emp = null

  //添加人员
  def add(emp: Emp): Unit = {
    if (head == null) { //第一个人员
      head = emp
      return
  }

    //找到链表结尾
    var cur = head
    breakable {
      while (true) {
        if (cur.next == null) {
          break()
        }
        cur = cur.next
      }
    }
    cur.next = emp
  }

  //查找
  def find(id: Int): Emp = {
    if (head == null) {
      println("链表为空")
      return null
    }
    var cur = head
    breakable {
      while (true) {
        if (cur == null) {
          break()
        }
        if (cur.id == id) {
          break()
        }
        cur = cur.next
      }
    }
    return cur
  }

  //遍历链表
  def list(i: Int): Unit = {
    if (head == null) {
      printf("链表%d为空\n", i)
      return
    }
    printf("链表%d的信息为：\t", i)
    var cur = head
    breakable {
      while (true) {
        if (cur == null) {
          break()
        }
        printf("->id=%d,name=%s", cur.id, cur.name)
        cur = cur.next
      }
    }
    println()
  }
}

//HashTable
class HashTable(var size: Int) {
  var empLinkedListArr = new Array[EmpLinkedList](size)
  //初始化
  for (i <- 0 until size) {
    empLinkedListArr(i) = new EmpLinkedList
  }

  //添加人员
  def add(emp: Emp): Unit = {
    //由hash函数确定存在哪个链表
    var empLinkedListNum = hash(emp.id)
    empLinkedListArr(empLinkedListNum).add(emp)
  }

  //查找
  def find(id: Int): Unit = {
    var empLinkedListNum = hash(id)
    var emp = empLinkedListArr(empLinkedListNum).find(id)
    if (emp != null) {
      printf("在第%d链表找到id=%d，name=%s\n", empLinkedListNum, id, emp.name)
    }
    else {
      printf("没有找到id=%d的员工\n", id)
    }
  }

  //遍历HashTable
  def list(): Unit = {
    for (i <- 0 until size) {
      empLinkedListArr(i).list(i)
    }
  }

  //hash函数
  def hash(id: Int): Int = {
    id % size
  }
}