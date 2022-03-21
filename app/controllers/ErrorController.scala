package controllers

import javax.inject._
import play.api._
import play.api.mvc._

class ErrorController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def notfound(): Action[AnyContent] = Action {
    NotFound
  }
  
  def exception(): Action[AnyContent] = Action {
    throw new RuntimeException("Pretend that we have an application error.")
    Ok // We add this line just to make the returned type match the expected type
  }

  def internalError(): Action[AnyContent] = Action {
    InternalServerError
  }

  def badRequest(): Action[AnyContent] = Action {
    BadRequest
  }
}