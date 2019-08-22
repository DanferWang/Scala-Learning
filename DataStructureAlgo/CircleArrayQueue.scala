package Danfer.DataStructureAlgo

import scala.io.StdIn

object CircleArrayQueue {
  def main(args: Array[String]): Unit = {
    var arrQueue = new CircleArrQueue(4)
    while (true) {
      var key = " "
      println("show:显示队列")
      println("exit:退出程序")
      println("in:加入队列")
      println("out:出队列")
      key = StdIn.readLine()

      key match {
        case "show" => arrQueue.showQueue()
        case "exit" => System.exit(0)
        case "in" => arrQueue.inData()
        case "out" => arrQueue.outData()
      }
    }

  }
}

//通过取模的方式实现环形队列
class CircleArrQueue(arrMaxSize: Int) {
  //获取最大数组模拟队列的长度
  var maxSize = arrMaxSize
  //构建数组存放数据，模拟队列
  var arr = new Array[Int](maxSize)
  //指向队列头
  var front = 0
  //指向队列尾
  var rear = 0

  //判断队列是否满
  def isFull(): Boolean = {
    (rear + 1) % maxSize == front
  }

  //判断队列是否为空
  def isEmpty(): Boolean = {
    rear == front
  }

  //入队列
  def inData(): Unit = {
    if (isFull()) {
      println("队列已满，无法添加")
      return
    }
    var data = 0
    print("输入入队列的数据：")
    data = StdIn.readInt()
    arr(rear) = data
    rear = (rear + 1) % maxSize
    printf("(%d,%d)\n", front, rear)
  }

  //出队列
  def outData(): Unit = {
    if (isEmpty()) {
      println("队列中无数据")
      return
    }
    var data = 0
    data = arr(front)
    front = (front + 1) % maxSize
    printf("(%d,%d)\t", front, rear)
    printf("出队数据：%d", data)
    println()
  }

  //显示队列
  def showQueue(): Unit = {
    if (isEmpty()) {
      println("队列为空")
      return
    }
    for (i <- front until front + size()) {
      printf("arr[%d]=%d\n", i % maxSize, arr(i % maxSize))
      println()
    }
  }

  //求出当前环形队列中元素的个数
  def size(): Int = {
    (rear + maxSize - front) % maxSize
  }
}
