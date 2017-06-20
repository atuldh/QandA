package services

import models.Question


trait Printer {

def print(question: Question) = {
  println(question.question)
  println(question.answerType)
}
}
