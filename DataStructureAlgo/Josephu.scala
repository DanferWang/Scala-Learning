package Danfer.DataStructureAlgo

import util.control.Breaks._

object Josephu {
  def main(args: Array[String]): Unit = {
    //创建BoyGame
    var boyGame = new BoyGame
    boyGame.addBoy(100)
    boyGame.showBoy()
    boyGame.countBoy(20, 9, 100)
  }
}

//定义Boy类
class Boy(bNo: Int) {
  var no: Int = bNo
  var next: Boy = null
}

//核心类BoyGame
class BoyGame {
  //定义初始头节点
  var first: Boy = new Boy(-1)

  //添加Boy，形成一个单向环形的链表
  //num表示Boy的数量
  def addBoy(num: Int): Unit = {
    if (num < 1) {
      println("num值不正确")
      return
    }
    //辅助指针
    var curBoy: Boy = null
    for (no <- 1 to num) {
      var boy = new Boy(no)
      if (no == 1) {
        first = boy
        first.next = first
        curBoy = first
      }
      else {
        curBoy.next = boy
        boy.next = first
        curBoy = boy
      }
    }
  }

  //开始计算，完成输出
  def countBoy(startNum: Int, modNum: Int, num: Int): Unit = {
    //参数错误
    if (first.next == null || startNum < 1 || startNum > num) {
      println("parameter wrong ,please reinput")
    }
    var helper = first
    //1、将helper定位到first前
    breakable {
      while (true) {
        if (helper.next == first) {
          break()
        }
        helper = helper.next
      }
    }
    //2、将first移动到startNum，helper同时移动
    for (i <- 0 until startNum - 1) {
      first = first.next
      helper = helper.next
    }
    //3、开始modNum
    breakable {
      while (true) {
        if (helper == first) { //只有一个人
          break()
        }
        for (i <- 0 until modNum - 1) { //每modNum循环一次
          first = first.next
          helper = helper.next
        }
        //输出出去boy的No
        printf("No of outing is %d\n", first.no)
        //删除结点
        first = first.next
        helper.next = first
      }
    }
    //while结束后只留下一个人
    printf("the last man standing is %d\n", first.no)
  }

  //遍历
  def showBoy(): Unit = {
    if (first.next == null) {
      println("没有小孩，链表为空")
      return
    }
    //first不能动，引入辅助指针
    var curBoy = first
    breakable {
      while (true) {
        printf("No. of Boy :%d\n", curBoy.no)
        if (curBoy.next == first) {
          break()
        }
        curBoy = curBoy.next
      }
    }

  }
}