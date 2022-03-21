package models

import play.api.libs.json._

case class Person(id: Long, username: String, age: Int, job: String)

object Person {
  implicit val PersonWriter = new Writes[Person] {
    def writes(person: Person): JsValue = {
      Json.obj(
        "id" -> person.id,
        "username" -> person.username,
        "age" -> person.age,
        "job" -> person.job
      )
    }
  }
}

