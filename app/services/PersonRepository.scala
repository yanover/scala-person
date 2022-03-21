package services

import models._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.mvc.Results._
import scala.collection.mutable.ListBuffer

@javax.inject.Singleton
class PersonRepository {

  var persons: ListBuffer[Person] = ListBuffer(
    Person(1, "john", 23, "Software Engineer"),
    Person(2, "carlos", 53, "Tech Engineer"),
    Person(3, "lucy", 22, "Software Engineer"),
    Person(4, "margarette", 45, "Data Scientist"),
    Person(5, "michel", 60, "Data Engineer")
  )

  private def getLastId(): Long = {
    this.persons(this.persons.length-1).id + 1
  }

  def retrieve(): ListBuffer[Person] = persons

  def retrieve(id: Int): Person = {
    try {
        persons.filter(_.id == id).head
    } catch {
        case e: Exception => throw e
    }
  }

  def create(username: String, age: Int, job: String): ListBuffer[Person] = {
    if (!(persons.find(_.username == username)).isDefined) {
      persons.addOne(Person(6, username, age, job))
    }
    return persons
  }

  def delete(id: Int): ListBuffer[Person] = {
        try {
            val idx = this.persons.indexWhere(_.id  == id)
            if(idx >= 0) this.persons.remove(idx, 1)
            this.retrieve()
        } catch {
             case e: Exception => throw e
        }
  }
}
