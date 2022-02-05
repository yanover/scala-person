package controllers

import models._
import javax.inject._
import play.api._
import play.api.mvc._
import service.PersonneService
import model.{Personne, PersonneForm}

class PersonneController extends Controller {

  def getAll = Action.async { implicit request =>
    PersonneService.listAll map { users =>
      Ok("TEST")
    }
  }

}
