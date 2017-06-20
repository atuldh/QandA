package services

import models._

trait Decision {

  def checkAge(age: Age): Either[LESS_THAN_EIGHTEEN, EIGHTEEN_AND_OVER] = {
    Either.cond((age.numberOfYears >= 18),
      EIGHTEEN_AND_OVER(Question("Do you have a driving license?", "<Boolean>")),
      LESS_THAN_EIGHTEEN(Question("Enter your pet name please", "<Free Text>")))
  }
}
