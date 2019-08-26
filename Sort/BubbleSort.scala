package Danfer.Sort

object BubbleSort {
  def main(args: Array[String]): Unit = {
    //初始化数组
    var arr = Array(3, 98, 0, 5, -7)
    println("排序前数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
    //冒泡排序
    bubble(arr)
    //排序后显示
    println("\n排序后数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
  }

  def bubble(arr: Array[Int]): Unit = { //从大到小排序
    for (i <- 0 until arr.length) {
      for (j <- i + 1 until arr.length) {
        if (arr(i) < arr(j)) {
          var temp = arr(i)
          arr(i) = arr(j)
          arr(j) = temp
        }
      }
    }
  }
}
