package Cw2

object Cw2 {
  def main(args: Array[String]): Unit = {

    //1
    println(1)
    def dniMatch(dzien: String): String = dzien match {
      case "Poniedziałek" | "Wtorek" | "Sroda" | "Czwartek" |"Piątek" => "Praca"
      case "Sobota" | "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }

    println("Sroda "+dniMatch("Sroda"))
    println("Sobota "+dniMatch("Sobota"))
    println("Pon "+dniMatch("Pon"))



    class KontoBankowe(InitStanKonta: Int){

      private var _stanKonta: Int = InitStanKonta
      def this() = {
        this(0)
      }
      def stanKonta = _stanKonta

      def wyplata(suma: Int): Unit ={
        _stanKonta-=suma
      }

      def wplata(suma: Int): Unit ={
        _stanKonta+=suma
      }
    }

    println(2)

    val konto=new KontoBankowe(1000)

    val konto1=new KontoBankowe()

    println("Wartość domysłna"+konto1.stanKonta)

    println("Konto "+konto.stanKonta)
    konto.wplata(100)
    println("wpłata "+konto.stanKonta)
    konto.wyplata(200)
    println("wypłata "+konto.stanKonta)

    println(3)


    case class Osoba1(val imie: String, val nazwisko: String)

    def przywitanie(osoba: Osoba1): String = osoba match {
      case Osoba1("AA","BB") => "Witaj AB"
      case Osoba1("CC","DD") => "CD"
      case _ => "Witaj "+osoba.imie +" " +osoba.nazwisko
    }
    println(przywitanie(new Osoba1("AA","BB")))
    println(przywitanie(new Osoba1("CC","DD")))
    println(przywitanie(new Osoba1("Piotr","Piotr")))


    println(4)

    def function(fun: Int => Int, liczba: Int): Int = fun(fun(fun(liczba)))

    def x2(l: Int): Int = l*l
    def div(l: Int): Int = l/2
    println(function(x2,5))
    println(function(div,99))

    println(5)



    class Osoba(val imie: String,val nazwisko: String){
      val podatek: Int=100
    }

    trait Student extends Osoba {
      override val podatek: Int = 0
    }

    trait Nauczyciel extends Pracownik {
      override val podatek: Int = 10
    }

    trait Pracownik extends Osoba {
      override val podatek: Int = 20
      private var _pensja: Int=1000
      def pensja=_pensja
      def pensja_= (nowaPensja: Int): Unit = _pensja=nowaPensja
    }

    val s1 = new Osoba("Student","S1") with Student
    println("podatek Studenta: "+s1.podatek+"%")
    val n1 = new Osoba("Nauczyciel","N1") with Nauczyciel
    println("podatek Nauczyciela: "+n1.podatek+"%")
    val p1 = new Osoba("Pracownik","N1") with Pracownik
    println("podatek Pracownika: "+p1.podatek+"%")
    val sp = new Osoba("student-Pracownik","SP") with Student with Pracownik
    println("podatek Student-Pracownik: "+sp.podatek+"%")
    val pn = new Osoba("Pracownik-Student","PN") with Pracownik with Student
    println("podatek Pracownik-Student: "+pn.podatek+"%")
  }
}