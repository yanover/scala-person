package services

import models._
import play.api._
import io.jvm.uuid._
import play.api.mvc._
import play.api.libs.json._
import play.api.mvc.Results._
import scala.collection.mutable.ListBuffer

@javax.inject.Singleton
class PersonRepository {

  var persons: ListBuffer[Person] = ListBuffer(
    Person(getId, "john", 23, "Software Engineer"),
    Person(getId, "carlos", 53, "Tech Engineer"),
    Person(getId, "lucy", 22, "Software Engineer"),
    Person(getId, "margarette", 45, "Data Scientist"),
    Person(getId, "michel", 60, "Data Engineer")
  )


  def getId = UUID.random.string

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
      persons.addOne(Person(getId, username, age, job))
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
