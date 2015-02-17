abstract class Check {
  def check(): String = "Checked Application Details..."
}

trait CreditCheck extends Check {
  override def check(): String = "Checked Credit..."
}

trait EmploymentCheck extends Check {
  override def check(): String = "Checked Employment..."
}

trait CriminalRecordCheck extends Check {
  override def check(): String = "Check Criminal Records..."
}

val apartmentApplication = new Check with CreditCheck with CriminalRecordCheck

println(apartmentApplication check)


abstract class Writer {
  def writeMessage(message: String)
}

trait UpperCaseWriter extends Writer {
  abstract override def writeMessage(message: String) =
    super.writeMessage(message.toUpperCase)
}

trait ProfanityFilteredWriter extends Writer {
  abstract override def writeMessage(message: String) =
    super.writeMessage(message.replace("stupid", "s-----"))
}
