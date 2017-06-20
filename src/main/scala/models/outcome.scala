package models

sealed trait outcome

case class EIGHTEEN_AND_OVER(question: Question) extends outcome
case class LESS_THAN_EIGHTEEN(question: Question) extends outcome


