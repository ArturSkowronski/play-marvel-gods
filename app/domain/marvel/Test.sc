import java.util

val list = new util.ArrayList[Any]
list add 's'
list add 1

val ref = 1
var ref2 = 2

def test(s:String) ={
  if(s.length > 1) Some("data":String) else None
}

println("data" + test("s").getOrElse("pffff"))
def max(values: Int*) = values.foldLeft(values(0)) { Math.max }
max(1,2,3,4,23,2)
