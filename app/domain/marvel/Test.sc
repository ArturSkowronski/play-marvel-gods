def myMethod(dupa: String) = s"Love me tender love me now $dupa"
def toList(dupa: String) = List(dupa)

myMethod("fire")
def sum(a: String, b: String) = a + b

//concated.toString()


val evenNumbers = List(2, 4, 6, 8, 10)
evenNumbers.foldLeft(0) { (a: Int, b:Int) => a + b }

val list = List("dupa","Dupa2")
val concated = list.foldLeft("test"){ (a:String, b:String) => sum(a, b)}
"a".exists({_ == "a"})
