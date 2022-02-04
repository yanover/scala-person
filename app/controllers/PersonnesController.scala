package controllers

import models._
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's personne controller.
 */
@Singleton
class PersonnesController @Inject()(
                                    val controllerComponents: ControllerComponents,
                                    val personnesService: PersonnesRepository) extends BaseController {
  
def get(id: Int) = Action { implicit request: Request[AnyContent] =>



    println(s"Getting personne $id")
    val numbers: List[Int] = List(1,2,3,4)
    Ok(Json.toJson(numbers));
  }

  def getAll() = Action { implicit request: Request[AnyContent] =>
    println(s"Getting all personnes")
    val numbers: List[Int] = List(1,2,3,4)
    Ok(Json.toJson(numbers));
  }

  def create() = Action { implicit request: Request[AnyContent] =>
    println(s"Creating personne")
    val numbers: List[Int] = List(1,2,3,4)
    Ok(Json.toJson(numbers));
  }

  def delete(id: Int) = Action { implicit request: Request[AnyContent] =>
    println(s"Delete personne $id")
    val numbers: List[Int] = List(1,2,3,4)
    Ok(Json.toJson(numbers));
  }

}



