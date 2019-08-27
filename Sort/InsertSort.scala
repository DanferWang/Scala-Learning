package Danfer.Sort

object InsertSort {
  def main(args: Array[String]): Unit = {
    //初始化数组
    var arr = Array(3, 98, 0, 5, -7)
    println("排序前数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
    //插入排序
    insertSort(arr)
    //排序后显示
    println("\n排序后数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
  }

  def insertSort(arr: Array[Int]): Unit = {
    for (i <- 1 until arr.length) {
      var insertTemp = arr(i)//保存需要插入的数值
      var insertIndex = i - 1
      //没找到位置
      while (insertIndex >= 0 && insertTemp > arr(insertIndex)) { //从大到小排序
        arr(insertIndex + 1) = arr(insertIndex)//向后移动
        insertIndex -= 1
      }
      //找到位置
      arr(insertIndex + 1) = insertTemp
    }
  }
}
