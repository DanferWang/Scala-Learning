package Danfer.Learn

import scala.io.StdIn

object ScoreSys {
  def main(args: Array[String]): Unit = {
    val classNum = 4
    val stuNum = 5
    var classScore = 0.0
    var score = 0.0
    var totalScore = 0.0
    var failNum = 0
    var totalFailNum = 0

    for (i <- 1 to classNum) {
      classScore = 0.0
      failNum = 0
      for (j <- 1 to stuNum) {
        printf("input class%d student%d's score: \n", i, j)
        score = StdIn.readDouble()
        if (score < 60) {
          failNum += 1
        }
        classScore += score
      }
      totalScore += classScore
      totalFailNum+=failNum
      printf("the average score of class%d is %.2f \nthe number of failing is %d\n",
        i, classScore / stuNum, failNum)
    }
    printf("\nthe totalscore is %.2f\nthe total number of failing is %d\n", totalScore / (classNum * stuNum),
      totalFailNum)
  }

}
