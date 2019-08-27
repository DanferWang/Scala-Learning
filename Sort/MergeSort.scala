package Danfer.Sort

object MergeSort {
  def main(args: Array[String]): Unit = {
    //初始化数组
    var arr = Array(3, 98, 0, 5, -7)
    println("排序前数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
    //归并排序
    var temp = new Array[Int](arr.length) //临时数组
    mergeSort(arr, 0, arr.length - 1, temp)
    //排序后显示
    println("\n排序后数组：")
    for (i <- 0 until arr.length) {
      printf("%d\t", arr(i))
    }
  }

  //归并排序
  def mergeSort(arr: Array[Int], left: Int, right: Int, temp: Array[Int]): Unit = {
    if (left < right) {
      //一直分到单个元素
      var mid = (left + right) / 2
      mergeSort(arr, left, mid, temp)
      mergeSort(arr, mid + 1, right, temp)
      //合并
      merge(arr, left, mid, right, temp)
    }
  }

  //合并方法
  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]): Unit = {
    var i = left
    var j = mid + 1
    var t = 0
    while (i <= mid && j <= right) {
      if (arr(i) > arr(j)) { //当前左边的有序数组的值大于当前右边有序数组的值
        //复制左边数组到临时数组
        temp(t) = arr(i)
        t += 1
        i += 1
      }
      else { //当前左边有序数组的值小于或等于当前右边有序数组的值
        //复制右边数组到临时数组
        temp(t) = arr(j)
        t += 1
        j += 1
      }
    }
    while (i <= mid) { //左边数组还有剩余，依次复制到temp数组
      temp(t) = arr(i)
      t += 1
      i += 1
    }
    while (j <= right) { //右边数组还有剩余，一次复制到temp数组
      temp(t) = arr(j)
      t += 1
      j += 1
    }
    //将本次temp中的数据复制到arr中
    t = 0
    var tempLeft = left
    while (tempLeft <= right) {
      arr(tempLeft) = temp(t)
      t += 1
      tempLeft += 1
    }
  }
}
