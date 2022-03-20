package dao

//TODO: clean up these imports
import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject

import models.Person
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class PersonDao @Inject() (
    protected val dbConfigProvider: DatabaseConfigProvider
)(implicit
    executionContext: ExecutionContext
) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val Persons = TableQuery[PersonsTable]

  def all(): Future[Seq[Person]] = db.run(Person.result)

  // SLICK database stuff
  private class PersonsTable(tag: Tag)
      extends Table[PersonsTable](tag, "persons") {
    def id = column[Long]("id", O.PrimaryKey)
    def username = column[String]("username")
    def age = column[Int]("age")
    def job = column[String]("job")
    def * = (id, username, age, job) <> (Person.tupled, Person.unapply)
  }
}
