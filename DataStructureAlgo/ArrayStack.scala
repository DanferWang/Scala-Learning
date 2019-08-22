package Danfer.DataStructureAlgo

import scala.io.StdIn
import scala.language.postfixOps

object ArrayStack {
  def main(args: Array[String]): Unit = {
    var arrayStack = new ArrStack(10)
    var key = " "
    while (true) {
      println("show：遍历显示栈")
      println("exit：退出程序")
      println("push：入栈")
      println("pop：出栈")

      key = StdIn.readLine()
      key match {
        case "show" => arrayStack.list()
        case "exit" => System.exit(0)
        case "push" => {
          var content = 0
          println("input:")
          content = StdIn.readInt()
          arrayStack.push(content)
        }
        case "pop" => {
          var context: Any = arrayStack.pop()
          if (context.isInstanceOf[Exception]) {
            println(context.asInstanceOf[Exception].getMessage)
          }
          else {
            printf("pop out:%d\n", context)
          }
        }
      }
    }
  }

}

class ArrStack(size: Int) {
  var maxSize = size //栈的大小
  var stack = new Array[Int](maxSize)
  //栈顶，初始化为-1
  var top = -1

  //栈满
  def isFull(): Boolean = {
    top == maxSize - 1
  }

  //栈空
  def isEmpty(): Boolean = {
    top == -1
  }

  //入栈
  def push(value: Int): Unit = {
    if (isFull()) {
      println("栈满")
      return
    }
    top += 1
    stack(top) = value
  }

  //出栈
  def pop(): Any = {
    if (isEmpty()) {
      return new Exception("栈空")
    }
    var value = stack(top)
    top -= 1
    return value
  }

  //遍历
  def list(): Unit = {
    if (isEmpty()) {
      println("栈空")
      return
    }
    for (i <- 0 to top reverse) {
      printf("stack[%d]=%d\n", i, stack(i))
    }
  }

}