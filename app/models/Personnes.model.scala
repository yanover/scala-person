package models

import scala.collection.mutable.ListBuffer
import play.api.libs.json._

case class Personne(id: Long, username: String, age: Int, job: String)

case class PersonneFormData(username: String, age: Int, job: String)

object PersonneForm {

  val form = Form(
    mapping(
      "username" -> nonEmptyText,
      "age" -> number,
      "job" -> nonEmptyText
    )(PersonneFormData.apply)(PersonneFormData.unapply)
  )
}

class PersonneTableDef(tag: Tag) extends Table[Personne](tag, "personnes") {

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def username = column[String]("username")
  def age = column[Int]("age")
  def job = column[String]("job")

  override def * =
    (id, username, age, job) <> (Personne.tupled, Personne.unapply)
}

object Personnes {

  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  val personnes = TableQuery[PersonneTableDef]

  def listAll: Future[Seq[Personne]] = {
    dbConfig.db.run(personnes.result)
  }
}
