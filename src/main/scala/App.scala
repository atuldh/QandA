import models.Question
import services.{Decision, Printer, AgePrompter}


object App extends AgePrompter with Printer with Decision{

  def main(args: Array[String]): Unit = {

    print(Question("What's your name?", "<Free Text>"))

    checkAge(promptAge).fold(
        less => print(less.question),
        equalOrMore => print(equalOrMore.question)
      )
  }

}
