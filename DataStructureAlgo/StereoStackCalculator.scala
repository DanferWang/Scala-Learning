package Danfer.DataStructureAlgo

import scala.io.StdIn
import util.control.Breaks._
import scala.language.postfixOps

object StereoStackCalculator {
  def main(args: Array[String]): Unit = {
    while (true) {
      var expression = " "

      println("input the expression you want to calculate:")
      expression = StdIn.readLine()

      var numStack = new StereoArrStackC(10) //数值栈
      var opStack = new StereoArrStackC(10) //符号栈

      var index = 0
      var num1 = 0
      var num2 = 0
      var op = 0
      var result = 0
      var ch = ' '
      var keepNum = "" //扫描时，保存上次数字ch，进行拼接
      //循环取出表达式内容
      breakable {
        while (true) {
          //扫描expression
          ch = expression.substring(index, index + 1)(0)
          if (opStack.isOp(ch)) { //如果是操作符
            if (!opStack.isEmpty()) {
              if (opStack.priority(ch) <= opStack.priority(opStack.stack(opStack.top))) { //当前符号优先级比符号栈栈顶符号低
                num1 = numStack.pop().toString.toInt
                num2 = numStack.pop().toString.toInt
                op = opStack.pop().toString.toInt
                result = numStack.cal(num1, num2, op)
                //中间结果入栈
                numStack.push(result)
                //当前符号入符号栈
                opStack.push(ch)
              }
              else { //当前符号优先级高于符号栈栈顶符号,将该符号入栈
                opStack.push(ch)
              }
            }
            else { //符号栈空，则符号直接入栈
              opStack.push(ch)
            }
          }
          else { //否则是数值
            //处理多位数
            keepNum += ch
            //如果已经是expression最后一个字符，不用判断
            if (index == expression.length - 1) {
              numStack.push(keepNum.toInt)
            }
            else {
              //判断ch下一个字符是不是数字，如果是数字则下次扫描
              if (opStack.isOp(expression.substring(index + 1, index + 2)(0))) { //如果是操作符，则直接入栈
                numStack.push(keepNum.toInt)
                keepNum = ""
              }
            }
          }
          //index后移
          index += 1
          //判断是否扫描结束
          if (index >= expression.length) {
            break()
          }
        }
      }
      //表达式被扫描完成后，执行数值栈和符号栈内操作，直至两栈为空
      breakable {
        while (true) {
          if (opStack.isEmpty()) {
            break()
          }
          //运算
          num1 = numStack.pop().toString.toInt
          num2 = numStack.pop().toString.toInt
          op = opStack.pop().toString.toInt
          result = numStack.cal(num1, num2, op)
          //中间结果入栈
          numStack.push(result)
        }
      }
      var finalResult = numStack.pop()
      printf("expression:%s = %d\n", expression, finalResult)
    }
  }

}

class StereoArrStackC(size: Int) {
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

  //判断操作符
  def isOp(value: Int): Boolean = {
    value == '+' || value == '-' || value == '*' || value == '/'
  }

  //返回运算符的优先级
  //+ - =>0  * /=>1
  def priority(op: Int): Int = {
    if (op == '*' || op == '/') {
      return 1
    }
    else if (op == '+' || op == '-') {
      return 0
    }
    else {
      return -1
    }
  }

  //计算方法
  def cal(num1: Int, num2: Int, op: Int): Int = {
    var result = 0
    op match {
      case '+' => {
        result = num1 + num2
      }
      case '-' => {
        result = num2 - num1
      }
      case '*' => {
        result = num1 * num2
      }
      case '/' => {
        result = num2 / num1
      }
    }
    return result
  }
}