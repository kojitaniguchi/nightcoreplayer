package mediaplayer.nightcoreplayer

import java.io.File
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.media.{Media, MediaPlayer, MediaView}
import javafx.scene.paint.Color
import javafx.stage.Stage

object Main extends App {
  Application.launch(classOf[Main], args: _*)

}

class Main extends Application {

　private[this] val mediaViewFitWidth = 800
  private[this] val mediaViewFitHeight = 450
  private[this] val toolBarMinHeight = 50


  override def start(primaryStage: Stage): Unit = {
    val path = "/Users/username/Desktop/videoname.mp4"
    val media = new Media(new File(path).toURI.toString)
    val mediaPlayer = new MediaPlayer(media)
    mediaPlayer.setRate(1.25)
    mediaPlayer.play()
    val mediaView = new MediaView(mediaPlayer)
    val baseBorderPane = new BorderPane()
    baseBorderPane.setStyle("-fx-background-color: Black")
    baseBorderPane.setCenter(mediaView)
    scene.setFill(Color.BLACK)
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

trait Listener {
  def changed(newValue: Int): Unit
}

object Observable {
  private var num = 0
  private var listeners = Seq[Listener]()

  def increment(): Unit = {
    num = num + 1
    listeners.foreach(l => l.changed(num))
  }

  def addListener(listener: Listener) = listeners = listeners :+ listener
}

Observable.addListener(new Listener {
  override def changed(newValue: Int): Unit = println(s"${newValue} に変わったよ")
})

Observable.increment()
Observable.increment()
Observable.increment()
