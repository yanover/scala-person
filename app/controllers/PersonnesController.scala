package controllers

import javax.inject.Inject

// TODO: clean these up.
// SEE:  https://github.com/playframework/play-slick/blob/master/samples/basic/app/controllers/Application.scala
import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.text
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext

import models.Person
import dao.perso

class StocksController @Inject() (
    stockDao: PersonDao,
    controllerComponents: ControllerComponents
)(implicit
    executionContext: ExecutionContext
) extends AbstractController(controllerComponents) {

  // TODO find a better way to do this
  def list = Action.async {
    PersonDao.all().map { case (persons) => Ok(persons) }
  }

}
