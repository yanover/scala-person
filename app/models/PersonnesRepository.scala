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
        "job" -> personne.job,
      )
    }
  }
}

@javax.inject.Singleton
class PersonnesRepository {

  var personnes: ListBuffer[Personne] = ListBuffer(
    new Personne(1, "john", 23, "Software Engineer"),
    new Personne(2, "carlos", 53, "Software Engineer"),
    new Personne(3, "lucy", 22, "Software Engineer"),
    new Personne(4, "margarette", 45, "Software Engineer"),
    new Personne(5, "michel", 60, "Software Engineer")
  )

  def retrieve(): ListBuffer[Personne] = personnes
  def retrieve(id: Int): Personne = personnes.filter(p => p.id == id).head
  def delete(id: Int): ListBuffer[Personne] = {
    personnes = personnes.filter(p => p.id != id)
    personnes
  }
}