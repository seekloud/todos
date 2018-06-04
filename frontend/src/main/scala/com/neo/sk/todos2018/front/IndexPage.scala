package com.neo.sk.todos2018.front

import com.neo.sk.todos2018.front.pages._
import mhtml._
import org.scalajs.dom

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.xml.{Elem, Node}
import scala.language.implicitConversions
/**
  * User: sky
  * Date: 2018/4/20
  * Time: 14:13
  */
trait Index extends Component{
  val locationHashString: String
}

trait Component {
  def render: Elem
}

object Component {
  implicit def component2Element(comp: Component): Elem = comp.render
}

//@JSExportTopLevel("frontend.Main")
object Main {

//  @JSExport
  def main(args: Array[String]): Unit = {
    MainEnter.show()
  }

}


object MainEnter extends PageSwitcher {

  val currentPage: Rx[Elem] = currentHashVar.map {
    case Nil => MainPage.render
    case _ => <div>Error Page</div>
  }

  def show(): Cancelable = {
    val page =
      <div style="height: 100%;width: 100%;">
        {currentPage}
      </div>
    switchPageByHash()
    mount(dom.document.body, {page})
  }

}
