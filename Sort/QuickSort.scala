package Danfer.Sort

import util.control.Breaks._

object QuickSort {
  def main(args: Array[String]): Unit = {
    //初始化数组
    var arr = Array(3, 98, 0, 5, -7)
    println("排序前数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
    //快速排序
    quickSort(0, arr.length - 1, arr)
    //排序后显示
    println("\n排序后数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
  }

  def quickSort(left: Int, right: Int, arr: Array[Int]): Unit = {
    var l = left
    var r = right
    var pivot = arr((left + right) / 2) //以中间的值分割
    var temp = 0
    breakable {
      while (l < r) { //调整位置
        while (arr(l) > pivot) { //从左边找一个比中间元素小的元素的下标
          l += 1
        }
        while (arr(r) < pivot) { //从右边找一个比中间元素大的元素的下标
          r -= 1
        }
        if (l >= r) { //交换下标探测结束
          break()
        }
        //开始交换
        temp = arr(l)
        arr(l) = arr(r)
        arr(r) = temp
        //若交换后发现下一个循环扫描的值和选取的值相等，则直接跳过这个元素
        if (arr(l) == pivot) {
          r -= 1
        }
        if (arr(r) == pivot) {
          l += 1
        }
      }
    }
    if (l == r) { //若左右相遇则不用比较继续扫描
      l += 1
      r -= 1
    }
    if (left < r) { //左边递归
      quickSort(left, r, arr)
    }
    if (right > l) { //右边递归
      quickSort(l, right, arr)
    }
  }
}
