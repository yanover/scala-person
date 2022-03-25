package controllers

import models._
import services._
import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's person controller.
 */
@Singleton
class PersonController @Inject()(
  val controllerComponents: ControllerComponents,
  val service: PersonRepository, 
  val errorHandler: ErrorController
) extends BaseController {
                                    
  
  def get(id: Int) = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(service.retrieve(id)));
  }

  def getAll() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(service.retrieve()));
  }

  def create() = Action { implicit request: Request[AnyContent] =>
    val body: AnyContent = request.body
    val jsonBody: Option[JsValue] = body.asJson
    
    for(json <- jsonBody) {
      val username = (json \ "username").as[String]
      val age = (json \ "age").as[Int]
      val job = (json \ "job").as[String]
      service.create(username, age, job)
    }
    Ok(Json.toJson(service.retrieve()));
  }

  def delete(id: Int) = Action { implicit request: Request[AnyContent] =>
    println(s"Delete person $id")
    Ok(Json.toJson(service.delete(id)));
  }

}



