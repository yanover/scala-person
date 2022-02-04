package models

import javax.inject.Inject
import play.api.db.Database

import scala.concurrent.Future

@javax.inject.Singleton
class PersonnesRepository @Inject() (db: Database, databaseExecutionContext: DatabaseExecutionContext) {
  def retrieve(): Unit = {
    Future {
      db.withConnection { conn =>
        // do whatever you need with the db connection
        print(conn)
      }
    }(databaseExecutionContext)
  }
}