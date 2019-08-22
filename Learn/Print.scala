package Danfer.Learn

object Print {
  def main(args: Array[String]): Unit = {
    //the first way to print
    var str1:String="Hello"
    var str2:String=" Danfer!"
    println(str1 + str2)

    //the second way to print
    var name:String="Danfer"
    var age:Int=22
    var salary:Float=10.99f
    var height:Double=172.22
    printf("name:%s age:%d salary:%f height:%f",name,age,salary,height)

    //the third way to print
    println(s"\nname:$name \nage:$age \nsalary:${salary*10} \nheight:$height")
  }
}
