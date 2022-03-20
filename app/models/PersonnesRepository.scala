package models

import play.api.libs.json._
import scala.collection.mutable.ListBuffer

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

  def create(username: String, age: Int, job: String): ListBuffer[Personne] = {

    if ((personnes.find(_.username == username)).isDefined) {
      println("Error, already eaxist")
    }

    // Add person
    personnes.addOne(Personne(5, username, age, job))

    return personnes

  }

  def delete(id: Int): ListBuffer[Personne] = {
    personnes = personnes.filter(p => p.id != id)
    personnes
  }
}
