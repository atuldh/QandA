package services


import models.{Age, Question}
import scala.util.Try


trait AgePrompter extends Prompter with Printer {

  //Assumption made: Age can't be less than 1
  def promptAge: Age = {
    print(Question("How old are you", "<Free Text>"))
    Try(prompt).fold(_ => promptAge, age => if(age < 1) promptAge else Age(age))
  }
}
