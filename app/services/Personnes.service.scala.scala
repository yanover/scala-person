package service

import model.{Personne, Personnes}
import scala.concurrent.Future

object PersonnesService {

  def listAll: Future[Seq[User]] = {
    Personnes.listAll
  }

}
