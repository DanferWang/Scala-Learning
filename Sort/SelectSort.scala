package Danfer.Sort

object SelectSort {
  def main(args: Array[String]): Unit = {
    //初始化数组
    var arr = Array(3, 98, 0, 5, -7)
    println("排序前数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
    //选择排序
    select(arr)
    //排序后显示
    println("\n排序后数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
  }

  def select(arr: Array[Int]): Unit = { //从大到小排序
    for (i <- 0 until arr.length) {
      var max = arr(i)
      var maxIndex = i
      var temp = 0
      for (j <- i + 1 until arr.length) {
        if (max < arr(j)) {
          max = arr(j)
          maxIndex = j
        }
      }
      if (maxIndex != i) {//加入判断是否需要移位，减少不必要交换，提高交换效率
        temp = arr(i)
        arr(i) = arr(maxIndex)
        arr(maxIndex) = temp
      }
    }
  }
}
