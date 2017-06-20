package services


trait Prompter {
  def prompt = scala.io.StdIn.readInt()
}
