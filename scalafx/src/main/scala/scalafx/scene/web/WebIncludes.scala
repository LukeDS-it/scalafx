/*
 * Copyright (c) 2012-2013, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.scene.web

import javafx.{ event => jfxe }
import javafx.scene.{ web => jfxsw }

object WebIncludes extends WebIncludes

trait WebIncludes {
  implicit def jfxHTMLEditor2sfx(he: jfxsw.HTMLEditor) = new HTMLEditor(he)
  implicit def jfxPopupFeatures2sfx(pf: jfxsw.PopupFeatures) = new PopupFeatures(pf)
  implicit def jfxPromptData2sfx(pd: jfxsw.PromptData) = new PromptData(pd)
  implicit def jfxWebEngine2sfx(we: jfxsw.WebEngine) = new WebEngine(we)
  implicit def jfxWebEvent2sfx[T](we: jfxsw.WebEvent[T]) = new WebEvent(we)
  implicit def jfxWebView2sfx(wv: jfxsw.WebView) = new WebView(wv)

  /**
   * Converts a Function that manipulates a [[scalafx.scene.web.WebEvent]]
   * and returns a [[scala.Any]] into a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]]
   * that manipulates a
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/web/WebEvent.html JavaFX`s WebEvent]]
   *
   * @param handler function that manipulates a ScalaFX's WebEvent
   * @return a JavaFX's EventHandler that manipulates a JavaFX's WebEvent
   */
  implicit def webEventClosureWrapper[T](handler: (WebEvent[T]) => Any) = new jfxe.EventHandler[jfxsw.WebEvent[T]] {
    def handle(event: jfxsw.WebEvent[T]) {
      handler(event)
    }
  }

}