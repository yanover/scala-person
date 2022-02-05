package models

import scala.collection.mutable.ListBuffer
import play.api.libs.json._

case class Personne(id: Long, username: String, age: Int, job: String)

object Personne {
  implicit val PersonneWriter = new Writes[Personne] {
    def writes(personne: Personne): JsValue = {
      Json.obj(
        "id" -> personne.id,
        "username" -> personne.username,
        "age" -> personne.age,
        "job" -> personne.job
      )
    }
  }
}

@javax.inject.Singleton
class PersonnesRepository {

  var personnes: ListBuffer[Personne] = ListBuffer(
    Personne(1, "john", 23, "Software Engineer"),
    Personne(2, "carlos", 53, "Tech Engineer"),
    Personne(3, "lucy", 22, "Software Engineer"),
    Personne(4, "margarette", 45, "Data Scientist"),
    Personne(5, "michel", 60, "Data Engineer")
  )

  def retrieve(): ListBuffer[Personne] = personnes

  def retrieve(id: Int): Personne = personnes.filter(p => p.id == id).head

  def create(username: String, age: Int, job: String) = {

    // Is this username already somewhere in the list ?

    personnes.find(p => p.username == username) match {
      case None => {
        personnes.addOne(
          Personne(
            personnes.last.id + 1,
            username,
            age,
            job
          )
        )
      }
      case _ => {
        print(s"Username $username already exist in the list") 
        throw new RuntimeException(s"Username $username already exist in the list")
      }
    }

  }

  def delete(id: Int): ListBuffer[Personne] = {
    personnes = personnes.filter(p => p.id != id)
    personnes
  }
}
