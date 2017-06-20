package services

import models.Age
import org.scalatest.WordSpec
import org.scalatest.mockito.MockitoSugar


class AgePrompterSpec extends WordSpec with MockitoSugar{

  "Prompt age" should {

    "return Age(18) if input age is equal to 18" in {
    val agePrompter = new AgePrompter { override def prompt = {18} }
    assert(agePrompter.promptAge == Age(18))
    }

    "be called recursively (twice in this case) if input age is equal to 0 & in the end return Age as 1" in {
      val agePrompter = new AgePrompter {
        var age = 0
        override def prompt = {
          age += 1
          age
        }
      }
      assert(agePrompter.promptAge == Age(1))
    }

    "be called recursively (twice in this case) if input age is throwing an Exception & in the end return Age as 2" in {
      val agePrompter = new AgePrompter {
        var age = 0
        override def prompt = {
          try {
            if(age == 0) throw new Exception
          } finally {age += 1}
          age
        }
      }
      assert(agePrompter.promptAge == Age(2))
    }
  }

}
