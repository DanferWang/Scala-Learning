package Danfer.Search

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import util.control.Breaks._

object BinarySearch {
  def main(args: Array[String]): Unit = {
    var arr = Array(1, 8, 10, 89, 100, 100, 100, 1024)
    var findVar = 0
    println("请输入你想要查找的数：")
    findVar = StdIn.readInt()
    var index = binarySearch(arr, 0, arr.length - 1, findVar)
    if (index.nonEmpty) {
      for (item <- index) {
        printf("查找到%d,对应下标为：%d\n", findVar, item)
      }

    }
    else {
      println("该数不存在！")
    }
  }

  //二分查找，返回下标
  def binarySearch(arr: Array[Int], l: Int, r: Int, findVar: Int): ArrayBuffer[Int] = {
    var midIndex = (r + l) / 2
    var midVar = arr(midIndex)

    if (l > r) { //找不到
      return ArrayBuffer()
    }

    if (midVar > findVar) { //向左递归查找
      binarySearch(arr, l, midIndex - 1, findVar)
    }
    else if (midVar < findVar) { //向右边查找
      binarySearch(arr, midIndex + 1, r, findVar)
    }
    else {
      var tent = new ArrayBuffer[Int]()
      tent.append(midIndex)
      //向左边探测
      var tempLeft = midIndex - 1
      breakable {
        while (tempLeft >= 0) {
          if (arr(tempLeft) != midVar) {
            break()
          }
          else {
            tent.append(tempLeft)
            tempLeft -= 1
          }
        }
      }
      //向右边探测
      var tempRight = midIndex + 1
      breakable {
        while (tempRight <= arr.length - 1) {
          if (arr(tempRight) != midVar) {
            break()
          }
          else {
            tent.append(tempRight)
            tempRight += 1
          }
        }
      }
      return tent
    }
  }
}
