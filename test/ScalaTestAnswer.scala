package Danfer.test

object ScalaTestAnswer {
  def main(args: Array[String]): Unit = {
    //常用的算子的练习  map   reduce sort count filter
    var array = Array[Int](2, 4, 8, 9, 1, 3, 5, 7, 6, 0)
    //map的用法将数字全部加1输出
    val arr1: Array[Int] = array.map(x => x + 1)
    //mkstring 可以将一个数组转换成字符串还可以添加分隔符  前缀还有后缀
    println(arr1.mkString(",")) //3,5,9,10,2,4,6,8,7,1
    //测试一下mkstring,将数组分隔成字符串,每个元素中间用",分隔" 前边和后边加上"[]"
    println(arr1.mkString("[", ",", "]")) //[3,5,9,10,2,4,6,8,7,1]

    //reduce的常用用法 聚合使用 也就是将多个元素转换成一个元素
    //求数组的和
    println(arr1.reduce((x, y) => x + y)) //55
    //还有一种写法
    println(arr1.reduce(_ + _)) //55
    //求数组中的最大值
    println(array.reduce((x, y) => (if (x >= y) x else y))) //9
    //同理求最小值
    println(array.reduce((x, y) => if (x <= y) x else y)) //0


    //count 计数 求数组中所有的元素的个数
    println(array.count(x => true)) //10
    println(array.count(_ => true)) //10
    //求数组中的偶数的个数
    println(array.count(x => if (x % 2 == 0) true else false)) //5

    //filter的常规用法
    //过滤掉数组中的所有的奇数,得到所有的偶数
    println(array.filter(x => if (x % 2 == 0) true else false).mkString(","))
    //保留3的倍数的数字,但是不要0
    println(array.filter(x => if (x % 3 == 0 && x != 0) true else false).mkString(",")) //9,3,6

    //三种排序
    //sorted的用法  自然排序升序
    println(array.sorted.mkString(","))//0,1,2,3,4,5,6,7,8,9
    //sortBy
    println(array.sortBy(x=>x).mkString(","))//0,1,2,3,4,5,6,7,8,9
    //按照降序排列
    println(array.sortBy(x=> -x).mkString(","))//9,8,7,6,5,4,3,2,1,0
    //sortWith的用法
    //升序
    println(array.sortWith((x,y)=>x<y).mkString(","))//0,1,2,3,4,5,6,7,8,9
    //降序
    println(array.sortWith((x,y)=>x>y).mkString(","))//9,8,7,6,5,4,3,2,1,0

    //总和练习  求数组array的平均值
    //第一种求法  求出总和和总数进行计算
    println(array.sum*1.0/array.length)//4.5
    //第二种求法
    println(array.reduce((x,y)=>x+y)*1.0/array.count(x=>true))
    //第三种求法
    val tup1: (Int, Int) = array.map(x=>(x,1)).reduce((x,y)=>(x._1+y._1,x._2+y._2))
    val avg: Double = tup1._1*1.0/tup1._2
    println(avg)
    //还有一种就是折叠的方法
    val tup2: (Int, Int) = array.foldLeft((0,0))((x,y)=>(x._1+y,x._2+1))
    val avg1: Double = tup2._1*1D/tup2._2
    println(avg1)//4.5



    //综合练习


    //打印九九乘法表的几种方法
    //第一种
    for(i<- 1 to 9 ;j<- 1 to i)print(i+"*"+j+"="+(i*j)+{if(i==j)"\n" else "\t"})
    //第二种  可以使用占位符的方式进行打印
    for(i<- 1 to 9 ;j<- 1 to i)printf(s"${i}*${j}=${i*j}${if(i==j) "\n" else "\t"}")
    //第三种
    for(i<- 1 to 9 ;j<- 1 to i)printf("%d*%d=%d%s",i,j,i*j,{if(i==j)"\n" else "\t"})


    //wordCount
    var array_str = Array("a b c", "a b", "a")
    //计算数组中的wordCount
    val wordCount: Map[String, Int] = array_str.map(x=>x.split(" ")).flatten.groupBy(x=>x).map(x=>(x._1,x._2.length))
    println(wordCount)//Map(b -> 2, a -> 3, c -> 1)

    //还有一种使用flatMap 的方法,这种flatMap和上面的map有什么不同呢.
    //array_str.flatMap(x=>x.split(" "))将原来的数组中的元素按照x=>x.split(" ")
    // 之后生成Array[Array[Int]]=((a,b,c),(a,b),(a))  之后自动进行了压扁的操作最后生成了(a,b,c,a,b,a)
    val wordCount2: Map[String, Int] = array_str.flatMap(x=>x.split(" ")).groupBy(x=>x).map(x=>(x._1,x._2.length))
    println(wordCount2)//Map(b -> 2, a -> 3, c -> 1)
    //要求生成wordCount之后需要按照出现次数的多少进行升序排列
    val list: List[(String, Int)] = array_str.flatMap(x=>x.split(" ")).groupBy(x=>x).map(x=>(x._1,x._2.length)).toList
    println(list)//List((b,2), (a,3), (c,1))
    println(list.sortBy(x=>x._2))//List((c,1), (b,2), (a,3))
    //降序排列
    println(list.sortBy(x=> -x._2))//List((a,3), (b,2), (c,1))

    //几种常见的用法
    val list1 = List(1,2,3,-1,-2,-3)
    //保留所有的正数
    val list2: List[Int] = list1.filter(x=>if(x>=0)true else false)
    println(list2)//List(1, 2, 3)

    // 2、移除list1中的第一个负数得到List(1,2,3,-2,-3)
    var num=0
    val list3: List[Int] = list1.filter(x => {
      if (x < 0) num += 1
      !(x < 0 && num == 1)
    })
    println(list3)//List(1, 2, 3, -2, -3)
    // 3、移除除第一个负数外的所有负数List(1,2,3,-1)
    var num1=0
    list1.filter(x=>{
      if(x<0) num1+=1
      x>0||(x<0&&num1>1)
    }).foreach(x=>print(x))//123-2-3
  }
}
