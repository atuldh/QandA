package services

import models.{Age, EIGHTEEN_AND_OVER, LESS_THAN_EIGHTEEN, Question}
import org.scalatest.WordSpec


class DecisionSpec extends WordSpec with Decision{

"Check age" should {
  "return EIGHTEEN_AND_OVER(Question(\"Do you have a driving license?\", \"<Boolean>\")) if input age is equal to 18" in {
    val age = checkAge(Age(18))
    assert(age.isRight)
    assert(age == Right(EIGHTEEN_AND_OVER(Question("Do you have a driving license?", "<Boolean>"))))
  }

  "return EIGHTEEN_AND_OVER(Question(\"Do you have a driving license?\", \"<Boolean>\")) if input age is greater than to 18" in {
    val age = checkAge(Age(28))
    assert(age.isRight)
    assert(age == Right(EIGHTEEN_AND_OVER(Question("Do you have a driving license?", "<Boolean>"))))
  }

  "return LESS_THAN_EIGHTEEN(Question(\"Enter your pet name please\", \"<Free Text>\")) if input age is less than 18" in {
    val age = checkAge(Age(17))
    assert(age.isLeft)
    assert(age == Left(LESS_THAN_EIGHTEEN(Question("Enter your pet name please", "<Free Text>"))))
  }

}

}
